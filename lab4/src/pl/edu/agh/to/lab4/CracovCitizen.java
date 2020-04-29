package pl.edu.agh.to.lab4;

public class CracovCitizen {

    private final String name;
    private final String surname;
    private final int age;

    public CracovCitizen(String name, String surname, int age) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String display() {
        return name + " " + surname;
    }
}
