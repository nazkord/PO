package pl.agh.edu.dp;

import pl.agh.edu.dp.labirynth.Maze;

public class MazeGame {
    private Maze maze;
    private Player player;

    public MazeGame(Maze maze, Player player) {
        this.maze = maze;
        player.setCurrentRoom(maze.getStartRoom());
        this.player = player;
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
