package io.twentysixty.sa.client.model.message;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CredentialIssuanceMessage extends BaseMessage implements Serializable {

	private static final long serialVersionUID = 2516235892249987546L;
	private String credentialDefinitionId;
	private List<Claim> claims;

	public String getCredentialDefinitionId() {
		return credentialDefinitionId;
	}

	public void setCredentialDefinitionId(String credentialDefinitionId) {
		this.credentialDefinitionId = credentialDefinitionId;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

}
