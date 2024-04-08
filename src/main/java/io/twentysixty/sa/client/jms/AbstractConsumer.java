package io.twentysixty.sa.client.jms;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSConsumer;
import jakarta.jms.JMSContext;
import jakarta.jms.Message;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Queue;
import jakarta.jms.Session;

import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.smallrye.mutiny.Uni;
import io.twentysixty.sa.client.model.message.BaseMessage;
import io.twentysixty.sa.client.util.JsonUtil;


public class AbstractConsumer<M> implements ConsumerInterface<M>  {

    private ConnectionFactory connectionFactory;

	
	private Long exDelay;
	private String queueName;
	private Integer threads;
	private Boolean debug;
	
	
	
	private static final Logger logger = Logger.getLogger(AbstractConsumer.class);

	private Map<UUID,Object> lockObjs = new HashMap<UUID,Object>();
	private Map<UUID,Boolean> runnings = new HashMap<UUID,Boolean>();
	private Map<UUID,Boolean> starteds = new HashMap<UUID,Boolean>();
	private Map<UUID,JMSContext> contexts = new HashMap<UUID,JMSContext>();
	
	
	private static ExecutorService executor = Executors.newCachedThreadPool();
    
    
    protected void _onStart() {
    	
    	
    	for (int i=0; i<threads;i++) {
			logger.info("onStart: starting consumer #" + i + " for " + queueName);
			UUID uuid = UUID.randomUUID();
			starteds.put(uuid, true);
			startConsumer(uuid);
			
		}
    	
    }

    protected void _onStop() {
    	
    	this.stopConsumers();
    	
    	
    }
    
    private void stopConsumers() {
    	for (UUID uuid: lockObjs.keySet()) {
    		logger.info("stopConsumers: stopping consumer " + uuid + " for " + queueName);
    		setStoppedConsumer(uuid);
    		
    		JMSContext context = contexts.get(uuid);
    		if (context != null) context.close();
    		
    		stopConsumer(uuid);
    		lockObjs.remove(uuid);
    		
    	}
    }
    public void startConsumer(UUID uuid) {
		Uni.createFrom().item(uuid).emitOn(executor).subscribe().with(
                this::consumer, Throwable::printStackTrace
        );
	}

    
    private static Object shutdownLockObj = new Object();
    
    public void setStoppedConsumer(UUID uuid) {
    	
    	synchronized(starteds) {
			starteds.put(uuid, false);
		}
    	
    	
    }
    
    
    public void stopConsumer(UUID uuid) {
		
		
		
		
		Object lockObj = lockObjs.get(uuid);
		
		if (lockObj != null) {
			synchronized (lockObj) {
				lockObj.notifyAll();
			}
		}
		
		while (true) {
			
			Boolean running = null;
			synchronized (runnings) {
				running = runnings.get(uuid);
			}
			if (!running) {
				break;
			
			}
			synchronized (shutdownLockObj) {
				try {
					shutdownLockObj.wait(100);
				} catch (InterruptedException e) {
					
				}
				synchronized (lockObj) {
					lockObj.notifyAll();
				}
			}
		}
		
		
		logger.info("stopConsumer: stopped: " + uuid);
		
	}
    
