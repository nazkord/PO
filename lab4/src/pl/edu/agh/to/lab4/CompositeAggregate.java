package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CompositeAggregate implements SuspectAggregate {

    private final List<SuspectAggregate> aggregates;

    public CompositeAggregate(List<SuspectAggregate> aggregates) {
        this.aggregates = aggregates;
    }

    @Override
    public Iterator<Suspect> iterator(String name) {
        Collection<Suspect> suspects = new ArrayList<>();
        aggregates.forEach(sA -> {
            Iterator<Suspect> iterator = sA.iterator(name);
            while(iterator.hasNext()) {
                suspects.add(iterator.next());
            }
        });
        return suspects.iterator();
    }
}
