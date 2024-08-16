package org.example.input;

public class RoverPosition {
    private int x;
    private int y;
    private CompassDirection facing;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CompassDirection getFacing() {
        return facing;
    }

    public void setFacing(CompassDirection facing) {
        this.facing = facing;
    }

    public RoverPosition rotate(Instruction instruction, CompassDirection facing) {
        RoverPosition newPosition = new RoverPosition();
        //check instruction and perform 1 of following 3:
        //M = move forward
        //L = rotate counter-clockwise
        //R = rotate clockwise

        //Then set new facing direction dependent on instruction above
        //Set new (x,y) if moving.

        return newPosition;
    }
}
