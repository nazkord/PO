package pl.agh.edu.dp.main;

import pl.agh.edu.dp.MazeGame;
import pl.agh.edu.dp.Player;
import pl.agh.edu.dp.builders.CountingMazeBuilder;
import pl.agh.edu.dp.builders.StandardBuilderMaze;
import pl.agh.edu.dp.factories.MazeDirector;
import pl.agh.edu.dp.labirynth.Maze;

import java.io.IOException;

public class Main {

    public static final String WON = "\n" +
            " /$$     /$$ /$$$$$$  /$$   /$$       /$$      /$$  /$$$$$$  /$$   /$$\n" +
            "|  $$   /$$//$$__  $$| $$  | $$      | $$  /$ | $$ /$$__  $$| $$$ | $$\n" +
            " \\  $$ /$$/| $$  \\ $$| $$  | $$      | $$ /$$$| $$| $$  \\ $$| $$$$| $$\n" +
            "  \\  $$$$/ | $$  | $$| $$  | $$      | $$/$$ $$ $$| $$  | $$| $$ $$ $$\n" +
            "   \\  $$/  | $$  | $$| $$  | $$      | $$$$_  $$$$| $$  | $$| $$  $$$$\n" +
            "    | $$   | $$  | $$| $$  | $$      | $$$/ \\  $$$| $$  | $$| $$\\  $$$\n" +
            "    | $$   |  $$$$$$/|  $$$$$$/      | $$/   \\  $$|  $$$$$$/| $$ \\  $$\n" +
            "    |__/    \\______/  \\______/       |__/     \\__/ \\______/ |__/  \\__/\n" +
            "                                                                      \n" +
            "                                                                      \n" +
            "                                                                      \n";

    public static final String GAME_OVER = "\n" +
            "  /$$$$$$   /$$$$$$  /$$      /$$ /$$$$$$$$              /$$$$$$  /$$    /$$ /$$$$$$$$ /$$$$$$$ \n" +
            " /$$__  $$ /$$__  $$| $$$    /$$$| $$_____/             /$$__  $$| $$   | $$| $$_____/| $$__  $$\n" +
            "| $$  \\__/| $$  \\ $$| $$$$  /$$$$| $$                  | $$  \\ $$| $$   | $$| $$      | $$  \\ $$\n" +
            "| $$ /$$$$| $$$$$$$$| $$ $$/$$ $$| $$$$$               | $$  | $$|  $$ / $$/| $$$$$   | $$$$$$$/\n" +
            "| $$|_  $$| $$__  $$| $$  $$$| $$| $$__/               | $$  | $$ \\  $$ $$/ | $$__/   | $$__  $$\n" +
            "| $$  \\ $$| $$  | $$| $$\\  $ | $$| $$                  | $$  | $$  \\  $$$/  | $$      | $$  \\ $$\n" +
            "|  $$$$$$/| $$  | $$| $$ \\/  | $$| $$$$$$$$            |  $$$$$$/   \\  $/   | $$$$$$$$| $$  | $$\n" +
            " \\______/ |__/  |__/|__/     |__/|________/             \\______/     \\_/    |________/|__/  |__/\n" +
            "                                                                                                \n" +
            "                                                                                                \n" +
            "                                                                                                \n";

    public static void main(String[] args) throws IOException {

        MazeDirector mazeDirector = new MazeDirector();
        StandardBuilderMaze standardBuilderMaze = new StandardBuilderMaze();
        mazeDirector.createBombedMaze(standardBuilderMaze);

        Maze maze = standardBuilderMaze.getResultedMaze();
        System.out.println(maze);

        Player player = new Player(100);
        MazeGame mazeGame = new MazeGame(maze, player);
        System.out.println(player);

        char input = 0;

        while(input != 'q') {
            input = (char) System.in.read();
            switch (mazeGame.movePlayer(input)) {
                case -1 : {
                    System.out.println("You died");
                    System.out.println(GAME_OVER);
                    return;
                }
                case 1 : {
                    System.out.println(WON);
                    return;
                }
                case 0 : {
                    System.out.println(maze);
                }
            }
        }
    }
}