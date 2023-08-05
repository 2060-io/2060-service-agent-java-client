package io.twentysixty.sa.client.model.message;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContextualMenuUpdate extends BaseMessage {

	private String title;
	private String description;
	
	private List<ContextualMenuItem> options;

	public List<ContextualMenuItem> getOptions() {
		return options;
	}

	public void setOptions(List<ContextualMenuItem> options) {
		this.options = options;
	}

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
	
	public ContextualMenuUpdate clone() {
		ContextualMenuUpdate clone = new ContextualMenuUpdate();
		clone.setTitle(title);
		clone.setDescription(description);
		clone.setId(id);
		if (options != null) {
			List<ContextualMenuItem> clonedOptions = new ArrayList<ContextualMenuItem>();
			
			for (ContextualMenuItem i: options) {
				ContextualMenuItem ci = new ContextualMenuItem();
				ci.setDescription(i.getDescription());
				ci.setId(i.getId());
				ci.setTitle(i.getTitle());
			}
			clone.setOptions(clonedOptions);
		}
		
		return clone;
		
	}
	
}
