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

    public abstract boolean MazeRunnerAlgorithm();

}