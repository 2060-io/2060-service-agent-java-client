package io.twentysixty.sa.client.model.message;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaMessage extends BaseMessage  implements Serializable {

	private static final long serialVersionUID = -4859703743672351029L;
	private String description;
	private List<MediaItem> items;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MediaMessage [description=" + description + ", items=" + items + "]";
	}

	public List<MediaItem> getItems() {
		return items;
	}

	public void setItems(List<MediaItem> items) {
		this.items = items;
	}

}
