package io.twentysixty.sa.client.jms;

public interface ConsumerInterface<M> {

  public void setExDelay(Long exDelay);

  public void setQueueName(String queueName);

  public void setThreads(Integer threads);

  public void setDebug(boolean debug);

  public String getMessageSelector();

  public void receiveMessage(M message) throws Exception;
}
