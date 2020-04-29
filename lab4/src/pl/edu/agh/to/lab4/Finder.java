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
        List<Suspect> suspects = new ArrayList<>();

        for (Collection<Prisoner> prisonerCollection : allPrisoners.values()) {
            for (Prisoner prisoner : prisonerCollection) {
                if (isAppropriateSuspect(prisoner, name)) {
                    suspects.add(prisoner);
                }
                if (suspects.size() >= 10) {
                    break;
                }
            }
            if (suspects.size() >= 10) {
                break;
            }
        }

        if (suspects.size() < 10) {
            for (CracovCitizen cracovCitizen : allCracovCitizens) {
                if (isAppropriateSuspect(cracovCitizen, name)) {
                    suspects.add(cracovCitizen);
                }
                if (suspects.size() >= 10) {
                    break;
                }
            }
        }

        System.out.println("Znalazlem " + suspects.size() + " pasujacych podejrzanych!");
        suspects.forEach(suspect -> System.out.println(suspect.display()));
    }

    private boolean isAppropriateSuspect(Suspect suspect, String name) {
        return suspect.canBeAccused() && suspect.getName().equals(name);
    }
}
