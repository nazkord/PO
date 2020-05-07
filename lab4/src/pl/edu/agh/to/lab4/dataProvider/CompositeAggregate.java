package pl.edu.agh.to.lab4.dataProvider;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class CompositeAggregate implements SuspectAggregate {

    private final List<SuspectAggregate> aggregates;

    public CompositeAggregate(List<SuspectAggregate> aggregates) {
        this.aggregates = aggregates;
    }

    @Override
    public Iterator<Suspect> iterator(Predicate<Suspect> filter) {
        Collection<Suspect> suspects = new ArrayList<>();
        aggregates.forEach(sA -> {
            Iterator<Suspect> iterator = sA.iterator(filter);
            while(iterator.hasNext()) {
                suspects.add(iterator.next());
            }
        });
        return suspects.iterator();
    }
}
