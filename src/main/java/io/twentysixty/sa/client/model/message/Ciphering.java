package io.twentysixty.sa.client.model.message;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Ciphering implements Serializable {

  private static final long serialVersionUID = -8660299956191649637L;
  private String algorithm;
  private Parameters parameters;
}
