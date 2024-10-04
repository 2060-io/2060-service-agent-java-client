package io.twentysixty.sa.client.util.testing;

import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.twentysixty.sa.client.model.message.BaseMessage;
import io.twentysixty.sa.client.model.message.TextMessage;
import io.twentysixty.sa.client.util.JsonUtil;

public class Tryme {

	public static void main(String[] args) throws JsonProcessingException {
		TextMessage textMessage = new TextMessage();
		
		textMessage.setConnectionId(UUID.randomUUID());
		textMessage.setId(UUID.randomUUID());
		textMessage.setThreadId(UUID.randomUUID());
		textMessage.setTimestamp(Instant.now());
		System.out.println(JsonUtil.serialize((BaseMessage)textMessage, true));
		
	}

}
