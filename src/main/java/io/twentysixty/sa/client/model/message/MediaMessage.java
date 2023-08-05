package io.twentysixty.sa.client.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaMessage extends BaseMessage {

	private String description;
	private String uri;
	private String mimeType;
	private String contentEncryptionKey;
	private String contentEncryptionAlgo;
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public String getContentEncryptionKey() {
		return contentEncryptionKey;
	}
	public void setContentEncryptionKey(String contentEncryptionKey) {
		this.contentEncryptionKey = contentEncryptionKey;
	}
	public String getContentEncryptionAlgo() {
		return contentEncryptionAlgo;
	}
	public void setContentEncryptionAlgo(String contentEncryptionAlgo) {
		this.contentEncryptionAlgo = contentEncryptionAlgo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
