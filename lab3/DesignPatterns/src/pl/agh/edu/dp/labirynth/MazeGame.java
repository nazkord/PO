package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.builders.MazeBuilder;

public class MazeGame {
    public Maze createMaze(){
        Maze maze = new Maze();

        Room r1 = new Room();
        Room r2 = new Room();

        Door door = new Door(r1, r2);

        maze.addRoom(r1);
        maze.addRoom(r2);

        r1.setSide(Direction.North, new Wall());
        r1.setSide(Direction.East, new Wall());
        r1.setSide(Direction.South, new Wall());
        r1.setSide(Direction.West, new Wall());

        r2.setSide(Direction.North, new Wall());
        r2.setSide(Direction.East, new Wall());
        r2.setSide(Direction.South, new Wall());
        r2.setSide(Direction.West, new Wall());

        return maze;
    }

    public void createMaze(MazeBuilder builder) {
        Room A = new Room();
        Room B = new Room();
        Room C = new Room();
        builder.addRoom(A);
        builder.addRoom(B);
        builder.addRoom(C);
        builder.makeWall(Direction.West, A, B);
        builder.makeDoorBetween(A, B);
        builder.makeWall(Direction.North, B, C);
        builder.makeDoorBetween(B, C);
    }
}
