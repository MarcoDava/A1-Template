package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MazeRunner {
    private static final Logger logger = LogManager.getLogger();
    private Path path=new Path();
    private Position position;
    private Maze maze;
    private Exit exit;
    private Entry entry;

    public MazeRunner(Maze maze) {
        this.maze = maze;
        exit = new Exit(maze);
        entry = new Entry(maze);
        position=new Position(entry.getEntryPoint());
    }

    public abstract boolean MazeRunnerAlgorithm();

    public boolean isWall(int[] position) {
        int row=position[0];
        int col=position[1];
        if(maze.getMazeIndex(row,col).equals("#")){
            return true;
        }
        return false;
    }

}