package pl.edu.agh.dronka.shop.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Category;


public class CategoriesPanel extends JPanel {

	private static final long serialVersionUID = -5107029028540534486L;

	private final ShopController shopController;

	public CategoriesPanel(ShopController shopController) {
		this.shopController = shopController;
		createVisuals();
	}

	private void createVisuals() {
		setLayout(new GridLayout(0, 1));
		JLabel title = new JLabel("<HTML><FONT size=6>Lista kategorii</FONT></HTML>");
		add(title);
		
		for (Category category : shopController.getModel().getItemsIndex().getCategories()) {
			addCategoryLink(category);
			
		}
	}

	private void addCategoryLink(final Category category) {
		JButton button = new JButton();
		button.setText("<HTML><FONT color=\"#000099\"><U>" + category.getDisplayName().toUpperCase() + "</U></FONT>" + 
				"</HTML>");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBorderPainted(false);
		button.setOpaque(false);
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				shopController.showItems(category);
				
			}
			
		});
		add(button);
	}
}
