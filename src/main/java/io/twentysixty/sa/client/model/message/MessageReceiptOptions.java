package io.twentysixty.sa.client.model.message;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.twentysixty.sa.client.model.event.MessageState;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageReceiptOptions  implements Serializable {

	private static final long serialVersionUID = 449398087181657974L;
	private UUID messageId;
	private MessageState state;
	private Instant timestamp;

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
	public Instant getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

}
