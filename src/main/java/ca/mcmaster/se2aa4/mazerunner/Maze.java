package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze{
    private static final Logger logger = LogManager.getLogger();
    String[][] mazeArray;
    Maze(String inputFile){
        scanMaze(inputFile);
    }

    public String[][] scanMaze(String inputFile){
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int index = 0; index < line.length(); index++) {
                    if (line.charAt(index) == '#') {
                        logger.info("WALL ");
                    } else if (line.charAt(index) == ' ') {
                        logger.info("PASS ");
                    }
                }
                logger.info(System.lineSeparator());
            }
            reader.close();
        }
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
        for(int i=0; i<mazeArray.length();i++){
            if(mazeArray[i][0].equals(" ")){
                return new int[]{i,0};
            }
            else{
                return null;
            }
        }
    }
    public int[] getExitPoint(){
        for(int i=0; i<mazeArray.length();i++){
            if(mazeArray[i][mazeArray.length()-1].equals(" ")){
                return new int[]{i,mazeArray.length()-1};
            }
            else{
                return null;
            }
        }
    }

}