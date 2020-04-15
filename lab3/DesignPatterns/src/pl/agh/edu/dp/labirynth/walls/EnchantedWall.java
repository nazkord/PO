package pl.agh.edu.dp.labirynth.walls;

import pl.agh.edu.dp.Player;

public class EnchantedWall extends Wall {

    @Override
    public void enter(Player player) {
        player.receiveDamage(15);
        System.out.println("You hit the enchanted wall!");
    }

    @Override
    public String toString() {
        return "EnchantedWall";
    }
}
