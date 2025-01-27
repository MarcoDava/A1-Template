package ca.mcmaster.se2aa4.mazerunner;

public class Direction{
    //defaults the direction to East
    private boolean facingNorth = false;
    private boolean facingSouth = false;
    private boolean facingEast = true;
    private boolean facingWest = false;

    public void turnLeft() {
        if (facingNorth) {
            facingWest = true;
            facingNorth = false;
        } else if (facingSouth) {
            facingEast = true;
            facingSouth = false;
        } else if (facingEast) {
            facingNorth = true;
            facingEast = false;
        } else if (facingWest) {
            facingSouth = true;
            facingWest = false;
        }
    }

    public void turnRight() {
        if (facingNorth) {
            facingEast = true;
            facingNorth = false;
        } else if (facingSouth) {
            facingWest = true;
            facingSouth = false;
        } else if (facingEast) {
            facingSouth = true;
            facingEast = false;
        } else if (facingWest) {
            facingNorth = true;
            facingWest = false;
        }
    }


}