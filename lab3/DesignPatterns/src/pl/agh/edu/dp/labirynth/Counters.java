package pl.agh.edu.dp.labirynth;

public class Counters {
    private int roomCounter;
    private int wallCounter;
    private int doorCounter;

    public Counters() {
        this.roomCounter = 0;
        this.wallCounter = 0;
        this.doorCounter = 0;
    }

    public int getRoomCounter() {
        return roomCounter;
    }

    public void setRoomCounter(int roomCounter) {
        this.roomCounter = roomCounter;
    }

    public int getWallCounter() {
        return wallCounter;
    }

    public void setWallCounter(int wallCounter) {
        this.wallCounter = wallCounter;
    }

    public int getDoorCounter() {
        return doorCounter;
    }

    public void setDoorCounter(int doorCounter) {
        this.doorCounter = doorCounter;
    }

    @Override
    public String toString() {
        return "Rooms=" + roomCounter +
                ", Walls=" + wallCounter +
                ", Doors=" + doorCounter;
    }
}
