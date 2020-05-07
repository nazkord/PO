package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.dataProvider.CompositeAggregate;
import pl.edu.agh.to.lab4.model.Suspect;
import pl.edu.agh.to.lab4.searchStrategy.CompositeSearchStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Finder {

    private final CompositeAggregate compositeAggregate;

    public Finder(CompositeAggregate compositeAggregate) {
        this.compositeAggregate = compositeAggregate;
    }

    public void display(CompositeSearchStrategy searchStrategy) {
        Iterator<Suspect> suspectIterator = compositeAggregate.iterator(searchStrategy);
        List<Suspect> suspects = new ArrayList<>();

        while(suspectIterator.hasNext() && suspects.size() < 10) {
            suspects.add(suspectIterator.next());
        }

        System.out.println("Znalazlem " + suspects.size() + " pasujacych podejrzanych!");
        suspects.forEach(System.out::println);
    }
}
