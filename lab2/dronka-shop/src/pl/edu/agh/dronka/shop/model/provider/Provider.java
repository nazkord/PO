package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public interface Provider {

    Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader);

}
