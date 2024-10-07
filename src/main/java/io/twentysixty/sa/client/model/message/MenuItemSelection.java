package io.twentysixty.sa.client.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuItemSelection implements Serializable {

  private static final long serialVersionUID = -6326294105243347432L;
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
