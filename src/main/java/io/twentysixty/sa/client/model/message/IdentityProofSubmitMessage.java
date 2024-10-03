package io.twentysixty.sa.client.model.message;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentityProofSubmitMessage extends BaseMessage implements Serializable {

	private static final long serialVersionUID = -5772627818716475038L;
	private List<SubmitProofItem> submittedProofItems;

	public List<SubmitProofItem> getSubmittedProofItems() {
		return submittedProofItems;
	}

	public void setSubmittedProofItems(List<SubmitProofItem> submittedProofItems) {
		this.submittedProofItems = submittedProofItems;
	}
}
