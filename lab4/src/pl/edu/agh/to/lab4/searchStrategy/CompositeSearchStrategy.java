package pl.edu.agh.to.lab4.searchStrategy;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.List;
import java.util.function.Predicate;

public class CompositeSearchStrategy implements Predicate<Suspect> {

    private final List<Predicate<Suspect>> filters;

    public CompositeSearchStrategy(List<Predicate<Suspect>> filters) {
        this.filters = filters;
    }

    @Override
    public boolean test(Suspect suspect) {
        return filters.stream()
                .allMatch(suspectPredicate -> suspectPredicate.test(suspect));
    }
}
