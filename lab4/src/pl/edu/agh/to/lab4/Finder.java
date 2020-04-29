package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Finder {

    private final Collection<CracovCitizen> allCracovCitizens;
    private final Map<String, Collection<Prisoner>> allPrisoners;

    public Finder(Collection<CracovCitizen> allCracovCitizens, Map<String, Collection<Prisoner>> allPrisoners) {
        this.allCracovCitizens = allCracovCitizens;
        this.allPrisoners = allPrisoners;
    }

    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
        this(personDataProvider.getAllCracovCitizens(), prisonersDatabase.findAll());
    }

    public void displayAllSuspectsWithName(String name) {
        List<Prisoner> suspectedPrisoners = new ArrayList<>();
        List<CracovCitizen> suspectedCracovCitizens = new ArrayList<>();

        for (Collection<Prisoner> prisonerCollection : allPrisoners.values()) {
            for (Prisoner prisoner : prisonerCollection) {
                if (!prisoner.IsJailedNow() && prisoner.getName().equals(name)) {
                    suspectedPrisoners.add(prisoner);
                }
                if (suspectedPrisoners.size() >= 10) {
                    break;
                }
            }
            if (suspectedPrisoners.size() >= 10) {
                break;
            }
        }

        if (suspectedPrisoners.size() < 10) {
            for (CracovCitizen cracovCitizen : allCracovCitizens) {
                if (cracovCitizen.getAge() > 18 && cracovCitizen.getName().equals(name)) {
                    suspectedCracovCitizens.add(cracovCitizen);
                }
                if (suspectedPrisoners.size() + suspectedCracovCitizens.size() >= 10) {
                    break;
                }
            }
        }

        int t = suspectedPrisoners.size() + suspectedCracovCitizens.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Prisoner n : suspectedPrisoners) {
            System.out.println(n.display());
        }

        for (CracovCitizen p : suspectedCracovCitizens) {
            System.out.println(p.display());
        }
    }
}
