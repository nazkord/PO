package pl.edu.agh.dronka.shop.model;

public class User {

	private String name;
	
	private String surname;
	
	private Cart cart;
	

	public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
		
		this.cart = new Cart();
	}

	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public Cart getCart() {
		return cart;
	}
}
