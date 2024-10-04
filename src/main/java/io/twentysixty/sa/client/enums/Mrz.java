package io.twentysixty.sa.client.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class Mrz {
  public enum Format {
    @JsonProperty("TD1")
    TD1,
    @JsonProperty("TD2")
    TD2,
    @JsonProperty("TD3")
    TD3,
    @JsonProperty("FRENCH_NATIONAL_ID")
    FRENCH_NATIONAL_ID,
    @JsonProperty("FRENCH_DRIVING_LICENSE")
    FRENCH_DRIVING_LICENSE,
    @JsonProperty("SWISS_DRIVING_LICENSE")
    SWISS_DRIVING_LICENSE;
  }

  public enum FieldName {
    @JsonProperty("administrativeCode")
    ADMINISTRATIVE_CODE,
    @JsonProperty("administrativeCode2")
    ADMINISTRATIVE_CODE2,
    @JsonProperty("birthDate")
    BIRTH_DATE,
    @JsonProperty("birthDateCheckDigit")
    BIRTH_DATE_CHECK_DIGIT,
    @JsonProperty("compositeCheckDigit")
    COMPOSITE_CHECK_DIGIT,
    @JsonProperty("documentNumber")
    DOCUMENT_NUMBER,
    @JsonProperty("documentNumberCheckDigit")
    DOCUMENT_NUMBER_CHECK_DIGIT,
    @JsonProperty("documentCode")
    DOCUMENT_CODE,
    @JsonProperty("expirationDate")
    EXPIRATION_DATE,
    @JsonProperty("expirationDateCheckDigit")
    EXPIRATION_DATE_CHECK_DIGIT,
    @JsonProperty("firstName")
    FIRST_NAME,
    @JsonProperty("issueDate")
    ISSUE_DATE,
    @JsonProperty("issuingState")
    ISSUING_STATE,
    @JsonProperty("languageCode")
    LANGUAGE_CODE,
    @JsonProperty("lastName")
    LAST_NAME,
    @JsonProperty("nationality")
    NATIONALITY,
    @JsonProperty("optional")
    OPTIONAL,
    @JsonProperty("optional1")
    OPTIONAL1,
    @JsonProperty("optional2")
    OPTIONAL2,
    @JsonProperty("personalNumber")
    PERSONAL_NUMBER,
    @JsonProperty("personalNumberCheckDigit")
    PERSONAL_NUMBER_CHECK_DIGIT,
    @JsonProperty("pinCode")
    PIN_CODE,
    @JsonProperty("sex")
    SEX,
    @JsonProperty("versionNumber")
    VERSION_NUMBER;
  }
}
