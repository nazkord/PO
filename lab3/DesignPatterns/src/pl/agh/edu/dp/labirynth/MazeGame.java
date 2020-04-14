package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.builders.MazeBuilder;
import pl.agh.edu.dp.factories.MazeFactory;
import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.Wall;

public class MazeGame {

    public void createMaze(MazeBuilder builder) {
        Room A = new Room(Wall::new);
        Room B = new Room(Wall::new);
        Room C = new Room(Wall::new);
        builder.addRoom(A);
        builder.addRoom(B);
        builder.addRoom(C);
        Wall wallA = new Wall();
        builder.attachWall(wallA, Direction.West, A, B);
        Door doorA = new Door(A, B);
        builder.attachDoor(doorA);
        Wall wallB = new Wall();
        builder.attachWall(wallB, Direction.North, B, C);
        Door doorB = new Door(B, C);
        builder.attachDoor(doorB);
    }

    public void createMaze(MazeBuilder builder, MazeFactory factory) {
        Room A = factory.createRoom();
        Room B = factory.createRoom();
        Room C = factory.createRoom();
        builder.addRoom(A);
        builder.addRoom(B);
        builder.addRoom(C);
        builder.attachWall(factory.createWall(), Direction.West, A, B);
        builder.attachDoor(factory.createDoor(A, B));
        builder.attachWall(factory.createWall(), Direction.North, B, C);
        builder.attachDoor(factory.createDoor(B, C));
    }

}
