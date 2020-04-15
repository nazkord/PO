package pl.agh.edu.dp.labirynth.doors;

import pl.agh.edu.dp.Player;
import pl.agh.edu.dp.labirynth.rooms.Room;

public class EnchantedDoor extends Door {

    public EnchantedDoor(Room r1, Room r2) {
        super(r1, r2);
    }

    @Override
    public String toString() {
        return "Enchanted" + super.toString();
    }
}
