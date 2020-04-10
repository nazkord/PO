package pl.agh.edu.dp.builders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Room;

import java.util.concurrent.atomic.AtomicInteger;

public class CountingMazeBuilder implements MazeBuilder {

    private AtomicInteger count;

    public CountingMazeBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        count = new AtomicInteger(0);
    }

    @Override
    public void addRoom(Room room) {
        incrementCount();
    }

    @Override
    public void joinRooms(Direction direction1, Room r1, Direction direction2, Room r2) {
        joinRooms(r1, r2);
    }

    @Override
    public void joinRooms(Room r1, Room r2) {
        incrementCount();
    }

    @Override
    public void makeDoorBetween(Room r1, Room r2) {
        incrementCount();
    }

    public int getCount() {
        AtomicInteger result = count;
        this.reset();
        return result.get();
    }

    private void incrementCount() {
        count.incrementAndGet();
    }
}
