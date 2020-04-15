package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.rooms.Room;

import java.util.Vector;

public class Maze {
    private Vector<Room> rooms;

    public Maze() {
        this.rooms = new Vector<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers()  {
        return rooms.size();
    }

    @Override
    public String toString() {
        return "Maze rooms:" + rooms;
    }

    public Room getStartRoom() {
        return rooms.get(0);
    }

    public Room getEndRoom() {
        return rooms.get(rooms.size() - 1);
    }
}
