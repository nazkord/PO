package pl.agh.edu.dp.builders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.Wall;

public interface MazeBuilder {
    void reset();
    void addRoom(Room room);
    void attachWall(Wall wall, Direction direction, Room r1, Room r2);
    void attachDoor(Door door);
}
