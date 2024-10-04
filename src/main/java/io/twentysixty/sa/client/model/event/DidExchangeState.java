package io.twentysixty.sa.client.model.event;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DidExchangeState  implements Serializable {

	/*
	export enum DidExchangeState { 
   Start = 'start', 
   InvitationSent = 'invitation-sent', 
   InvitationReceived = 'invitation-received', 
   RequestSent = 'request-sent', 
   RequestReceived = 'request-received', 
   ResponseSent = 'response-sent', 
   ResponseReceived = 'response-received', 
   Abandoned = 'abandoned', 
   Completed = 'completed', 
 }
	*/		  
			
	
	START("start"),
	INVITATION_SENT("invitation-sent"),
	INVITATION_RECEIVED("invitation-received"),
	REQUEST_SENT("request-sent"),
	REQUEST_RECEIVED("request-received"),
	RESPONSE_SENT("response-sent"),
	RESPONSE_RECEIVED("response-received"),
	ABANDONED("abandoned"),
	COMPLETED("completed"),
	TERMINATED("terminated"),
	
	;
	
	private DidExchangeState(String index){
		this.index = index;
	}

	private String index;

	public String getIndex(){
		return this.index;
	}

	public static DidExchangeState getEnum(String index){
		if (index == null)
	return null;

		if (index.equals("start")) return START;
		else if (index.equals("invitation-sent")) return INVITATION_SENT;
		else if (index.equals("invitation-received")) return INVITATION_RECEIVED;
		else if (index.equals("request-sent")) return REQUEST_SENT;
		else if (index.equals("request-received")) return REQUEST_RECEIVED;
		else if (index.equals("response-sent")) return RESPONSE_SENT;
		else if (index.equals("response-received")) return RESPONSE_RECEIVED;
		else if (index.equals("abandoned")) return ABANDONED;
		else if (index.equals("completed")) return COMPLETED;
		else if (index.equals("terminated")) return TERMINATED;
		else return null;
		
	}
	
	@JsonValue 
	public String getValue() {
		return index;
	}
			  
}
