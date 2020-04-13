package pl.agh.edu.dp.builders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Room;

public interface MazeBuilder {
    void reset();
    void addRoom(Room room);
    void makeWall(Direction direction, Room r1, Room r2);
    void makeDoorBetween(Room r1, Room r2); //Should I return 0/1 when adding door ends up with success/?
}
