package pl.edu.agh.dronka.shop.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Item;

public class ItemsPanel extends JPanel {

	private static final long serialVersionUID = -4871875393346906351L;

	private JList<Item> itemsList;
	private ShopController shopController;

	private PropertiesPanel propertiesPanel;

	public ItemsPanel(ShopController shopController) {
		this.shopController = shopController;
		createVisuals();
	}

	public void setItems(List<Item> items) {
		itemsList.setListData(items.toArray(new Item[0]));
	}

	public PropertiesPanel getPropertiesPanel() {
		return propertiesPanel;
	}

	private void createVisuals() {
		setLayout(new BorderLayout());
		itemsList = new JList<>();

		propertiesPanel = new PropertiesPanel(shopController);

		JPanel buttonsPanel = createButtonsPanel();

		add(propertiesPanel, BorderLayout.LINE_START);
		add(itemsList, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.PAGE_END);

		itemsList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					int index = itemsList.locationToIndex(evt.getPoint());
					Item itemModel = itemsList.getModel().getElementAt(index);
					shopController.chooseItem(itemModel);
				}
			}
		});
	}

	private JPanel createButtonsPanel() {
		JPanel buttonsPanel = new JPanel();

		JButton backButton = new JButton("Powrót");

		buttonsPanel.add(backButton);

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				shopController.showCategories();
			}
		});

		return buttonsPanel;
	}
}
