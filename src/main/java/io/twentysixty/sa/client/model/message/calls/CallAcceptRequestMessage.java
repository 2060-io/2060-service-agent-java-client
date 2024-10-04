package io.twentysixty.sa.client.model.message.calls;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.twentysixty.sa.client.model.message.BaseMessage;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class CallAcceptRequestMessage extends BaseMessage {

  private static final long serialVersionUID = -2840211856886973682L;

  private Map<String, Object> parameters;
}
