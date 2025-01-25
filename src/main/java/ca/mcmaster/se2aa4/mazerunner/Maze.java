package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    private static final Logger logger = LogManager.getLogger();
    String[][] mazeArray;

    public Maze(String inputFile) {
        scanMaze(inputFile);
    }

    public String[][] scanMaze(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int rowCount = 0;
            while ((line = reader.readLine()) != null) {
                rowCount++;
            }
            reader.close();

            mazeArray = new String[rowCount][];
            BufferedReader reader2 = new BufferedReader(new FileReader(inputFile));
            int row = 0;
            while ((line = reader2.readLine()) != null) {
                mazeArray[row] = new String[line.length()];
                for (int index = 0; index < line.length(); index++) {
                    if (line.charAt(index) == '#') {
                        mazeArray[row][index] = "#";
                    } else if (line.charAt(index) == ' ') {
                        mazeArray[row][index] = " ";
                    }
                }
                row++;
            }
            reader2.close();
            
        } catch (IOException e) {
            logger.error("An error occurred while reading the maze file", e);
        }
        return mazeArray;
    }

    public String[][] getMazeArray() {
        return mazeArray;
    }

    public void setMazeArray(String[][] mazeArray) {
        this.mazeArray = mazeArray;
    }

    public void printMaze() {
        for (int i = 0; i < mazeArray.length; i++) {
            for (int j = 0; j < mazeArray[i].length; j++) {
                logger.info(mazeArray[i][j]);
            }
            logger.info(System.lineSeparator());
        }
    }

    public int[] getEntryPoint() {
        for (int i = 0; i < mazeArray.length; i++) {
            if (mazeArray[i][0].equals(" ")) {
                return new int[]{i, 0};
            }
        }
        return null;
    }

    public int[] getExitPoint() {
        for (int i = 0; i < mazeArray.length; i++) {
            if (mazeArray[i][mazeArray[i].length - 1].equals(" ")) {
                return new int[]{i, mazeArray[i].length - 1};
            }
        }
        return null;
    }
}