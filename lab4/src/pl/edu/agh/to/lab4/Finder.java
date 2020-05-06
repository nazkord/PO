package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Finder {

    private final CompositeAggregate compositeAggregate;

    public Finder(CompositeAggregate compositeAggregate) {
        this.compositeAggregate = compositeAggregate;
    }

    public void displayAllSuspectsWithName(String name) {
        Iterator<Suspect> suspectIterator = compositeAggregate.iterator(name);
        List<Suspect> suspects = new ArrayList<>();

        while(suspectIterator.hasNext() && suspects.size() < 10) {
            suspects.add(suspectIterator.next());
        }

        System.out.println("Znalazlem " + suspects.size() + " pasujacych podejrzanych!");
        suspects.forEach(System.out::println);
    }
}
