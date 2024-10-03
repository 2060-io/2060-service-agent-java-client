package io.twentysixty.sa.client.model.message;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.twentysixty.sa.client.model.message.calls.CallAcceptRequestMessage;
import io.twentysixty.sa.client.model.message.calls.CallEndRequestMessage;
import io.twentysixty.sa.client.model.message.calls.CallOfferRequestMessage;
import io.twentysixty.sa.client.model.message.calls.CallRejectRequestMessage;
import io.twentysixty.sa.client.model.message.mrtd.MrzDataRequestMessage;
import io.twentysixty.sa.client.model.message.mrtd.MrzDataSubmitMessage;
import io.twentysixty.sa.client.util.InstantDeserializer;
import io.twentysixty.sa.client.util.InstantSerializer;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
	@Type(value = ContextualMenuRequest.class, name ="contextual-menu-request"),
	@Type(value = ContextualMenuSelect.class, name ="contextual-menu-select"),
	@Type(value = ContextualMenuUpdate.class, name ="contextual-menu-update"),
	@Type(value = CredentialIssuanceMessage.class, name ="credential-issuance"),
	@Type(value = CredentialRequestMessage.class, name ="credential-request"),
	@Type(value = CredentialReceptionMessage.class, name ="credential-reception"),
	@Type(value = IdentityProofRequestMessage.class, name ="identity-proof-request"),
	@Type(value = IdentityProofResultMessage.class, name ="identity-proof-result"),
	@Type(value = IdentityProofSubmitMessage.class, name ="identity-proof-submit"),
	@Type(value = MediaMessage.class, name ="media"),
	@Type(value = MenuDisplayMessage.class, name ="menu-display"),
	@Type(value = MenuSelectMessage.class, name ="menu-select"),
	@Type(value = ReceiptsMessage.class, name ="receipts"),
	@Type(value = TextMessage.class, name ="text"),
	@Type(value = InvitationMessage.class, name ="invitation"),
	@Type(value = ProfileMessage.class, name ="profile"),
	@Type(value = TerminateConnectionMessage.class, name ="terminate-connection"),
	@Type(value = CallAcceptRequestMessage.class, name ="call-accept"),
	@Type(value = CallEndRequestMessage.class, name ="call-end"),
	@Type(value = CallOfferRequestMessage.class, name ="call-offer"),
	@Type(value = CallRejectRequestMessage.class, name ="call-reject"),
	@Type(value = MrzDataRequestMessage.class, name ="mrz-data-request"),
	@Type(value = MrzDataSubmitMessage.class, name ="mrz-data-submit")
})
public abstract class BaseMessage implements Serializable {

	private static final long serialVersionUID = 8573230287869630604L;
	protected UUID id = null;
	private String type = null;
	private UUID connectionId = null;
	@JsonSerialize(using = InstantSerializer.class)
	@JsonDeserialize(using = InstantDeserializer.class)
	private Instant timestamp = null;
	private UUID threadId = null;


	private SerializableObject lockObj = new SerializableObject();

	public UUID getId() {
		synchronized (lockObj) {
			if (id == null) {
				id = UUID.randomUUID();
			}
		}

		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Instant getTimestamp() {
		synchronized (lockObj) {
			if (timestamp == null) {
				timestamp = Instant.now();
			}
		}
		return timestamp;
	}
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
	public UUID getThreadId() {
		return threadId;
	}
	public void setThreadId(UUID threadId) {
		this.threadId = threadId;
	}

	public UUID getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(UUID connectionId) {
		this.connectionId = connectionId;
	}


}
