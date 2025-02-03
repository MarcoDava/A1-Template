package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AutomaticMazeRunner extends MazeRunner {
    private static final Logger logger = LogManager.getLogger();
    private Path path=new Path();
    private Position position;
    private Maze maze;
    private Exit exit;
    private Entry entry;
    public AutomaticMazeRunner(Maze maze) {
        super(maze);
        this.maze = maze;
        exit = new Exit(maze);
        entry = new Entry(maze);
        position=new Position(entry.getEntryPoint());
    }

    @Override
    public boolean MazeRunnerAlgorithm(){
        boolean atEnd = false;
        while (!atEnd) {
            if (!isWall(position.peekRight())) {
                position.turnRight();
                position.moveForward();
                path.addPath("RF");
            }
            else if(!isWall(position.peekForward())){
                position.moveForward();
                path.addPath("F");
            }
            else if(!isWall(position.peekLeft())){
                position.turnLeft();
                position.moveForward();
                path.addPath("LF");
            }
            else{
                position.turnLeft();
                position.turnLeft();
                position.moveForward();
                path.addPath("LLF");
            }
            logger.info("Current position: " + Arrays.toString(position.getPosition()));
            if(Arrays.equals(exit.getExitPoint(),position.getPosition())){
                atEnd=true;
            }
        }
        if (Arrays.equals(position.getPosition(),exit.getExitPoint())) {
            logger.info("Maze has been solved");
            logger.info("Path: " + path.getFactorizedPath());
            return true;
        } else {
            logger.info("Maze has not been solved");
            return false;
        }
    }
}