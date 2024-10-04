package io.twentysixty.sa.client.model.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageStateUpdated extends Event implements Serializable {

  private UUID messageId;
  private UUID connectionId;
  private MessageState state;

  public UUID getMessageId() {
    return messageId;
  }

  public void setMessageId(UUID messageId) {
    this.messageId = messageId;
  }

  public MessageState getState() {
    return state;
  }

  public void setState(MessageState state) {
    this.state = state;
  }

  public UUID getConnectionId() {
    return connectionId;
  }

  public void setConnectionId(UUID connectionId) {
    this.connectionId = connectionId;
  }
}
