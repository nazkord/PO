package pl.agh.edu.dp.factories;

import pl.agh.edu.dp.builders.MazeBuilder;
import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.Wall;

public class MazeDirector {

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

    public void createEnchantedMaze(MazeBuilder builder) {
        createMaze(builder, EnchantedMazeFactory.getInstance());
    }

    public void createBombedMaze(MazeBuilder builder) {
        createMaze(builder, BombedMazeFactory.getInstance());
    }

    private void createMaze(MazeBuilder builder, MazeFactory factory) {
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

    public void checkSingletons() {
        MazeFactory mazeFactory1 = EnchantedMazeFactory.getInstance();
        MazeFactory mazeFactory2 = EnchantedMazeFactory.getInstance();
        if(mazeFactory1.equals(mazeFactory2)) {
            System.out.println("The same objects!");
        }

        MazeFactory mazeFactory3 = BombedMazeFactory.getInstance();
        MazeFactory mazeFactory4 = BombedMazeFactory.getInstance();
        if(mazeFactory3.equals(mazeFactory4)) {
            System.out.println("The same objects!");
        }
    }

}
