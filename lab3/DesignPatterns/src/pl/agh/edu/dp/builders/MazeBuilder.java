package pl.agh.edu.dp.builders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Room;

public interface MazeBuilder {
    void reset();
    void addRoom(Room room);
    void joinRooms(Direction direction1, Room r1, Direction direction2, Room r2);
    void joinRooms(Room r1, Room r2); //joining rooms by default direction
    void makeDoorBetween(Room r1, Room r2); //Should I return 0/1 when adding door ends up with success/?
}
