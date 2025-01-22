package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeRunner{
    Stack<String> FactorizedPath = new Stack<>();
    Stack<String> CanonizedPath = new Stack<>();
    Stack<int[]> ForkLocations = new Stack<>();
    boolean facingNorth = false;
    boolean facingSouth = false;
    boolean facingEast = false;
    boolean facingWest = true;

    public void addPath(){
        
    }

    public void deletePath(){

    }

    public void backTrackToFork(){

    }

    public boolean isDeadend(int row,int col){

    }

    public boolean isWall(int row,int col){

    }

    public boolean isFinish(int row,int col){
        
    }

    public Stack getPath(){

    }

    public void moveForward(){

    }

    public void turnLeft(){

    }

    public void turnRight(){

    }

    public int[] getPosition(){

    }

    public void setPosition(){

    }
}