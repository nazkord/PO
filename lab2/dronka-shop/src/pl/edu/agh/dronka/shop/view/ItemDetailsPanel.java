package pl.edu.agh.dronka.shop.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.util.PropertiesHelper;

public class ItemDetailsPanel extends JPanel {

	private static final long serialVersionUID = 7620300297634323349L;

	private JPanel infoPanel;
	private ShopController shopController;

	private Item currentItem;

	private JButton addToCartButton;

	public ItemDetailsPanel(ShopController shopController) {
		this.shopController = shopController;
		createVisuals();
	}

	public void setItem(Item item) {
		infoPanel.removeAll();
		this.currentItem = item;

		Map<String, Object> propertiesMap = PropertiesHelper
				.getPropertiesMap(item);

		for (String displayName : propertiesMap.keySet()) {
			createInfoLabel(displayName, propertiesMap.get(displayName)
					.toString());
		}

		addToCartButton.setEnabled(item.getQuantity() > 0);
	}

	private void createVisuals() {
		setLayout(new BorderLayout());

		JPanel outerInfoPanel = new JPanel();
		infoPanel = createInfoPanel();
		outerInfoPanel.add(infoPanel);

		add(outerInfoPanel, BorderLayout.LINE_START);
		add(createButtonsPanel(), BorderLayout.PAGE_END);
	}

	private Component createButtonsPanel() {
		JPanel buttonsPanel = new JPanel();

		JButton backButton = new JButton("Powrót");
		addToCartButton = new JButton("Dodaj do koszyka");

		buttonsPanel.add(backButton);
		buttonsPanel.add(addToCartButton);

		backButton.addActionListener(arg0 -> shopController.showItems(shopController.getCurrentCategory()));

		addToCartButton.addActionListener(e -> shopController.addToCart(currentItem));

		return buttonsPanel;
	}

	private JPanel createInfoPanel() {
		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

		return infoPanel;
	}

	private void createInfoLabel(String name, String value) {
		JPanel infoLabelPanel = new JPanel(new BorderLayout(10, 2));
		infoLabelPanel.add(new JLabel(name + ":"), BorderLayout.LINE_START);
		infoLabelPanel.add(new JLabel(value), BorderLayout.CENTER);

		infoPanel.add(infoLabelPanel);
	}
}