    public Uni<Void> consumer(UUID uuid) {
    	
    	JMSContext context = null;
        Queue queue = null;
        
    	Object lockObj = new Object();
    	synchronized (lockObjs) {
    		lockObjs.put(uuid, lockObj);
    	}
    	synchronized (runnings) {
    		runnings.put(uuid, true);
    	}
    	
    	
    	long now = System.currentTimeMillis();
    	synchronized (lockObj) {
			try {
				lockObj.wait(10000l);
			} catch (InterruptedException e) {
				
			}
		}
    	
    	
    	 while (true) {
    		 Boolean started = null;
    		 synchronized(starteds) { 
    			 started = starteds.get(uuid);
    			 
    		 }
    		 if ((started == null) || (!started)) {
    			 break;
    		 }
    		 
    		 
     		if (debug) logger.info("consumer: running " + uuid);

    		 try  {
    			 
    			 if (debug) logger.info("consumer " + queueName + ": create session " + uuid );


     			if (context == null) {
     				context = getConnectionFactory().createContext(Session.SESSION_TRANSACTED);
     				contexts.put(uuid, context);
     			}
     			

     			if (debug) logger.info("consumer " + queueName + ": session created " + uuid );

     			if (queue == null) {
     				queue = context.createQueue(queueName);
     			}
     			if (debug) logger.info("consumer " + queueName + ": create consumer " + uuid );
     			JMSConsumer consumer = null;
     			String messageSelector = getMessageSelector();
     			
     			if (messageSelector != null) {
     				consumer = context.createConsumer(queue, getMessageSelector());
    		    } else {
    		    	context.createConsumer(queue);
    		    }
     			
     			

     			if (debug) logger.info("consumer " + queueName + ": waiting for message... " + uuid);

    			 
     			while (true) {
	     	    		 started = null;
	     	    		 synchronized(starteds) { 
	     	    			 started = starteds.get(uuid);
	     	    			 
	     	    		 }
	     	    		 if ((started == null) || (!started)) {
	     	    			 break;
	     	    		 }
    			 
    	           
    	            	now = System.currentTimeMillis();
    	            		
    	            		if (debug) 
    	            			logger.info("consumer: waiting for message... " + uuid + " " + (System.currentTimeMillis() - now));
        	            	
    	            		Message message = consumer.receive();
    	            		
        	                if (message != null) {
        	                	if (debug) 
        	                		logger.info("consumer: received message " + uuid + " " + (System.currentTimeMillis() - now));
            	            	
        	                	
        	                	
        	                	//BaseMessage baseMessage = null;
        	                	
        						if (message instanceof ObjectMessage) {

        							ObjectMessage objMsg = (ObjectMessage) message;
        							//baseMessage = (BaseMessage) objMsg.getObject();
        							
        							if (debug) {
            	                		try {
    										logger.info(JsonUtil.serialize(objMsg.getObject(), false));
    									} catch (JsonProcessingException e2) {
    										
    									}
            	                	}
        							try {
        								M baseMessage = (M) objMsg.getObject();
        								this.receiveMessage(baseMessage);
        								//messageResource.sendMessage(baseMessage);
        								
        								
        								context.commit();
        								if (debug) 
        									logger.info("consumer: " + queueName + " after commit "+ uuid + " " + (System.currentTimeMillis() - now));

        								
        							} catch (Exception e) {
        								try {
        									logger.warn("consumer: " + queueName + " "+ uuid + " " + (System.currentTimeMillis() - now)+ ": exception " + JsonUtil.serialize(objMsg, false), e);
        								} catch (JsonProcessingException e1) {
        									logger.warn("consumer: " + queueName + " "+ uuid + " " + (System.currentTimeMillis() - now)+ ": exception", e);
        								}
        								context.rollback();
        								//if (debug) 
        								logger.info("consumer: " + queueName + " after rollback "+ uuid + " " + (System.currentTimeMillis() - now));

        							} 
        						} else {
        							if (debug) logger.info("consumer " + queueName + " "+ uuid + " " + (System.currentTimeMillis() - now)+ ": unkown event " + message);
        							context.commit();
        						}
        	                	
        	                	
        	                }  else {
        	                	if (debug) 
        	                		logger.info("consumer: no delivered message " + uuid + " " + (System.currentTimeMillis() - now));
            	            	
        						synchronized (lockObj) {
        							try {
        								if (debug) logger.info("consumer: waiting thread " + uuid + " " + (System.currentTimeMillis() - now));
        								lockObj.wait(1000);
        							} catch (InterruptedException e1) {
        							}
        						}
        					}
    	            	
    	            	
    	                
    	            }
    	            consumer.close();
        			context.close();
        			consumer = null;
        			context = null;
    	        } catch (Exception e) {
    	        	try {
        				
        				context.close();
        			} catch (Exception e1) {

        			}
        			context = null;
        			queue = null;



        			synchronized (lockObj) {
        				try {
        					lockObj.wait(exDelay);
        				} catch (InterruptedException e1) {
        				}
        			}
    	        }
    	 }
    	 synchronized (runnings) {
    		 runnings.put(uuid, false);
    	 }
    	
    	 return Uni.createFrom().voidItem();
    }

	@Override
	public void setExDelay(Long exDelay) {
		this.exDelay = exDelay;
	}

	@Override
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	@Override
	public void setThreads(Integer threads) {
		this.threads = threads;
	}

	@Override
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	@Override
	public void receiveMessage(M message) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}
	@Override
	public String getMessageSelector() {
		return null;
	}
    
   
	
	
}