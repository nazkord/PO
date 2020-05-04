package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PersonDataProvider implements SuspectAggregate {

    private final Collection<CracovCitizen> cracovCitizens = new ArrayList<>();

    public PersonDataProvider() {
    }

    public Collection<CracovCitizen> getAllCracovCitizens() {
        return cracovCitizens;
    }

    @Override
    public Iterator<Suspect> iterator(String name) {
        return new SuspectIterator(cracovCitizens.iterator(), name);
    }
}
