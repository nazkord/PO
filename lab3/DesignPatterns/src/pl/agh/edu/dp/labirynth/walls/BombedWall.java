package pl.agh.edu.dp.labirynth.walls;

public class BombedWall extends Wall {
    public BombedWall() {
        super();
    }

    @Override
    public void enter() {
        System.out.println("You hit the bombed wall");
    }
}
