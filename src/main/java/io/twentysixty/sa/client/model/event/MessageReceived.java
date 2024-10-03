package io.twentysixty.sa.client.model.event;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.twentysixty.sa.client.model.message.BaseMessage;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageReceived extends Event implements Serializable {

	private static final long serialVersionUID = 8579005132408573827L;
	private BaseMessage message;

	public BaseMessage getMessage() {
		return message;
	}

	public void setMessage(BaseMessage message) {
		this.message = message;
	}

}
