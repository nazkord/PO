package pl.agh.edu.dp;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.rooms.Room;

public class Player {
    private int health;
    private Room currentRoom;

    public Player(int health) {
        this.health = health;
    }

    public void receiveDamage(int i) {
        health -= i;
        if(health > 0) {
            System.out.println("You received " + i + " damage");
        }
    }

    public void moveLeft() {
        currentRoom.getSide(Direction.East).enter(this);
    }

    public void moveRight() {
        currentRoom.getSide(Direction.West).enter(this);
    }

    public void moveForward() {
        currentRoom.getSide(Direction.North).enter(this);
    }

    public void moveBackward() {
        currentRoom.getSide(Direction.South).enter(this);
    }

    @Override
    public String toString() {
        return "Player: " +
                "health=" + health +
                ", currentRoom=" + currentRoom.getRoomId();
    }

    public int getHealth() {
        return health;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}