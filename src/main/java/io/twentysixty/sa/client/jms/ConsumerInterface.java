package io.twentysixty.sa.client.jms;

import io.twentysixty.sa.client.model.message.BaseMessage;


public interface ConsumerInterface<M> {

	public void setExDelay(Long exDelay);
	public void setQueueName(String queueName);
	public void setThreads(Integer threads);
	public void setDebug(boolean debug);
	public String getMessageSelector();
	
	public void receiveMessage(M message) throws Exception;
	
	
}
