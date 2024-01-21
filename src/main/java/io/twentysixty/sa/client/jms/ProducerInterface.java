package io.twentysixty.sa.client.jms;

import io.twentysixty.sa.client.model.message.BaseMessage;

public interface ProducerInterface {

	
	public void setExDelay(Long exDelay);
	public void setQueueName(String queueName);
	public void setThreads(Integer threads);
	public void setDebug(Boolean debug);
	
	public void sendMessage(BaseMessage message) throws Exception;
	 
	
	 
}
