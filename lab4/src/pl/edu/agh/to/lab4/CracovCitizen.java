package pl.edu.agh.to.lab4;

public class CracovCitizen extends Suspect {

    private final int age;

    public CracovCitizen(String name, String surname, int age) {
        super(name, surname);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean canBeAccused() {
        return getAge() > 18;
    }
}
