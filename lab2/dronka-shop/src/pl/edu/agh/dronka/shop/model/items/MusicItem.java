package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filters.FilterSpec;

import java.util.HashMap;
import java.util.Map;

public class MusicItem extends Item {

    private MusicGenre genre;
    private boolean isVideoPresent;

    public MusicItem(String name, Category category, int price, int quantity, MusicGenre genre, boolean isVideoPresent) {
        super(name, category, price, quantity);
        this.genre = genre;
        this.isVideoPresent = isVideoPresent;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public boolean isVideoPresent() {
        return isVideoPresent;
    }

    public void setVideoPresent(boolean videoPresent) {
        isVideoPresent = videoPresent;
    }

    @Override
    public Map<String, Object> getAdditionalPropertiesMap() {
        return new HashMap<String, Object>() {{
            put("Gatunek muzyczny", genre.toString());
            put("Dołączone video", isVideoPresent);
        }};
    }

    @Override
    public boolean isAdditionalFieldsAppliedTo(FilterSpec filter) {
        return !filter.isWithVideo() || isVideoPresent;
    }
}
