package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    private static Maze maze;
    private static MazeRunner mazeRunner;

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        Options options = new Options();
        options.addOption("i", true, "input file");
        options.addOption("p", true, "input path"); 

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("i")) {
                String inputFile = cmd.getOptionValue("i");
                logger.info("**** Reading the maze from file " + inputFile);
                maze = new Maze(inputFile);
                
                if(cmd.hasOption("p")){
                    String inputMoves = cmd.getOptionValue("p");
                    maze = new Maze(inputFile);
                    logger.info(inputMoves);
                    mazeRunner = new ManualMazeRunner(maze,inputMoves);
                }else{
                    mazeRunner = new AutomaticMazeRunner(maze);
                }
                if (mazeRunner.MazeRunnerAlgorithm()) {
                        logger.info("Maze solved successfully.");
                    } else {
                        logger.info("Failed to solve the maze.");
                    }
            } 
            else {
                logger.error("Input file not provided. Use -i flag to specify the input file.");
            }
        } catch (ParseException e) {
            logger.error("Failed to parse command line arguments", e);
        } catch (Exception e) {
            logger.error("An error occurred while reading the maze file", e);
        }
    }
}