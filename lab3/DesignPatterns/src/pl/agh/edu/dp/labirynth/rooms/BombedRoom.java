package pl.agh.edu.dp.labirynth.rooms;

import pl.agh.edu.dp.labirynth.walls.Wall;

import java.util.function.Supplier;

public class BombedRoom extends Room {

    public BombedRoom(Supplier<Wall> wallSupplier) {
        super(wallSupplier);
    }

    @Override
    public void enter() {
        System.out.println("You entered the bombed room");
    }
}
