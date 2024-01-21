package io.twentysixty.sa.client.model.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileMessage extends BaseMessage {

	private static final long serialVersionUID = 7632455409300337368L;

	private String displayName;
	private String displayImageUrl;

    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayImageUrl() {
        return displayImageUrl;
    }
    public void setDisplayImageUrl(String displayImageUrl) {
        this.displayImageUrl = displayImageUrl;
    }

}
