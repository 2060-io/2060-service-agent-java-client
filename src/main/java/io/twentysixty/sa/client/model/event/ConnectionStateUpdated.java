package io.twentysixty.sa.client.model.event;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConnectionStateUpdated extends Event {
	
	
	private UUID connectionId;
	private DidExchangeState state;
	public UUID getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(UUID connectionId) {
		this.connectionId = connectionId;
	}
	public DidExchangeState getState() {
		return state;
	}
	public void setState(DidExchangeState state) {
		this.state = state;
	}
	
	

}
