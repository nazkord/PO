package pl.edu.agh.to.lab4.model;

public class CracovCitizen extends Suspect {

    public CracovCitizen(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    public boolean canBeAccused() {
        return getAge() > 18;
    }
}
