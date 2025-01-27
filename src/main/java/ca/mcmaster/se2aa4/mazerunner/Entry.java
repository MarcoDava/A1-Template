package ca.mcmaster.se2aa4.mazerunner;

public class Entry{
    Maze maze;

    public Entry(Maze maze){
        this.maze=maze;
    }

    public int[] getEntryPoint() {
        for (int i = 0; i < maze.getRowLength(); i++) {
            if (maze.getMazeIndex(i, 0).equals(" ")) {
                return new int[]{i, 0};
            }
        }
        return null;
    }
}