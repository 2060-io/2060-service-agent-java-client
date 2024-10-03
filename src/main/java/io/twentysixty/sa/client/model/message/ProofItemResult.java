package io.twentysixty.sa.client.model.message;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProofItemResult implements Serializable {

	private static final long serialVersionUID = 60618296968339124L;
	private UUID id;
	private String type;
	private ProofItemResultValue value;

	public UUID getId() {
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

	public ProofItemResultValue getValue() {
		return value;
	}

	public void setValue(ProofItemResultValue value) {
		this.value = value;
	}

}
