package pl.edu.agh.dronka.shop.model;

import pl.edu.agh.dronka.shop.model.filters.ItemFilter;

public enum Category {

	BOOKS("Książki"),
	ELECTRONICS("Elektronika"),
	FOOD("Żywność"),
	MUSIC("Muzyka"),
	SPORT("Sport");

	private String displayName;
	private ItemFilter filter;

	public String getDisplayName() {
		return displayName;
	}

	private Category(String displayName) {
		this.displayName = displayName;
	}
}
