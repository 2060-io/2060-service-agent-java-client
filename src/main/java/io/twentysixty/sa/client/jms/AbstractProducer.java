package io.twentysixty.sa.client.jms;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSProducer;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Queue;
import jakarta.jms.Session;

import org.graalvm.collections.Pair;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.twentysixty.sa.client.model.message.BaseMessage;
import io.twentysixty.sa.client.util.JsonUtil;


public abstract class AbstractProducer implements ProducerInterface {
	
	private Integer producerId = 0;
	private Integer producerCount = 8;
	
    private Map<Integer,JMSProducer> producers = new HashMap<Integer,JMSProducer>();
    private Map<Integer,JMSContext> contexts = new HashMap<Integer,JMSContext>();
    
	private static final Logger logger = Logger.getLogger(AbstractProducer.class);

	private Object contextLockObj = new Object();
    
	
	private Queue defaultQueue = null;
	private Map<UUID, Queue> queues;
    
	private ConnectionFactory connectionFactory;
	
	private Long exDelay;
	private String queueName;
	private Integer threads;
	private Boolean debug;
	
	int id = 0;
	
	
	protected Pair<Integer, Pair<JMSContext, JMSProducer>> getProducer(ConnectionFactory connectionFactory, boolean debug) {
    	JMSProducer producer = null;
    	JMSContext context = null;
    	int id = 0;
    	
    	synchronized (contextLockObj) {
			if (debug) {
    			logger.info("spool: with use contexts/producer #" + producerId);
    		}
			context = contexts.get(producerId);
			if (context == null) {
				context = connectionFactory.createContext(Session.CLIENT_ACKNOWLEDGE);
				contexts.put(producerId, context);
				
			}
			
			producer = producers.get(producerId);
			if (producer == null) {
				producer = context.createProducer();
				producers.put(producerId, producer);
				
			}
			id = producerId;
			producerId++;
			if (producerId == producerCount) {
				producerId = 0;
			}
		}
    	return Pair.create(id, Pair.create(context, producer));
    }
    
    protected void purgeAllProducers() {
    	
    	synchronized (contextLockObj) {
    		
    		for (int id=0; id<contexts.size(); id++) {
    			JMSContext context = contexts.get(id);
        		if (context != null) {
        			try {
        	   		 	context.close();
        	   		 	logger.info("purgeAllProducers: closed producer #" + id);
     		         } catch (Exception e1) {
     		         	logger.error("purgeProducer: error closing producer #" + id, e1);
     		         }
        		}
        		contexts.remove(id);
        		producers.remove(id);
    		}
    		
    		logger.info("purgeAllProducers: remaining contexts size: " + contexts.size() + " producer size: " + producers.size());

    		contexts.clear();
    		producers.clear();
    		
    		logger.info("purgeAllProducers: cleared contexts size: " + contexts.size() + " producer size: " + producers.size());
    		
    	}
    }

	public void setProducerCount(Integer producerCount) {
		this.producerCount = producerCount;
	}
	
	public void spool(BaseMessage sms, int attempt) throws Exception {
    	
    	JMSProducer producer = null;
    	JMSContext context = null;
    	Queue queue = null;
    	boolean retry = false;
    	try {
    		
    		
    		
    		Pair<Integer, Pair<JMSContext, JMSProducer>> jms = getProducer(connectionFactory, debug);
    		
    		producer = jms.getRight().getRight();
    		context = jms.getRight().getLeft();
    		id = jms.getLeft();
    		
        	
    		//if (sms.getEndpoint() != null) {
    			
    			//logger.info("context.createObjectMessage(sms) ");
            	ObjectMessage message = context.createObjectMessage(sms);
            	//logger.info("context.createObjectMessage(sms) 2 ");
            	
            	synchronized (producer) {
            		queue = this.getQueue(context, sms.getConnectionId());
            		
            		producer.send(queue, message);
                	message.acknowledge();
                	
            	}
            	
            	if (debug) {
            		try {
        				logger.info("spool: Object spooled to " + queue.getQueueName() + " " + JsonUtil.serialize(sms, false));
        			} catch (JsonProcessingException e) {
        				logger.info("spool: Object spooled to " + queue.getQueueName() + " ", e);

        			}
            	}
    		
        	
    		
    		
    	}  catch (Exception e) {

    		this.purgeAllProducers();
   			logger.error("error", e);
 			attempt++;
 			if (attempt<threads) {
 				logger.info("spool: will retry attempt #" + attempt);
 				retry = true;
 			} else {
 				throw (e);
 			}
    	}
    	
    	if (retry) this.spool(sms, attempt);
    	
    }
    
    private Queue getQueue(JMSContext context) {
    	if (defaultQueue == null) {
    		defaultQueue = context.createQueue(queueName);
    	}
    	return defaultQueue;
    }
    
    private Queue getQueue(JMSContext context, UUID conn) {
    	if (queues.get(conn) == null) {
			queues.put(conn, context.createQueue(queueName));
    	}
    	return queues.get(conn);
    }

	public void setExDelay(Long exDelay) {
		this.exDelay = exDelay;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public void setThreads(Integer threads) {
		this.threads = threads;
	}

	public void setDebug(Boolean debug) {
		this.debug = debug;
	}

	@Override
	public void sendMessage(BaseMessage message) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	
}
