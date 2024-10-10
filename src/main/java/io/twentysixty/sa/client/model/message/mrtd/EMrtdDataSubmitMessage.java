package io.twentysixty.sa.client.model.message.mrtd;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.twentysixty.sa.client.model.message.BaseMessage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class EMrtdDataSubmitMessage extends BaseMessage {

  private static final long serialVersionUID = -2840411856886673672L;

  private Map<String, Object> dataGroups;
}
