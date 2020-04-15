package pl.agh.edu.dp.labirynth.rooms;

import pl.agh.edu.dp.Player;
import pl.agh.edu.dp.labirynth.walls.Wall;

import java.util.function.Supplier;

public class BombedRoom extends Room {

    public BombedRoom(Supplier<Wall> wallSupplier) {
        super(wallSupplier);
    }

    @Override
    public void enter(Player player) {
        super.enter(player);
        System.out.println("You have 10 seconds to leave the room");
    }

    @Override
    public String toString() {
        return "\nBombedRoom{" + super.getRoomId() +
                ", " + super.getSides();
    }
}
