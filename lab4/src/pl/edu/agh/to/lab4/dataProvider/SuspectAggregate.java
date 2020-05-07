package pl.edu.agh.to.lab4.dataProvider;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.Iterator;
import java.util.function.Predicate;

public interface SuspectAggregate {
    Iterator<Suspect> iterator(Predicate<Suspect> filter);
}
