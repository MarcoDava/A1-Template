package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManualMazeRunner extends MazeRunner {                  
    private static final Logger logger = LogManager.getLogger();
    private Path path=new Path();
    private Position position;
    private Maze maze;
    private Exit exit;
    private Entry entry;
    private String inputMoves;


    public ManualMazeRunner(Maze maze,String inputMoves) {
        super(maze);
        this.inputMoves=inputMoves;
        this.maze = maze;
        this.exit = new Exit(maze);
        this.entry = new Entry(maze);
        this.position = new Position(entry.getEntryPoint());
    }


    @Override
    public boolean MazeRunnerAlgorithm() {
        for(int i=0;i<inputMoves.length();i++){
            if(inputMoves.substring(i,i+1).equals("F")){
                if(!isWall(position.peekForward())){
                    position.moveForward();
                }
                else{
                    logger.info("Cannot move forward");
                    return false;
                }
            }
            else if(inputMoves.substring(i,i+1).equals("R")){
                position.turnRight();
            }
            else if(inputMoves.substring(i,i+1).equals("L")){
                position.turnLeft();
            }
            else{
                logger.info("Invalid input");
                return false;
            }
        }
        if (Arrays.equals(position.getPosition(),exit.getExitPoint())) {
            logger.info("Maze has been solved");
            return true;
        } 
        logger.info("Maze has not been solved");
        return false;
        
    }
}