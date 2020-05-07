package pl.edu.agh.to.lab4.searchStrategy;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.function.Predicate;

public class AgeSearchStrategy implements Predicate<Suspect> {

    private final int age;

    public AgeSearchStrategy(int age) {
        this.age = age;
    }

    @Override
    public boolean test(Suspect suspect) {
        return suspect.getAge() == age;
    }
}
