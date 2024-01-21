package io.twentysixty.sa.client.model.message;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContextualMenuItem  implements Serializable {

	private static final long serialVersionUID = 2236423396630045255L;
	private String id;
	private String title;
	private String description;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public static ContextualMenuItem build(String id, String title, String description) {
		ContextualMenuItem item = new ContextualMenuItem();
		item.setDescription(description);
		item.setId(id);
		item.setTitle(title);
		return item;
	}

}
