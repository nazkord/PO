package pl.edu.agh.to.lab4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuspectIterator implements Iterator<Suspect> {

    Suspect suspect;
    Iterator<? extends Suspect> iterator;
    String name;

    public SuspectIterator(Iterator<? extends Suspect> iterator, String name) {
        this.iterator = iterator;
        this.name = name;
    }

    @Override
    public boolean hasNext() {
        while(iterator.hasNext()) {
            Suspect tempSuspect = iterator.next();
            if(tempSuspect.getName().equals(name) && tempSuspect.canBeAccused()) {
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
