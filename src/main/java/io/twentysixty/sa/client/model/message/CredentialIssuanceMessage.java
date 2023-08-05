package io.twentysixty.sa.client.model.message;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CredentialIssuanceMessage extends BaseMessage {

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
