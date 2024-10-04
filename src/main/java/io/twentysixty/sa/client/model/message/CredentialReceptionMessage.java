package io.twentysixty.sa.client.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.twentysixty.sa.client.model.event.CredentialReceptionState;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CredentialReceptionMessage extends BaseMessage implements Serializable {

  private static final long serialVersionUID = 9137654378945678321L;
  private CredentialReceptionState state;

  public CredentialReceptionState getState() {
    return state;
  }

  public void setState(CredentialReceptionState state) {
    this.state = state;
  }
}
