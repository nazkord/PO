package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;

    public static Direction getOppositeTo(Direction direction) {
        switch (direction) {
            case North: return South;
            case South: return North;
            case East: return West;
            case West: return East;
        }
        throw new IllegalArgumentException("There is no such direction: " + direction);
    }
}