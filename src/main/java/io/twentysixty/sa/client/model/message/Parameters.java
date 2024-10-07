package io.twentysixty.sa.client.model.message;

import java.io.Serializable;

public class Parameters implements Serializable {

  private static final long serialVersionUID = -3591319454008944749L;
  private String key;
  private String iv;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getIv() {
    return iv;
  }

  public void setIv(String iv) {
    this.iv = iv;
  }

  @Override
  public String toString() {
    return "Parameters [key=" + key + ", iv=" + iv + "]";
  }
}
