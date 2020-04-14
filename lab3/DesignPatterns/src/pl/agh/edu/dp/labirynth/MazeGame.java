package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.builders.MazeBuilder;
import pl.agh.edu.dp.factories.MazeFactory;
import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.Wall;

public class MazeGame {

    public Maze createMaze(){
        Maze maze = new Maze();

        Room r1 = new Room(Wall::new);
        Room r2 = new Room(Wall::new);

        Door door = new Door(r1, r2);

        maze.addRoom(r1);
        maze.addRoom(r2);
        
        return maze;
    }

    public void createMaze(MazeBuilder builder) {
        Room A = new Room(Wall::new);
        Room B = new Room(Wall::new);
        Room C = new Room(Wall::new);
        builder.addRoom(A);
        builder.addRoom(B);
        builder.addRoom(C);
        builder.attachWall(new Wall(), Direction.West, A, B);
        builder.attachDoor(new Door(A, B));
        builder.attachWall(new Wall(), Direction.North, B, C);
        builder.attachDoor(new Door(B, C));
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
