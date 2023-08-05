package io.twentysixty.sa.client.model.message;

import java.util.UUID;


public class TextMessage extends BaseMessage {

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TextMessage clone() {
		TextMessage clone = new TextMessage();
		clone.setContent(content);
		return clone;
	}
	
	public static TextMessage build(UUID connectionId, UUID threadId, String text) {

		TextMessage textMessage = new TextMessage();
		
		textMessage.setConnectionId(connectionId);
		textMessage.setContent(text);
		textMessage.setId(UUID.randomUUID());
		textMessage.setThreadId(threadId);
		
		
		return textMessage;
		
		
	}
}
