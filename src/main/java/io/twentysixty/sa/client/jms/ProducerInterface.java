package io.twentysixty.sa.client.jms;

import java.io.Serializable;

public interface ProducerInterface<M extends Serializable> {

  public void setExDelay(Long exDelay);

  public void setQueueName(String queueName);

  public void setThreads(Integer threads);

  public void setDebug(Boolean debug);

  public void sendMessage(M message) throws Exception;
}
