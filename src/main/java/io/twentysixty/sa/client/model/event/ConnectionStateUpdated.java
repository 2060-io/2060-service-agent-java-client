package io.twentysixty.sa.client.model.event;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConnectionStateUpdated extends Event implements Serializable {

	private static final long serialVersionUID = -2518124661250013725L;
	private UUID connectionId;
	private DidExchangeState state;
	private UUID invitationId;

	public UUID getInvitationId() {
		return invitationId;
	}

	public void setInvitationId(UUID invitationId) {
		this.invitationId = invitationId;
	}

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
