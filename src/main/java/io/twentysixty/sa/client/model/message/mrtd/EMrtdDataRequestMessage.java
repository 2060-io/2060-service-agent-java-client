package io.twentysixty.sa.client.model.message.mrtd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.twentysixty.sa.client.model.message.BaseMessage;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EMrtdDataRequestMessage extends BaseMessage {

  private static final long serialVersionUID = -2840211856886673672L;

  public static EMrtdDataRequestMessage build(UUID connectionId, UUID threadId) {
    EMrtdDataRequestMessage emrtd = new EMrtdDataRequestMessage();
    emrtd.setConnectionId(connectionId);
    emrtd.setThreadId(threadId);
    return emrtd;
  }
}
