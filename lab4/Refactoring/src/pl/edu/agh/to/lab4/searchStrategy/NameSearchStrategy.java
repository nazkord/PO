package pl.edu.agh.to.lab4.searchStrategy;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.function.Predicate;

public class NameSearchStrategy implements Predicate<Suspect> {

    private final String name;

    public NameSearchStrategy(String name) {
        this.name = name;
    }

    @Override
    public boolean test(Suspect suspect) {
        return suspect.getName().equals(name);
    }
}
