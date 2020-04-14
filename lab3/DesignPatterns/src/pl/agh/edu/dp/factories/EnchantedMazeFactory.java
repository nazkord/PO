package pl.agh.edu.dp.factories;

import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.doors.EnchantedDoor;
import pl.agh.edu.dp.labirynth.rooms.EnchantedRoom;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.EnchantedWall;
import pl.agh.edu.dp.labirynth.walls.Wall;

public class EnchantedMazeFactory implements MazeFactory {

    @Override
    public Room createRoom() {
        return new EnchantedRoom(EnchantedWall::new);
    }

    @Override
    public Wall createWall() {
        return new EnchantedWall();
    }

    @Override
    public Door createDoor(Room r1, Room r2) {
        return new EnchantedDoor(r1, r2);
    }
}
