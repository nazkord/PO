package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filters.FilterSpec;

import java.util.HashMap;
import java.util.Map;

public class BookItem extends Item {

    private int numberOfPages;
    private boolean isHardCover;

    public BookItem(String name, Category category, int price, int quantity, int numberOfPages, boolean isHardCover) {
        super(name, category, price, quantity);
        this.numberOfPages = numberOfPages;
        this.isHardCover = isHardCover;
    }

    public BookItem() {
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public boolean isHardCover() {
        return isHardCover;
    }

    public void setHardCover(boolean hardCover) {
        isHardCover = hardCover;
    }

    @Override
    public Map<String, Object> getAdditionalPropertiesMap() {
        return new HashMap<String, Object>() {{
            put("Liczba stron", numberOfPages);
            put("Twarda oprawa", isHardCover);
        }};
    }

    @Override
    public boolean isAdditionalFieldsAppliedTo(FilterSpec filter) {
        return !filter.isHardCover() || isHardCover;
    }
}
