package io.twentysixty.sa.client.model.message.mrtd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.List;
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
    private String documentType;
    private String documentNumber;
    private String issuingState;
    private String dateOfBirth;
    private String dateOfExpiry;
    private String sex;
    private String nationality;
    private String lastName;
    private String firstName;
    private String mrzOptionalData;
    private List<String> faceImages;
    private String nameOfHolder;
    private List<String> otherNames;
    private String personalNumber;
    private List<String> placeOfBirth;
    private List<String> permanentAddress;
    private String telephone;
    private String profession;
    private String title;
    private String personalSummary;
    private String custodyInformation;
  }
}
