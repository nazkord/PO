package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filters.FilterSpec;

import java.util.Map;

public class SportItem extends Item {

    public SportItem(String name, Category category, int price, int quantity) {
        super(name, category, price, quantity);
    }

    @Override
    public Map<String, Object> getAdditionalPropertiesMap() {
        return null;
    }

    @Override
    public boolean isAdditionalFieldsAppliedTo(FilterSpec filter) {
        return true;
    }
}
