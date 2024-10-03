package io.twentysixty.sa.client.model.message;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentityProofRequestMessage extends BaseMessage implements Serializable {

	private static final long serialVersionUID = 184932976790362365L;
	private List<RequestedProofItem> requestedProofItems;

	public List<RequestedProofItem> getRequestedProofItems() {
		return requestedProofItems;
	}

	public void setRequestedProofItems(List<RequestedProofItem> requestedProofItems) {
		this.requestedProofItems = requestedProofItems;
	}

}
