package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();
    private Maze maze;
    private MazeRunner mazeRunner;
    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        Options options = new Options();
        options.addOption("i", true, "input file");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("i")) {
                String inputFile = cmd.getOptionValue("i");
                logger.info("**** Reading the maze from file " + inputFile);
                maze = new Maze(inputFile);
                mazeRunner = new MazeRunner(maze.getMazeArray(), maze.getEntryPoint(), maze.getFinishArea());
            } else {
                logger.error("Input file not provided. Use -i flag to specify the input file.");
            }
        } catch (ParseException e) {
            logger.error("Failed to parse command line arguments", e);
        } catch (Exception e) {
            logger.error("An error occurred while reading the maze file", e);
        }
    }
}