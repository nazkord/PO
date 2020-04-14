package pl.agh.edu.dp.labirynth.walls;

public class EnchantedWall extends Wall {
    public EnchantedWall() {
        super();
    }

    @Override
    public void enter() {
        System.out.println("You hit the enchanted wall");
    }
}
