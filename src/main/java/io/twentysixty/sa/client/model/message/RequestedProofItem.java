package io.twentysixty.sa.client.model.message;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class RequestedProofItem implements Serializable {

	private static final long serialVersionUID = -3420017005051480727L;
	private UUID id;
	private String type;

	private String description;
	private String credentialDefinitionId;
	private List<String> attributes;

	public UUID getId() {
		if (id == null) {
			id = UUID.randomUUID();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCredentialDefinitionId() {
		return credentialDefinitionId;
	}

	public void setCredentialDefinitionId(String credentialDefinitionId) {
		this.credentialDefinitionId = credentialDefinitionId;
	}

	public List<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
	}

}
