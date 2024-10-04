package io.twentysixty.sa.client.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaItem implements Serializable {

  private static final long serialVersionUID = -2718519112111712736L;
  private String id;
  private String description;
  private String mimeType;
  private String filename;
  private Integer byteCount;
  private String uri;
  private Ciphering ciphering;
  private String preview;
  private Integer width;
  private Integer height;
  private String duration;
  private String title;
  private String icon;
  private String openingMode;
  private String screenOrientaton;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public Integer getByteCount() {
    return byteCount;
  }

  public void setByteCount(Integer byteCount) {
    this.byteCount = byteCount;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public Ciphering getCiphering() {
    return ciphering;
  }

  public void setCiphering(Ciphering ciphering) {
    this.ciphering = ciphering;
  }

  public String getPreview() {
    return preview;
  }

  public void setPreview(String preview) {
    this.preview = preview;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getOpeningMode() {
    return openingMode;
  }

  public void setOpeningMode(String openingMode) {
    this.openingMode = openingMode;
  }

  public String getscreenOrientaton() {
    return screenOrientaton;
  }

  public void setscreenOrientaton(String screenOrientaton) {
    this.screenOrientaton = screenOrientaton;
  }

  @Override
  public String toString() {
    return "MediaItem [description="
        + description
        + ", mimeType="
        + mimeType
        + ", uri="
        + uri
        + ", preview="
        + preview
        + ", width="
        + width
        + ", height="
        + height
        + ", duration="
        + duration
        + ", title="
        + title
        + ", icon="
        + icon
        + ", openingMode="
        + openingMode
        + ", screenOrientaton="
        + screenOrientaton
        + "]";
  }
}
