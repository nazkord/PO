package pl.edu.agh.dronka.shop.model;

import pl.edu.agh.dronka.shop.model.filters.FilterSpec;

import java.util.Map;

public abstract class Item {

	private String name;

	private Category category;

	private int price;

	private int quantity;

	private boolean secondHand;

	private boolean polish;

	public Item(String name, Category category, int price, int quantity) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	public Item() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setSecondHand(boolean secondHand) {
		this.secondHand = secondHand;
	}

	public boolean isSecondHand() {
		return secondHand;
	}

	public void setPolish(boolean polish) {
		this.polish = polish;
	}

	public boolean isPolish() {
		return polish;
	}

	@Override
	public String toString() {
		return getName();
	}

	public abstract Map<String, Object> getAdditionalPropertiesMap();

	public abstract boolean isAdditionalFieldsAppliedTo(FilterSpec filter);
}
