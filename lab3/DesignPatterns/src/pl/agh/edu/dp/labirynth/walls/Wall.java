package pl.agh.edu.dp.labirynth.walls;

import pl.agh.edu.dp.labirynth.MapSite;

public class Wall extends MapSite {

    public Wall() {

    }

    @Override
    public void enter(){
        System.out.println("You hit the wall");
    }
}
