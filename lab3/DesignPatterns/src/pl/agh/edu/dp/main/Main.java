package pl.agh.edu.dp.main;

import pl.agh.edu.dp.builders.CountingMazeBuilder;
import pl.agh.edu.dp.builders.StandardBuilderMaze;
import pl.agh.edu.dp.factories.MazeDirector;

public class Main {

    public static void main(String[] args) {

        MazeDirector mazeDirector = new MazeDirector();

        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();
        mazeDirector.createMaze(standardBuilderMaze);
        System.out.println(standardBuilderMaze.getResultedMaze().getRoomNumbers());

        CountingMazeBuilder countingMazeBuilder = new CountingMazeBuilder();
        mazeDirector.createMaze(countingMazeBuilder);
        System.out.println(countingMazeBuilder.getCount());


        mazeDirector.createEnchantedMaze(standardBuilderMaze);
        System.out.println(standardBuilderMaze.getResultedMaze().getRoomNumbers());

        mazeDirector.createEnchantedMaze(countingMazeBuilder);
        System.out.println(countingMazeBuilder.getCount());

        mazeDirector.createBombedMaze(standardBuilderMaze);
        System.out.println(standardBuilderMaze.getResultedMaze().getRoomNumbers());

        mazeDirector.createBombedMaze(countingMazeBuilder);
        System.out.println(countingMazeBuilder.getCount());
    }
}