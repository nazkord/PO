package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Finder {

    private final SuspectAggregate allCracovCitizens;
    private final SuspectAggregate allPrisoners;

    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
        this.allCracovCitizens = personDataProvider;
        this.allPrisoners = prisonersDatabase;
    }

    public void displayAllSuspectsWithName(String name) {
        Iterator<? extends Suspect> prisonersIterator = allPrisoners.iterator(name);
        Iterator<? extends Suspect> cracovCitizensIterator = allCracovCitizens.iterator(name);
        List<Suspect> suspects = new ArrayList<>();

        while(prisonersIterator.hasNext() && suspects.size() < 10) {
            suspects.add(prisonersIterator.next());
        }

        while(cracovCitizensIterator.hasNext() && suspects.size() < 10) {
            suspects.add(cracovCitizensIterator.next());
        }

        System.out.println("Znalazlem " + suspects.size() + " pasujacych podejrzanych!");
        suspects.forEach(System.out::println);
    }
}
