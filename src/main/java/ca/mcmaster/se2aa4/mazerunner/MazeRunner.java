package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class MazeRunner {
    private static final Logger logger = LogManager.getLogger();
    private String CanonizedPath = "";
    private Position position=new Position();
    private Maze maze;
    private Exit exit=new Exit(maze);

    public MazeRunner(Maze maze) {
        this.maze = maze;
    }

    public boolean MazeRunnerAlgorithm() {

        while (exit.getExitPoint()!=position.getPosition()) {
            if (!isWall(position.peekRight())) {
                position.turnRight();
                position.moveForward();
            }
            else if(!isWall(position.peekForward())){
                position.moveForward();
            }
            else if(!isWall(position.peekLeft())){
                position.turnLeft();
                position.moveForward();
            }
            else if(isDeadend(position.getPosition())){
                position.turnLeft();
                position.turnLeft();
            }
            
        }
        if (position.getPosition()==exit.getExitPoint()) {
            logger.info("Maze has been solved");
            logger.info("Path: " + CanonizedPath);
            return true;
        } else {
            logger.info("Maze has not been solved");
            return false;
        }
    }

    public void addPath(String value) {
        CanonizedPath = CanonizedPath + value;
    }

    public void deletePath() {
        if (CanonizedPath != null && CanonizedPath.length() > 0) {
            CanonizedPath = CanonizedPath.substring(0, CanonizedPath.length() - 1);
        }
    }

    public boolean isDeadend(int[] position) {
        int row = position[0];
        int col = position[1];
        int walls = 0;
        if (row > 0 && isWall(new int[]{row - 1, col})) {
            walls++;
        }
        if (col > 0 && isWall(new int[]{row, col - 1})) {
            walls++;
        }
        if (row < maze.getRowLength() - 1 && isWall(new int[]{row + 1, col})) {
            walls++;
        }
        if (col < maze.getColLength() - 1 && isWall(new int[]{row, col + 1})) {
            walls++;
        }
        return walls > 2;
    }

    public boolean isWall(int[] position) {
        int row=position[0];
        int col=position[1];
        if(maze.getMazeIndex(row,col).equals("#")){
            return true;
        }
        return false;
    }

    public boolean isFinish(int[] position) {
        return Arrays.equals(position, exit.getExitPoint());
    }

    // public boolean isFork(int[] position){
    //     int openPaths = amountOfPaths(position);
    //     if(openPaths>2){
    //         forkLocations.addForkLocations(position);
    //         return true;
    //     }
    //     return false;
    // }


    public int amountOfPaths(int[] position) {
        int row = position[0];
        int col = position[1];
        int openPaths = 0;
        if (row > 0 && !isWall(new int[]{row - 1, col})) {
            openPaths++;
        }
        if (col > 0 && !isWall(new int[]{row, col - 1})) {
            openPaths++;
        }
        if (row < maze.getRowLength() - 1 && !isWall(new int[]{row + 1, col})) {
            openPaths++;
        }
        if (col < maze.getColLength() - 1 && !isWall(new int[]{row, col + 1})) {
            openPaths++;
        }
        return openPaths;
    }
}