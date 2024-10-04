package io.twentysixty.sa.client.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class ProfileMessage extends BaseMessage {

  private static final long serialVersionUID = 7632455409300337368L;

  private String displayName;
  private String displayImageUrl;
  private String displayIconUrl;
  private String description;
  private String preferredLanguage;
}
