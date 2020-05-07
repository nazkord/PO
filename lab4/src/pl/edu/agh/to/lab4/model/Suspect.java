package pl.edu.agh.to.lab4.model;

public abstract class Suspect {
    private final String name;
    private final String surname;
    private final int age;

    public Suspect(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String display() {
        return getName() + " " + getSurname();
    }

    public abstract boolean canBeAccused();

    @Override
    public String toString() {
        return display();
    }
}