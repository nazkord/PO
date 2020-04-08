package pl.edu.agh.dronka.shop.view;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.filters.ItemFilter;
import pl.edu.agh.dronka.shop.model.provider.*;

public class PropertiesPanel extends JPanel {

	private static final long serialVersionUID = -2804446079853846996L;
	private ShopController shopController;

	private ItemFilter filter = new ItemFilter();

	public PropertiesPanel(ShopController shopController) {
		this.shopController = shopController;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	public void fillProperties(Category category) {
		removeAll();

		filter.getFilter().setCategory(shopController.getCurrentCategory());

		add(createPropertyCheckbox("Tanie bo polskie", event -> {
			filter.getFilter().setPolish(
					((JCheckBox) event.getSource()).isSelected());
			shopController.filterItems(filter);
		}));

		add(createPropertyCheckbox("Używany", event -> {
			filter.getFilter().setSecondHand(
					((JCheckBox) event.getSource()).isSelected());
			shopController.filterItems(filter);
		}));

		switch (category) {
			case BOOKS: {
				add(createPropertyCheckbox("Twarda oprawa", event -> {
					filter.getFilter().setHardCover(
							((JCheckBox) event.getSource()).isSelected());
					shopController.filterItems(filter);
				}));
				break;
			}
			case ELECTRONICS: {
				add(createPropertyCheckbox("Mobilny", event -> {
					filter.getFilter().setMobile(
							((JCheckBox) event.getSource()).isSelected());
					shopController.filterItems(filter);
				}));

				add(createPropertyCheckbox("Gwarancja", event -> {
					filter.getFilter().setUnderWarranty(
							((JCheckBox) event.getSource()).isSelected());
					shopController.filterItems(filter);
				}));
				break;
			}
			case FOOD:
			case SPORT: {
				break;
			}
			case MUSIC: {
				add(createPropertyCheckbox("Dołączone video", event -> {
					filter.getFilter().setWithVideo(
							((JCheckBox) event.getSource()).isSelected());
					shopController.filterItems(filter);
				}));
				break;
			}
		}
	}

	private JCheckBox createPropertyCheckbox(String propertyName,
			ActionListener actionListener) {

		JCheckBox checkBox = new JCheckBox(propertyName);
		checkBox.setSelected(false);
		checkBox.addActionListener(actionListener);

		return checkBox;
	}

}
