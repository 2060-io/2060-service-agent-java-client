package io.twentysixty.sa.client.model.message.mrtd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class EMrtdData implements Serializable {

  private static final long serialVersionUID = -5234275638176689315L;

  private Map<String, Object> raw;
  private EMrtdProcessedData processed;

  @Getter
  @Setter
  @ToString
  @JsonInclude(Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class EMrtdProcessedData {
    private ProcessedData fields;
  }

  @Getter
  @Setter
  @ToString
  @JsonInclude(Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class ProcessedData {
    private String mrzData;
    private String firstName;
    private String lastName;
    private String faceDataUrl;
    private String fingerprintDataUrl;
    private long birthDate;
    private String placeOfBirth;
    private long issuanceDate;
  }
}
