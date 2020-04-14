package pl.agh.edu.dp.factories;

import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.walls.Wall;
import pl.agh.edu.dp.labirynth.rooms.Room;

public interface MazeFactory {
    Room createRoom();
    Wall createWall();
    Door createDoor(Room r1, Room r2);
}
