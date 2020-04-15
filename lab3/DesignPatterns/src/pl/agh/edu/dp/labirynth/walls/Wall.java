package pl.agh.edu.dp.labirynth.walls;

import pl.agh.edu.dp.Player;
import pl.agh.edu.dp.labirynth.MapSite;

public class Wall extends MapSite {

    public Wall() {

    }

    @Override
    public void enter(Player player){
        System.out.println("You hit the wall");
    }

    @Override
    public String toString() {
        return "Wall";
    }
}