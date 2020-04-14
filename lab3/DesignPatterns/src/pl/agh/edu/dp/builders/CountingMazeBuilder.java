package pl.agh.edu.dp.builders;

import pl.agh.edu.dp.labirynth.Counters;
import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.Wall;

public class CountingMazeBuilder implements MazeBuilder {

    private Counters counters;

    public CountingMazeBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        counters = new Counters();
    }

    @Override
    public void addRoom(Room room) {
        counters.setRoomCounter(counters.getRoomCounter() + 1);
        counters.setWallCounter(counters.getWallCounter() + 4);
    }

    @Override
    public void attachWall(Wall wall, Direction direction, Room r1, Room r2) {
        counters.setWallCounter(counters.getWallCounter() - 1);
    }

    @Override
    public void attachDoor(Door door) {
        counters.setWallCounter(counters.getWallCounter() - 1);
        counters.setDoorCounter(counters.getDoorCounter() + 1);
    }

    public Counters getCount() {
        Counters result = counters;
        this.reset();
        return result;
    }
}
