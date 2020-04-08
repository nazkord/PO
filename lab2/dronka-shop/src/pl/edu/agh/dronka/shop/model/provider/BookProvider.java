package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.BookItem;

public class BookProvider implements Provider {

    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        int numberOfPages  = Integer.parseInt(reader.getValue(dataLine, "Liczba stron"));
        boolean isHardCover = Boolean.parseBoolean(reader.getValue(
                dataLine, "Twarda oprawa"));
        return new BookItem(name, category, price, quantity, numberOfPages, isHardCover);
    }
}
