package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeRunner{
    private String CanonizedPath = "";
    private int[][] ForkLocations = new int[][];//MAKE THIS A MAP, AND THIS WILL BE ABLE TO TRACK IF A FORK HAS BEEN FULLY EXPLORED, ADD 1 TO THE VALUE EVERY TIME THE LOCATION HAS BEEN EXPLORED.
    private int[] forkVisits = new int[];
    private int[] position = new int[2];//change at some point
    private int[] finishArea = new int[2];//change at some point
    private String[][] mazeArray;
    private boolean facingNorth = false;
    private boolean facingSouth = false;
    private boolean facingEast = false;
    private boolean facingWest = true;

    public MazeRunner(String[][] mazeArray, int[] entryPoint, int[] finishArea){
        position = entryPoint;
        this.finishArea = finishArea;
        this.mazeArray = mazeArray;
    }

    public MazeRunnerAlgorithm(String[][] mazeArray){
        while(!isFinish(position)){
            if(!isWall(peekForward())){
                moveForward();
            }
            else if(!isWall(peekLeft())){
                turnLeft();
                moveForward();
            }
            else if(!isWall(peekRight())){
                turnRight();
                moveForward();
            }
            else{
                turnRight();
                turnRight();
            }
            moves++;
            if(moves>1000){
                break;
            }
        }
        if(isFinish(position)){
            logger.info("Maze has been solved");
        }
        else{
            logger.info("Maze has not been solved");
        }
    }

    public void addPath(String value){
        CanonizedPath=CanonizedPath+value;
    }

    public void deletePath(){
        if (CanonizedPath != null && str.length() > 0) {
            CanonizedPath = CanonizedPath.substring(0, CanonizedPath.length() - 1);
        }
    }

    public void backTrackToFork(){
        turnLeft();
        turnLeft();
        while(position!=ForkLocations[ForkLocations.length()-1]){
            if(!isWall(peekForward())){
                moveForward();
            }
            else if(!isWall(peekLeft())){
                turnLeft();
                moveForward();
            }
            else{
                turnRight();
                moveForward();
            }
        }
    }

    public boolean isDeadend(int[] position){
        int row = position[0];
        int col = position[1];
        int walls = 0;
        if(row>0){
            if(!isWall(row-1,col)){
                walls++;
            }
        }
        if(col>0){
            if(!isWall(row,col-1)){
                walls++;
            }
        }
        if(row<mazeArray.length-1){
            if(!isWall(row+1,col)){
                walls++;
            }
        }
        if(col<mazeArray[0].length-1){
            if(!isWall(row,col+1)){
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

    public boolean isWall(int[] position){
        int row = position[0];
        int col = position[1];
        if(mazeArray[row][col].equals("#")){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFinish(int[] position){
        int row = position[0];
        int col = position[1];
        if(position==finishArea){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFork( int[] position){
        int openPaths = amountOfPaths(position);
        if(openPaths>2){
            boolean exploredFork=false;
            for(int i=0;i<ForkLocations.length;i++){
                if(position==ForkLocation[i]){//implement this with java
                    forkVisits[i]++;
                    exploredFork=true;
                }
            }
            if(!exploredFork){
                ForkLocation.append(position);
                forkVisits.append(1);
            }
        }
            return true;
        }
        else{
            return false;
        }
    }

    public int amountOfPaths(int[] position){
        int row = position[0];
        int col = position[1];
        int openPaths = 0;
        if(row>0){
            if(!isWall(row-1,col)){
                openPaths++;
            }
        }
        if(col>0){
            if(!isWall(row,col-1)){
                openPaths++;
            }
        }
        if(row<mazeArray.length-1){
            if(!isWall(row+1,col)){
                openPaths++;
            }
        }
        if(col<mazeArray[0].length-1){
            if(!isWall(row,col+1)){
                openPaths++;
            }
        }
        return openPaths;
    }

    public int[] peekForward(int[] position){
        if(facingNorth){
            return new int[]{position[0]+1,position[1]};
        }
        else if(facingSouth){
            return new int[]{position[0]-1,position[1]};
        }
        else if(facingEast){
            return new int[]{position[0],position[1]-1};
        }
        else if(facingWest){
            return new int[]{position[0],position[1]+1};
        }
    }

    public int[] peekLeft(int[] position){
        if(facingNorth){
            return new int[]{position[0],position[1]-1};
        }
        else if(facingSouth){
            return new int[]{position[0],position[1]+1};
        }
        else if(facingEast){
            return new int[]{position[0]+1,position[1]};
        }
        else if(facingWest){
            return new int[]{position[0]-1,position[1]};
        }
    }

    public int[] peekRight(int[] position){
        if(facingNorth){
            return new int[]{position[0],position[1]+1};
        }
        else if(facingSouth){
            return new int[]{position[0],position[1]-1};
        }
        else if(facingEast){
            return new int[]{position[0]-1,position[1]};
        }
        else if(facingWest){
            return new int[]{position[0]+1,position[1]};
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
        cananonizedPathArray = getPath();
        factorizedPath;
        String target="";
        int repeats=0;
        for(int i=0;i<CanonizedPath.length()-1;i++){
            if(target==CanonizedPath.substring(i,i+1)){
                repeats++;
            }
            else{
                FactorizedPath+=repeats+""+target;
                target=CanonizedPath.substring(i,i+1);
                repeats=1;
            }
        }
    }
}