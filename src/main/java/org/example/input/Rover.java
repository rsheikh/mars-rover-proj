package org.example.input;

public class Rover {
    String name;
    RoverPosition roverPosition;

    public Rover(String name, RoverPosition roverPosition) {
        this.name = name;
        this.roverPosition = roverPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoverPosition getRoverPosition() {
        return roverPosition;
    }

    public void setRoverPosition(RoverPosition roverPosition) {
        this.roverPosition = roverPosition;
    }

    public CompassDirection rotate(Instruction instruction, CompassDirection facing) {
        CompassDirection compassDirection = null;
        int returnPosInt = 0;

        if(instruction.name().equalsIgnoreCase(Instruction.R.name())) {
            returnPosInt = facing.ordinal() + 1;
            if(returnPosInt < CompassDirection.values().length) {
                compassDirection = CompassDirection.values()[returnPosInt];
            } else {
                returnPosInt = returnPosInt - CompassDirection.values().length;
                compassDirection = CompassDirection.values()[returnPosInt];
            }
        }

        if(instruction.name().equalsIgnoreCase(Instruction.L.name())) {
            returnPosInt = facing.ordinal() - 1;
            if(returnPosInt < CompassDirection.values().length && returnPosInt > -1) {
                compassDirection = CompassDirection.values()[returnPosInt];
            } else {
                returnPosInt = returnPosInt + CompassDirection.values().length;
                compassDirection = CompassDirection.values()[returnPosInt];
            }
        }

        if(instruction.name().equalsIgnoreCase(Instruction.M.name())) {
            compassDirection = facing;
        }

        return compassDirection;
    }

    public void move(Rover rover) {
        CompassDirection facing = rover.roverPosition.getFacing();
        int x = rover.getRoverPosition().getX();
        int y = rover.getRoverPosition().getY();

        if(facing == CompassDirection.N) {
            rover.getRoverPosition().setY(y+1);
        }
        if(facing == CompassDirection.E) {
            rover.getRoverPosition().setX(x+1);
        }
        if(facing == CompassDirection.S) {
            rover.getRoverPosition().setY(y-1);
        }
        if(facing == CompassDirection.W) {
            rover.getRoverPosition().setX(x-1);
        }
    }
}
