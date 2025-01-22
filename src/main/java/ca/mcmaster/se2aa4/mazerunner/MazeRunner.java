package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeRunner{
    private String[] FactorizedPath = new Stack<>();
    private Stack<String> CanonizedPath = new Stack<>();
    private Stack<int[]> ForkLocations = new Stack<>();
    private int[] position = new int[2];//change at some point
    private int[] finishArea = new int[2];//change at some point
    private boolean facingNorth = false;
    private boolean facingSouth = false;
    private boolean facingEast = false;
    private boolean facingWest = true;
    private Maze mazeMap = new Maze();

    public void addPath(String value){
        CanonizedPath.push(value);
    }

    public void deletePath(){
        CanonizedPath.pop();
    }

    public void backTrackToFork(){
        while(position!=ForkLocations.peek()){
            deletePath();
        }
        ForkLocations.pop();
        turnLeft();
    }

    public boolean isDeadend(String[][] mazeArray, int row,int col){
        int walls = 0;
        if(row>0){
            if(!isWall(mazeArray,row-1,col)){
                walls++;
            }
        }
        if(col>0){
            if(!isWall(mazeArray,row,col-1)){
                walls++;
            }
        }
        if(row<mazeArray.length-1){
            if(!isWall(mazeArray,row+1,col)){
                walls++;
            }
        }
        if(col<mazeArray[0].length-1){
            if(!isWall(mazeArray,row,col+1)){
                walls++;
            }
        }
        if(walls>2){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isWall(String[][] mazeArray, int row,int col){
        if(mazeArray[row][col].equals("#")){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFinish(String[][] mazeArray, int row,int col){
        if(position==finishArea){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFork(String[][] mazeArray, int row,int col){
        int openPaths = 0;
        if(row>0){
            if(!isWall(mazeArray,row-1,col)){
                openPaths++;
            }
        }
        if(col>0){
            if(!isWall(mazeArray,row,col-1)){
                openPaths++;
            }
        }
        if(row<mazeArray.length-1){
            if(!isWall(mazeArray,row+1,col)){
                openPaths++;
            }
        }
        if(col<mazeArray[0].length-1){
            if(!isWall(mazeArray,row,col+1)){
                openPaths++;
            }
        }
        if(openPaths>2){
            return true;
        }
        else{
            return false;
        }
    }

    public String[] getPath(){
        return CanonizedPath.toArray();
    }

    public void moveForward(){
        if(facingNorth){
            position[0]++;
        }
        else if(facingSouth){
            position[0]--;
        }
        else if(facingEast){
            position[1]--;
        }
        else if(facingWest){
            position[1]++;
        }
        addPath("F");
    }

    public void turnLeft(){
        if(facingNorth){
            facingWest = true;
            facingNorth = false;
        }
        else if(facingSouth){
            facingEast = true;
            facingSouth = false;
        }
        else if(facingEast){
            facingNorth = true;
            facingEast = false;
        }
        else if(facingWest){
            facingSouth = true;
            facingWest = false;
        }
        addPath("L");
    }

    public void turnRight(){
        if(facingNorth){
            facingEast = true;
            facingNorth = false;
        }
        else if(facingSouth){
            facingWest = true;
            facingSouth = false;
        }
        else if(facingEast){
            facingSouth = true;
            facingEast = false;
        }
        else if(facingWest){
            facingNorth = true;
            facingWest = false;
        }
        addPath("R");
    }

    public int[] getPosition(){
        return position;
    }

    public void setPosition(int[] newposition){
        position = newposition;
    }

    public String[] getFactorizedPath(){
        for(int i=0;i<CanonizedPath.size();i++){
            FactorizedPath.push(CanonizedPath.pop());
        }
    }
}