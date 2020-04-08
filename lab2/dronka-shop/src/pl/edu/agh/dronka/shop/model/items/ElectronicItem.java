package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filters.FilterSpec;

import java.util.HashMap;
import java.util.Map;

public class ElectronicItem extends Item {

    private boolean isMobile;
    private boolean isUnderWarranty;

    public ElectronicItem(String name, Category category, int price, int quantity, boolean isMobile, boolean isUnderWarranty) {
        super(name, category, price, quantity);
        this.isMobile = isMobile;
        this.isUnderWarranty = isUnderWarranty;
    }

    public boolean isMobile() {
        return isMobile;
    }

    public void setMobile(boolean mobile) {
        isMobile = mobile;
    }

    public boolean isUnderWarranty() {
        return isUnderWarranty;
    }

    public void setUnderWarranty(boolean underWarranty) {
        isUnderWarranty = underWarranty;
    }

    @Override
    public Map<String, Object> getAdditionalPropertiesMap() {
        return new HashMap<String, Object>() {{
            put("Mobilny", isMobile);
            put("Gwarancja", isUnderWarranty);
        }};
    }

    @Override
    public boolean isAdditionalFieldsAppliedTo(FilterSpec filter) {
        // applies filter only if the flag (secondHand) is true)
        if (filter.isMobile() && !isMobile()) {
            return false;
        }

        // applies filter only if the flag (polish) is true)
        if (filter.isUnderWarranty() && !isUnderWarranty) {
            return false;
        }

        return true;
    }
}
