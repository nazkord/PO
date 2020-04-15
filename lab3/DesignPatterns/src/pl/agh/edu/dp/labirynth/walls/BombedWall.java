package pl.agh.edu.dp.labirynth.walls;

import pl.agh.edu.dp.Player;

public class BombedWall extends Wall {

    @Override
    public void enter(Player player) {
        player.receiveDamage(10);
        System.out.println("You hit the bombed wall!");
    }

    @Override
    public String toString() {
        return "BombedWall";
    }
}
