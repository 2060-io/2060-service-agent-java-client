package io.twentysixty.sa.client.jms;

import jakarta.jms.ObjectMessage;

import io.twentysixty.sa.client.model.message.BaseMessage;


public interface ConsumerInterface {

	public void setExDelay(Long exDelay);
	public void setQueueName(String queueName);
	public void setThreads(Integer threads);
	public void setDebug(boolean debug);
	
	
	public void receiveMessage(BaseMessage message) throws Exception;
	
}
