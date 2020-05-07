package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class SuspectIterator implements Iterator<Suspect> {

    Suspect suspect;
    Iterator<? extends Suspect> iterator;
    Predicate<Suspect> filter;

    public SuspectIterator(Iterator<? extends Suspect> iterator, Predicate<Suspect> filter) {
        this.iterator = iterator;
        this.filter = filter;
    }

    @Override
    public boolean hasNext() {
        while(iterator.hasNext()) {
            Suspect tempSuspect = iterator.next();
            if(filter.test(tempSuspect) && tempSuspect.canBeAccused()) {
                suspect = tempSuspect;
                return true;
            }
        }
        return false;
    }

    @Override
    public Suspect next() {
        if(suspect != null) {
            return suspect;
        }
        throw new NoSuchElementException("There is no more suspects match the predicate");
    }


}
