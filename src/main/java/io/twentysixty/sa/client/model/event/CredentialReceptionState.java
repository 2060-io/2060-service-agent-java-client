package io.twentysixty.sa.client.model.event;

import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;

public enum CredentialReceptionState implements Serializable {

  /*
   Done = "done",
      Declined = "declined",
      Abandoned = "abandoned",
  */

  DONE("done"),
  DECLINED("declined"),
  ABANDONED("abandoned");

  private CredentialReceptionState(String index) {
    this.index = index;
  }

  private String index;

  public String getIndex() {
    return this.index;
  }

  public static CredentialReceptionState getEnum(String index) {
    if (index == null) return null;

    if (index.equals("done")) return DONE;
    else if (index.equals("declined")) return DECLINED;
    else if (index.equals("abandoned")) return ABANDONED;
    else return null;
  }

  @JsonValue
  public String getValue() {
    return index;
  }
}
