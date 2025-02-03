package ca.mcmaster.se2aa4.mazerunner;

public class Position{
    private int[] position;
    private Direction direction = Direction.EAST;

    Position(int[] position) {
        this.position = position;
    }
    
    public void setPosition(int[] newPosition) {
        position = newPosition;
    }
    public int[] getPosition(){
        return position;
    }
    public int[] peekForward() {
        if (direction.equals(Direction.NORTH)) {
            return new int[]{position[0] - 1, position[1]};
        } else if (direction.equals(Direction.SOUTH)) {
            return new int[]{position[0] + 1, position[1]};
        } else if (direction.equals(Direction.EAST)) {
            return new int[]{position[0], position[1] + 1};
        } else if (direction.equals(Direction.WEST)) {
            return new int[]{position[0], position[1] - 1};
        }
        return position;
    }

    public int[] peekLeft() {
        if (direction.equals(Direction.NORTH)) {
            return new int[]{position[0], position[1] - 1};
        } else if (direction.equals(Direction.SOUTH)) {
            return new int[]{position[0], position[1] + 1};
        } else if (direction.equals(Direction.EAST)) {
            return new int[]{position[0] - 1, position[1]};
        } else if (direction.equals(Direction.WEST)) {
            return new int[]{position[0] + 1, position[1]};
        }
        return position;
    }

    public int[] peekRight() {
        if (direction.equals(Direction.NORTH)) {
            return new int[]{position[0], position[1] + 1};
        } else if (direction.equals(Direction.SOUTH)) {
            return new int[]{position[0], position[1] - 1};
        } else if (direction.equals(Direction.EAST)) {
            return new int[]{position[0] + 1, position[1]};
        } else if (direction.equals(Direction.WEST)) {
            return new int[]{position[0] - 1, position[1]};
        }
        return position;
    }

    public void turnLeft() {
        if (direction.equals(Direction.NORTH)) {
            direction=Direction.WEST;
        } else if (direction.equals(Direction.SOUTH)) {
            direction=Direction.EAST;
        } else if (direction.equals(Direction.EAST)) {
            direction=Direction.NORTH;
        } else if (direction.equals(Direction.WEST)) {
            direction=Direction.SOUTH;
        }
    }

    public void turnRight() {
        if (direction.equals(Direction.NORTH)) {
            direction=Direction.EAST;
        } else if (direction.equals(Direction.SOUTH)) {
            direction=Direction.WEST;
        } else if (direction.equals(Direction.EAST)) {
            direction=Direction.SOUTH;
        } else if (direction.equals(Direction.WEST)) {
            direction=Direction.NORTH;
        }
    }

    public void moveForward() {
        if (direction.equals(Direction.NORTH)) {
            position[0]--;
        } else if (direction.equals(Direction.SOUTH)) {
            position[0]++;
        } else if (direction.equals(Direction.EAST)) {
            position[1]++;
        } else if (direction.equals(Direction.WEST)) {
            position[1]--;
        }
    }
}