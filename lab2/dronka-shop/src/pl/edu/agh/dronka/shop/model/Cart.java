package pl.edu.agh.dronka.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Item> items = new ArrayList<>();
	
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void clearCart() {
		items.clear();
	}
	
	public List<Item> getItems() {
		return new ArrayList<>(items);
	}
	
	public int getTotalPrice() {
		int sum = 0;
		for(Item item : items) {
			sum += item.getPrice();
		}
		return sum;
	}
}
