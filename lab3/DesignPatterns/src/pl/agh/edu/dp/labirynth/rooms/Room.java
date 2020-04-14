package pl.agh.edu.dp.labirynth.rooms;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.walls.Wall;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class Room extends MapSite {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int roomId;
    private Map<Direction, MapSite> sides;

    public Room(Supplier<Wall> wallSupplier) {
        this.sides = new EnumMap<>(Direction.class);
        fillSides(wallSupplier);
        this.roomId = count.incrementAndGet();
    }

    public MapSite getSide(Direction direction){
        return this.sides.get(direction);
    }

    public void setSide(Direction direction, MapSite ms){
        this.sides.put(direction, ms);
    }

    public int getRoomId() {
        return this.roomId;
    }

    @Override
    public void enter(){
        System.out.println("You came to the room");
    }

    private void fillSides(Supplier<Wall> wallSupplier) {
        this.setSide(Direction.North, wallSupplier.get());
        this.setSide(Direction.East, wallSupplier.get());
        this.setSide(Direction.South, wallSupplier.get());
        this.setSide(Direction.West, wallSupplier.get());
    }

}