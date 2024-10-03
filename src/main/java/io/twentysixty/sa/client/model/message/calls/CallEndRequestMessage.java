package io.twentysixty.sa.client.model.message.calls;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.twentysixty.sa.client.model.message.BaseMessage;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallEndRequestMessage extends BaseMessage {

	private static final long serialVersionUID = -2840211856886973682L;

}
