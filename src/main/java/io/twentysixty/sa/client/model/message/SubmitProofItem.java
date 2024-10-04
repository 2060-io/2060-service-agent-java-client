package io.twentysixty.sa.client.model.message;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmitProofItem  implements Serializable {

	private static final long serialVersionUID = 2574481615814359423L;
	private UUID proofExchangeId;
	private String type;
	private Boolean verified;
	private List<Claim> claims;
	public UUID getProofExchangeId() {
		return proofExchangeId;
	}
	public void setProofExchangeId(UUID proofExchangeId) {
		this.proofExchangeId = proofExchangeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getVerified() {
		return verified;
	}
	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	public List<Claim> getClaims() {
		return claims;
	}
	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}


}
