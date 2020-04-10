package pl.agh.edu.dp.labirynth;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Room extends MapSite {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int roomId;
    private Map<Direction, MapSite> sides;

    public Room(){
        this.sides = new EnumMap<>(Direction.class);
        fillSides();
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

    }

    private void fillSides() {
        this.setSide(Direction.North, new Wall());
        this.setSide(Direction.East, new Wall());
        this.setSide(Direction.South, new Wall());
        this.setSide(Direction.West, new Wall());
    }

}