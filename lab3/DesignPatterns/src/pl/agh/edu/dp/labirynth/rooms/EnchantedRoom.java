package pl.agh.edu.dp.labirynth.rooms;

import pl.agh.edu.dp.Player;
import pl.agh.edu.dp.labirynth.walls.Wall;

import java.util.function.Supplier;

public class EnchantedRoom extends Room {

    public EnchantedRoom(Supplier<Wall> wallSupplier) {
        super(wallSupplier);
    }

    @Override
    public String toString() {
        return "\nEnchantedRoom{" + super.getRoomId() +
                ", " + super.getSides();
    }
}
