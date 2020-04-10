package pl.agh.edu.dp.builders;

import pl.agh.edu.dp.labirynth.*;

import java.security.KeyPair;

public class StandardBuilderMaze implements MazeBuilder {

    private Maze currentMaze;

    public StandardBuilderMaze() {
        this.reset();
    }

    @Override
    public void reset() {
        this.currentMaze = new Maze();
    }

    @Override
    public void addRoom(Room room) {
        currentMaze.addRoom(room);
    }

    @Override
    public void joinRooms(Direction direction1, Room r1, Direction direction2, Room r2) {
        Wall joiningWall = new Wall();
        r1.setSide(direction1, joiningWall);
        r2.setSide(direction2, joiningWall);
    }

    @Override
    public void joinRooms(Room r1, Room r2) {
        joinRooms(CommonWallDirection(), r1, CommonWallDirection(), r2);
    }

    @Override
    public void makeDoorBetween(Room r1, Room r2) {

        //loops for finding wall (directions) that joins rooms
        Direction[] directionList = Direction.values();
        for (Direction currentDirection : directionList) {
            for (Direction direction : directionList) {
                if(r1.getSide(currentDirection).equals(r2.getSide(direction))) {
                    Door door = new Door(r1, r2);
                    r1.setSide(currentDirection, door);
                    r2.setSide(direction, door);
                    return;
                }
            }
        }
//        return 1;
    }

    public Maze getResultedMaze() {
        Maze product = currentMaze;
        this.reset();
        return product;
    }

    private Direction CommonWallDirection() {
        return Direction.North;
    }
}
