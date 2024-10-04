package io.twentysixty.sa.client.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContextualMenuSelect extends BaseMessage implements Serializable {

  private static final long serialVersionUID = -4666174067446573357L;
  private String selectionId;

  public String getSelectionId() {
    return selectionId;
  }

  public void setSelectionId(String selectionId) {
    this.selectionId = selectionId;
  }
}
