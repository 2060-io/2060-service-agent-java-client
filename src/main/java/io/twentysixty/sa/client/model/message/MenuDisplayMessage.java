package io.twentysixty.sa.client.model.message;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuDisplayMessage extends BaseMessage {

	private String prompt;
	
	private List<MenuItem> menuItems;

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	public MenuDisplayMessage clone() {
		MenuDisplayMessage clone = new MenuDisplayMessage();
		clone.setPrompt(prompt);
		
		if (this.getMenuItems() != null) {
			List<MenuItem> cloneMenuItems = new ArrayList<MenuItem>(this.getMenuItems().size());
			for (MenuItem i: this.getMenuItems()) {
				MenuItem ci = new MenuItem();
				ci.setAction(i.getAction());
				ci.setId(i.getId());
				ci.setText(i.getText());
				
				cloneMenuItems.add(ci);
			}
			clone.setMenuItems(cloneMenuItems);
		}
		
		return clone;
		
		
		
	}
}
