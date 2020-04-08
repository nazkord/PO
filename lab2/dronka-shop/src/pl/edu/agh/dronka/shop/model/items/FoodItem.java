package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filters.FilterSpec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FoodItem extends Item {

    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private Date eatBeforeDate;

    public FoodItem(String name, Category category, int price, int quantity, String eatBeforeInString) {
        super(name, category, price, quantity);
        try {
            this.eatBeforeDate = convertToDate(eatBeforeInString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Bad data provided");
        }
    }

    private Date convertToDate(String string) throws ParseException {
        return formatter.parse(string);
    }

    public Date getEatBeforeDate() {
        return eatBeforeDate;
    }

    public void setEatBeforeDate(Date eatBeforeDate) {
        this.eatBeforeDate = eatBeforeDate;
    }

    @Override
    public Map<String, Object> getAdditionalPropertiesMap() {
        return new HashMap<String, Object>() {{
            put("Data przydatności do spożycia", eatBeforeDate);
        }};
    }

    @Override
    public boolean isAdditionalFieldsAppliedTo(FilterSpec filter) {
        return true;
    }
}
