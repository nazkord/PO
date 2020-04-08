package pl.edu.agh.dronka.shop.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class ShopFrame extends JFrame {

	private static final long serialVersionUID = 6578553391433363839L;

	private static final String CATEGORIES_PANEL = "Categories Panel";

	private static final String ITEMS_PANEL = "Items Panel";

	private static final String ITEM_DETAILS_PANEL = "Item Details Panel";

	private static final String INDEX_PANEL = "Index Panel";

	private static final String CART_PANEL = "Cart Panel";

	private CardLayout mainPanelLayout;

	private JPanel mainPanel;

	private CategoriesPanel categoriesPanel;

	private ItemsPanel itemsPanel;

	private ItemDetailsPanel itemDetailsPanel;

	private ShopController shopController;

	private CartPanel cartPanel;

	public ShopFrame(ShopController shopController) {

		this.shopController = shopController;
		this.shopController.setShopView(this);
		createVisuals();

		setTitle("Dronka Shop");
		setSize(700, 500);
	}

	public void displayItem(Item item) {
		displayPanel(ITEM_DETAILS_PANEL);
		itemDetailsPanel.setItem(item);
	}

	public void displayIndex() {
		displayPanel(INDEX_PANEL);
	}

	
	public void displayCategories() {
		displayPanel(CATEGORIES_PANEL);
	}
	
	public void displayItems(Category category) {
		displayPanel(ITEMS_PANEL);
	}

	public CartPanel getCartPanel() {
		return cartPanel;
	}

	public ItemsPanel getItemsPanel() {
		return itemsPanel;
	}

	public ItemDetailsPanel getItemDetailsPanel() {
		return itemDetailsPanel;
	}

	private void createVisuals() {

		BorderLayout layout = new BorderLayout();
		layout.setHgap(10);
		setLayout(layout);

		mainPanel = createMainPanel();
		add(createCartPanel(), BorderLayout.PAGE_START);
		add(mainPanel, BorderLayout.CENTER);

	}

	private JPanel createCartPanel() {
		JPanel cartPanel = new JPanel();
		cartPanel.setLayout(new BorderLayout());
		
		JLabel logoLabel = new JLabel(new ImageIcon("resources/images/dronka_logo.jpeg"));
		cartPanel.add(logoLabel, BorderLayout.LINE_START);
		
		JPanel cartButtonPanel = new JPanel();
		JButton cartButton = new JButton("Koszyk");
		cartButtonPanel.add(cartButton);
		
		cartPanel.add(cartButtonPanel, BorderLayout.LINE_END);

		cartButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				displayPanel(CART_PANEL);
			}
		});

		return cartPanel;

	}

	private JPanel createMainPanel() {
		JPanel mainPanel = new JPanel();
		mainPanelLayout = new CardLayout();
		mainPanel.setLayout(mainPanelLayout);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 10, 30));

		categoriesPanel = new CategoriesPanel(shopController);
		itemsPanel = new ItemsPanel(shopController);
		itemDetailsPanel = new ItemDetailsPanel(shopController);
		cartPanel = new CartPanel(shopController);

		mainPanel.add(categoriesPanel, CATEGORIES_PANEL);
		mainPanel.add(itemsPanel, ITEMS_PANEL);
		mainPanel.add(itemDetailsPanel, ITEM_DETAILS_PANEL);
		mainPanel.add(cartPanel, CART_PANEL);

		mainPanelLayout.show(mainPanel, CATEGORIES_PANEL);

		return mainPanel;
	}

	private void displayPanel(String panelId) {
		mainPanelLayout.show(mainPanel, panelId);
	}
	

}
