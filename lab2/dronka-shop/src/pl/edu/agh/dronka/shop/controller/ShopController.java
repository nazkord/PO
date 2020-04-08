package pl.edu.agh.dronka.shop.controller;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Index;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.Shop;
import pl.edu.agh.dronka.shop.model.User;
import pl.edu.agh.dronka.shop.model.filters.ItemFilter;
import pl.edu.agh.dronka.shop.view.ShopFrame;

public class ShopController {

	private ShopFrame shopView;

	private Shop shopModel;

	private Category currentCategory;

	private User currentUser;

	public void logIn(User user) {
		for (User shopUser : shopModel.getUsers()) {
			if (shopUser.getName().equals(user.getName())
					&& shopUser.getSurname().equals(user.getSurname())) {
				setCurrentUser(shopUser);
			}
		}
	}

	public void setCurrentUser(User user) {
		currentUser = user;
		shopView.getCartPanel().setUser(user);
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}

	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setShopView(ShopFrame shopFrame) {
		this.shopView = shopFrame;
	}

	public Shop getModel() {
		return shopModel;
	}

	public void setModel(Shop shopModel) {
		this.shopModel = shopModel;
	}

	public void chooseItem(Item item) {
		shopView.displayItem(item);
	}

	public void addToCart(Item item) {
		currentUser.getCart().addItem(item);
		shopView.getCartPanel().refresh();
	}

	public void goToIndex() {
		shopView.displayIndex();
	}

	public void showItems(Category category) {
		setCurrentCategory(category);
		shopView.displayItems(category);
		refreshItemsView();
	}

	public void showCategories() {
		shopView.displayCategories();
	}

	public void refreshItemsView() {
		shopView.getItemsPanel().setItems(
				shopModel.getItemsIndex().getItems(getCurrentCategory()));
		shopView.getItemsPanel().getPropertiesPanel().fillProperties(currentCategory);
	}

	public void filterItems(ItemFilter filter) {
		Index itemsIndex = shopModel.getItemsIndex();
		shopView.getItemsPanel().setItems(itemsIndex.getItems(filter));

	}

}
