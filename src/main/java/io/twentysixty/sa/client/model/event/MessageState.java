package io.twentysixty.sa.client.model.event;

import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;

public enum MessageState implements Serializable {

  /*
   Created = "created",
     Submitted = "submitted",
     Received = "received",
     Viewed = "viewed",
     Deleted = "deleted"
  */

  CREATED("created"),
  SUBMITTED("submitted"),
  RECEIVED("received"),
  VIEWED("viewed"),
  DELETED("deleted"),
  ;

  private MessageState(String index) {
    this.index = index;
  }

  private String index;

  public String getIndex() {
    return this.index;
  }

  public static MessageState getEnum(String index) {
    if (index == null) return null;

    if (index.equals("created")) return CREATED;
    else if (index.equals("submitted")) return SUBMITTED;
    else if (index.equals("received")) return RECEIVED;
    else if (index.equals("viewed")) return VIEWED;
    else if (index.equals("deleted")) return DELETED;
    else return null;
  }

  @JsonValue
  public String getValue() {
    return index;
  }
}
