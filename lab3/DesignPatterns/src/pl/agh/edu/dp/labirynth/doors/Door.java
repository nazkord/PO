package pl.agh.edu.dp.labirynth.doors;

import pl.agh.edu.dp.Player;
import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.rooms.Room;

public class Door extends MapSite {
    private Room room1;
    private Room room2;

    public Door(Room r1, Room r2){
        this.room1 = r1;
        this.room2 = r2;
    }

    @Override
    public void enter(Player player){
        System.out.println("You went through the " + this.getClass().getSimpleName());
        if(player.getCurrentRoom().equals(room1)) {
            room2.enter(player);
        } else {
            room1.enter(player);
        }
    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room1 = room2;
    }

    @Override
    public String toString() {
        return "Door{" +
                "from: " + room1.getRoomId() +
                ", to: " + room2.getRoomId() +
                '}';
    }
}
