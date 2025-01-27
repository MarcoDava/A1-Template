package ca.mcmaster.se2aa4.mazerunner;

public class Exit{
    Maze maze;

    public Exit(Maze maze){
        this.maze=maze;
    }

    public int[] getExitPoint() {
        for (int i = 0; i < maze.getRowLength(); i++) {
            if (maze.getMazeIndex(i, maze.getRowLength()-1).equals(" ")) {
                return new int[]{i, maze.getRowLength()-1};
            }
        }
        return null;
    }
}