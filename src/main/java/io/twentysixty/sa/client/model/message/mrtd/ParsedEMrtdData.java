package io.twentysixty.sa.client.model.message.mrtd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParsedEMrtdData {
  private DecodedCom com;
  private String mrzData;
  private List<DecodedImage> images;
  private List<DecodedFingerprint> fingerprints;
  private List<DecodedIris> iris;
  private List<byte[]> displayedImages;
  private List<byte[]> signatureImages;
  private DecodedAdditionalPersonalData additionalPersonalData;
  private DecodedAdditionalDocumentData additionalDocumentData;
  private Map<String, Object> securityInfos;
  private Map<String, Object> subjectPublicKeyInfo;
  private DecodedSecurtyObjectOfDocument securityObjectOfDocument;
  private CSCAMasterList cscaMasterList;

  @Getter
  @Setter
  @JsonInclude(Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  abstract static class AbstractBioTemplate {
    // Standart Biometric Header. Described by ICAO 9303 p.10 section 4.7.2.1
    private Map<String, Object> sbh;
    // Length of record
    private int lengthOfRecord;
    // Image Data Type
    private int imageType;
    // Image width
    private int imageWidth;
    // Image height
    private int imageHeight;
    // Image quality
    private int quality;
    // Raw image data
    private Buffer imageData;

    public byte[] convertToByte() {
      return this.bufferToByte(imageData);
    }

    private byte[] bufferToByte(Buffer buffer) {
      if (buffer.getData() != null) {
        return buffer.getData();
      }
      return null;
    }
  }

  @Getter
  @Setter
  @JsonInclude(Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class DecodedCom {
    // Version of LDS structure
    private String ldsVersion;
    // Version of Unicode table
    private String unicodeVersion;
    // Datagroups defined in MRTD
    private Buffer tags;
  }

  @Getter
  @Setter
  @JsonInclude(Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class DecodedImage extends AbstractBioTemplate {
    // Number of facial images
    private int numberOfFacialImages;
    // Length of facial record data
    private int facialRecordDataLength;
    // Number of control points
    private int nrFeaturePoints;
    // Gender
    private int gender;
    // Eye color
    private int eyeColor;
    // Hair color
    private int hairColor;
    // Features Mask
    private int featureMask;
    // Facial expression
    private int expression;
    // Angular coordinates
    private int poseAngle;
    // Error of angular coordinates
    private int poseAngleUncertainty;
    // Type of face image
    private int faceImageType;
    // Image color space
    private int imageColorSpace;
    // Image source type
    private int sourceType;
    // Image device type
    private int deviceType;
    // Image Data Type
    private int imageType;

    public String getStringImageType() {
      if (imageType == ImageType.JPEG2000.getValue()) return "image/jp2";
      return "image/jpg";
    }
  }

  enum ImageType {
    JPEG(0),
    JPEG2000(1);

    private final int value;

    ImageType(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  /** ISO/IEC 19794-4. Image compression algorithm */
  enum FingerprintImageType {
    UNCOMPRESSED(0),
    UNCOMPRESSEDPACKED(1),
    WSQ(2),
    JPEG(3),
    JPEG2000(4),
    PNG(5);

    private final int value;

    FingerprintImageType(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  @Getter
  @Setter
  @JsonInclude(Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class DecodedFingerprint extends AbstractBioTemplate {
    // ID of the biometric scanner
    private int captureDeviceId;
    // Level of image acquisition settings
    private int acquisitionLevel;
    // Number of finger/palm images
    private int count;
    // Unit of measurement of resolution
    private int scaleUnits;
    // Scan resolution (horizontal)
    private int scanResolutionHorizontal;
    // Scan resolution (vertical)
    private int scanResolutionVertical;
    // Image resolution (horizontal)
    private int imageResolutionHorizontal;
    // Image resolution (vertical)
    private int imageResolutionVertical;
    // Bit depth of the grayscale scale
    private int depth;
    // Length of fingerprint/palm image data block
    private int fingerprintRecordLength;
    // Type of fingerprint and palm image
    private int fingerImageType;
    // Count of fingerprint representations
    private int lengthOfRepresentations;
    // Number of fingerprint representation
    private int nrOfRepresention;
    // Name of finger/part of palm
    private int fingerType;
    // Image Data Type
    private int imageType;

    public String getStringImageType() {
      if (imageType == FingerprintImageType.JPEG2000.getValue()) return "image/jp2";
      else if (imageType == FingerprintImageType.JPEG2000.getValue()) return "image/png";
      return "image/jpg";
    }
  }

  @Getter
  @Setter
  @JsonInclude(Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class DecodedIris extends AbstractBioTemplate {
    // ID of Biometric scanner (by manufacturer)
    private int captureDeviceId;
    // Bit field of image properties. ISO/IEC 19794-6, table 2
    private int imagePropertiesBits;
    // Iris diameter (in points)
    private int irisDiameter;
    // Bit depth of the grayscale scale
    private int depth;
    // Converting image to polar coordinate system
    private int imageTransformation;
    // ID of Biometric scanner (by issuing authority)
    private int deviceUniqueId;
    // Eye type
    private int biometricSubtype;
    // Rotation angle of image
    private int rotationAngle;
    // Error of rotation angle
    private int rotationAngleUncertainty;
    // Image Data Type
    private int imageType;
  }

  @Getter
  @Setter
  @JsonInclude(Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class DecodedAdditionalPersonalData {
    // Full name of document holder
    private String nameOfHolder;
    // Other names of document holder
    private List<String> otherNames;
    // Personal number
    private String personalNumber;
    // Full date of birth (CCYYMMDD)
    private int fullDateOfBirth;
    // Place of birth
    private List<String> placeOfBirth;
    // Permanent residence address
    private List<String> permanentAddress;
    // Phone number
    private String telephone;
    // Profession
    private String profession;
    // Position
    private String title;
    // Personal resume
    private String personalSummary;
    // Proof of citizenship
    private Buffer proofOfCitizenship;
    // Numbers of other valid TDs
    private List<String> otherValidTDNumbers;
    // Information about detention
    private String custodyInformation;
  }

  @Getter
  @Setter
  @JsonInclude(Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class DecodedAdditionalDocumentData {
    // Full date of issue (YYYYMMDD)
    private int dateOfIssue;
    // Issuing authority
    private String issuingAuthority;
    // Name of another person
    private List<String> namesOfOtherPersons;
    // Endorsements and observations
    private String endorsements;
    // Tax and exit requirements
    private String taxAndExitReqs;
    // Image of front of document
    private Buffer imageOfFront;
    // Image of rear of document
    private Buffer imageOfRear;
    // Date and time of document personalization (YYYYMMDDHHMMSS)
    private int dateOfPersonalization;
    // Serial number of personalization system
    private String personalizationNumber;
  }

  @Getter
  @Setter
  @JsonInclude(Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class DecodedSecurtyObjectOfDocument {
    // Included certificates (ex. Document Signer Certificate)
    private List<Object> certificates;
    // LDS object with datagroup's hashes
    private Map<String, Object> ldsObject;
    // SOD signatures
    private List<Object> signatures;
  }

  @Getter
  @Setter
  @JsonInclude(Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class CSCAMasterList {
    /** Master list version */
    private int version;

    /** CSCA certificates */
    private List<Object> certificates;
  }

  @Getter
  @Setter
  @JsonInclude(Include.NON_NULL)
  @JsonIgnoreProperties(ignoreUnknown = true)
  static class Buffer {
    private String type;
    private byte[] data;
  }
}
