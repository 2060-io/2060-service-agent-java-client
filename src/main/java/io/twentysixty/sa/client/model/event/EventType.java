package io.twentysixty.sa.client.model.event;


import com.fasterxml.jackson.annotation.JsonValue;

public enum EventType {

	/*
	ConnectionState = 'connection-state-updated',
			  MessageStateUpdated = 'message-state-updated',
			  MessageReceived = 'message-received',
	*/		  
			
	
	CONNECTION_STATE_UPDATED("connection-state-updated"),
	MESSAGE_STATE_UPDATED("message-state-updated"),
	MESSAGE_RECEIVED("message-received"),
	
	;
	
	private EventType(String index){
		this.index = index;
	}

	private String index;

	public String getIndex(){
		return this.index;
	}

	public static EventType getEnum(String index){
		if (index == null)
	return null;

		if (index.equals("connection-state-updated")) return CONNECTION_STATE_UPDATED;
		else if (index.equals("message-state-updated")) return MESSAGE_STATE_UPDATED;
		else if (index.equals("message-received")) return MESSAGE_RECEIVED;
		else return null;
		
	}
	
	@JsonValue 
	public String getValue() {
		return index;
	}
			  
}
