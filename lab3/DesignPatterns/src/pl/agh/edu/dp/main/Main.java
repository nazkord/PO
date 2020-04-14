package pl.agh.edu.dp.main;

import pl.agh.edu.dp.builders.CountingMazeBuilder;
import pl.agh.edu.dp.builders.StandardBuilderMaze;
import pl.agh.edu.dp.factories.BombedMazeFactory;
import pl.agh.edu.dp.factories.EnchantedMazeFactory;
import pl.agh.edu.dp.factories.MazeFactory;
import pl.agh.edu.dp.labirynth.*;

public class Main {

    public static void main(String[] args) {

        MazeGame mazeGame = new MazeGame();

        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();
        CountingMazeBuilder countingMazeBuilder = new CountingMazeBuilder();


        mazeGame.createMaze(standardBuilderMaze);
        System.out.println(standardBuilderMaze.getResultedMaze().getRoomNumbers());


        mazeGame.createMaze(countingMazeBuilder);
        System.out.println(countingMazeBuilder.getCount());


        MazeFactory factory = new EnchantedMazeFactory();
        MazeFactory factory1 = new BombedMazeFactory();


        mazeGame.createMaze(standardBuilderMaze, factory);
        System.out.println(standardBuilderMaze.getResultedMaze().getRoomNumbers());

        mazeGame.createMaze(countingMazeBuilder, factory);
        System.out.println(countingMazeBuilder.getCount());

        mazeGame.createMaze(standardBuilderMaze, factory1);
        System.out.println(standardBuilderMaze.getResultedMaze().getRoomNumbers());

        mazeGame.createMaze(countingMazeBuilder, factory1);
        System.out.println(countingMazeBuilder.getCount());
    }
}



