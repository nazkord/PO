package pl.agh.edu.dp.factories;

import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.rooms.BombedRoom;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.BombedWall;
import pl.agh.edu.dp.labirynth.walls.Wall;

public class BombedMazeFactory implements MazeFactory {

    @Override
    public Room createRoom() {
        return new BombedRoom(BombedWall::new);
    }

    @Override
    public Wall createWall() {
        return new BombedWall();
    }

    @Override
    public Door createDoor(Room r1, Room r2) {
        return new Door(r1, r2);
    }
}
