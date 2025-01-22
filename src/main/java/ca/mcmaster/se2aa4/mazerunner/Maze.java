package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze{
    private static final Logger logger = LogManager.getLogger();
    String[][] mazeArray;
    Maze(String[][] mazeArray){
        this.mazeArray = mazeArray;
    }
    public String[][] getMazeArray(){
        return mazeArray;
    }
    public void setMazeArray(String[][] mazeArray){
        this.mazeArray = mazeArray;
    }
    public void printMaze(){
        for (int i = 0; i < mazeArray.length; i++){
            for (int j = 0; j < mazeArray[i].length; j++){
                logger.info(mazeArray[i][j]);
            }
            logger.info(System.lineSeparator());
        }
    }
    public int[] getEntryPoint(){

    }
    public int[] getExitPoint(){

    }

}