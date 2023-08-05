package io.twentysixty.sa.client.model.message;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuSelectMessage extends BaseMessage {

	private List<MenuItemSelection> menuItems;

	public List<MenuItemSelection> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItemSelection> menuItems) {
		this.menuItems = menuItems;
	}
}
