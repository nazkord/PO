package pl.agh.edu.dp.main;

import pl.agh.edu.dp.MazeGame;
import pl.agh.edu.dp.Player;
import pl.agh.edu.dp.builders.StandardBuilderMaze;
import pl.agh.edu.dp.factories.MazeDirector;
import pl.agh.edu.dp.labirynth.Maze;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        MazeDirector mazeDirector = new MazeDirector();
        mazeDirector.checkSingletons();

        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();
        mazeDirector.createBombedMaze(standardBuilderMaze);

        Maze maze = standardBuilderMaze.getResultedMaze();
        Player player = new Player(100);
        MazeGame mazeGame = new MazeGame(maze, player);
        mazeGame.startGame();
    }
}