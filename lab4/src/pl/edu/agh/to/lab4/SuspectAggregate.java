package pl.edu.agh.to.lab4;

import java.util.Iterator;

public interface SuspectAggregate {
    Iterator<Suspect> iterator(String name);
}
