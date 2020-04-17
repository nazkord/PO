package pl.agh.edu.dp;

import pl.agh.edu.dp.labirynth.Maze;

import java.io.IOException;

public class MazeGame {
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
    private Maze maze;
    private Player player;

    public MazeGame(Maze maze, Player player) {
        this.maze = maze;
        player.setCurrentRoom(maze.getStartRoom());
        this.player = player;
    }

    private void beforeStart() {
        System.out.println("------------------HELP-------------------");
        System.out.println("a <- left | d -> right | w - up | s - down | q - exit");
        System.out.println("------------------------------------------");
        System.out.println(maze);
        System.out.println(player);
    }

    public void startGame() throws IOException {
        beforeStart();
        char input = 0;
        while(input != 'q') {
            input = (char) System.in.read();
            switch (movePlayer(input)) {
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

    public int movePlayer(int x) {
        switch (x) {
            case 'a' : {
                player.moveLeft();
                break;
            }
            case 'd' : {
                player.moveRight();
                break;
            }
            case 'w' : {
                player.moveForward();
                break;
            }
            case 's' : {
                player.moveBackward();
                break;
            }
            default: {
                return -2;
            }
        }
        return checkAfterMovement();
    }

    private int checkAfterMovement() {
        if(player.getHealth() < 0) {
            return -1;
        }
        if(player.getCurrentRoom().equals(maze.getEndRoom())) {
            return 1;
        }
        System.out.println(player);
        return 0;
    }
}
