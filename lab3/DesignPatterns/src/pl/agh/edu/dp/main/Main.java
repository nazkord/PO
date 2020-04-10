package pl.agh.edu.dp.main;

import pl.agh.edu.dp.builders.CountingMazeBuilder;
import pl.agh.edu.dp.builders.StandardBuilderMaze;
import pl.agh.edu.dp.labirynth.*;

public class Main {

    public static void main(String[] args) {

        MazeGame mazeGame = new MazeGame();
        Maze maze = mazeGame.createMaze();
        System.out.println(maze.getRoomNumbers());

        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();
        mazeGame.createMaze(standardBuilderMaze);

        Maze maze2 = standardBuilderMaze.getResultedMaze();
        System.out.println(maze2.getRoomNumbers());

        CountingMazeBuilder countingMazeBuilder = new CountingMazeBuilder();
        mazeGame.createMaze(countingMazeBuilder);
        System.out.println(countingMazeBuilder.getCount());

    }
}



