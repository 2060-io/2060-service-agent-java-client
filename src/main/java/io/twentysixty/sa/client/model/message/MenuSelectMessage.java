package io.twentysixty.sa.client.model.message;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuSelectMessage extends BaseMessage  implements Serializable {

	private static final long serialVersionUID = 2315457851863067424L;
	private List<MenuItemSelection> menuItems;
	private String content;

	public List<MenuItemSelection> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItemSelection> menuItems) {
		this.menuItems = menuItems;
	}

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
