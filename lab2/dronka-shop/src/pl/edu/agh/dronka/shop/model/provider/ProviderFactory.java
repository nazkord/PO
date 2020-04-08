package pl.edu.agh.dronka.shop.model.provider;

import pl.edu.agh.dronka.shop.model.Category;

public class ProviderFactory {

    public static Provider getProvider(Category category) {
        switch (category) {
            case BOOKS: {
                return new BookProvider();
            }
            case ELECTRONICS: {
                return new ElectronicProvider();
            }
            case FOOD: {
                return new FoodProvider();
            }
            case MUSIC: {
                return new MusicProvider();
            }
            case SPORT: {
                return new SportProvider();
            }
            default: {
                throw new IllegalArgumentException("There is no such category: " + category);
            }
        }
    }
}
