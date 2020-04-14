package pl.agh.edu.dp.builders;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.doors.Door;
import pl.agh.edu.dp.labirynth.rooms.Room;
import pl.agh.edu.dp.labirynth.walls.Wall;

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
    public void attachWall(Wall joiningWall, Direction direction, Room r1, Room r2) {
        r1.setSide(direction, joiningWall);
        r2.setSide(Direction.getOppositeTo(direction), joiningWall);
    }

    @Override
    public void attachDoor(Door door) {
        Room r1 = door.getRoom1();
        Room r2 = door.getRoom2();
        Direction doorDirection = getCommonWallDirection(r1, r2);
        r1.setSide(doorDirection, door);
        r2.setSide(Direction.getOppositeTo(doorDirection), door);
    }

    public Maze getResultedMaze() {
        Maze product = currentMaze;
        this.reset();
        return product;
    }

    private Direction getCommonWallDirection(Room r1, Room r2) {
        //loops for finding wall (directions) that joins rooms
        Direction[] directionList = Direction.values();
        for (Direction currentDirection : directionList) {
            Direction oppositeDirection = Direction.getOppositeTo(currentDirection);
            if(r1.getSide(currentDirection).equals(r2.getSide(oppositeDirection))) {
                return currentDirection;
            }
        }
        throw new IllegalArgumentException("Cannot make door [no common wall] between Room1 (id: " + r1.getRoomId() + ") i Room2 (id: " + r2.getRoomId() + ")");
    }
}
