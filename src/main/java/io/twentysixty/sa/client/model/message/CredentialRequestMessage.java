package io.twentysixty.sa.client.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CredentialRequestMessage extends BaseMessage implements Serializable {

  private static final long serialVersionUID = 5136530051273882680L;
  private UUID credentialDefinitionId;
  private List<Claim> claims;

  public UUID getCredentialDefinitionId() {
    return credentialDefinitionId;
  }

  public void setCredentialDefinitionId(UUID credentialDefinitionId) {
    this.credentialDefinitionId = credentialDefinitionId;
  }

  public List<Claim> getClaims() {
    return claims;
  }

  public void setClaims(List<Claim> claims) {
    this.claims = claims;
  }
}
