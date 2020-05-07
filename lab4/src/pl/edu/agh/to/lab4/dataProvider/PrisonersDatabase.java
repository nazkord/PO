package pl.edu.agh.to.lab4.dataProvider;

import pl.edu.agh.to.lab4.SuspectIterator;
import pl.edu.agh.to.lab4.model.Prisoner;
import pl.edu.agh.to.lab4.model.Suspect;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PrisonersDatabase implements SuspectAggregate {

    private final Map<String, Collection<Prisoner>> prisoners = new HashMap<>();

    public PrisonersDatabase() {
    }

    public Map<String, Collection<Prisoner>> findAll() {
        return prisoners;
    }

    public void addPrisoner(String category, Prisoner prisoner) {
        prisoners.putIfAbsent(category, new ArrayList<>());
        prisoners.get(category).add(prisoner);
    }

    @Override
    public Iterator<Suspect> iterator(Predicate<Suspect> filter) {
        Iterator<Prisoner> prisonerIterator = prisoners.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                .iterator();
        return new SuspectIterator(prisonerIterator, filter);
    }
}
