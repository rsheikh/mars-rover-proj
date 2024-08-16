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

    public void move(Rover rover, PlateauSize plateauSize) {
        CompassDirection facing = rover.roverPosition.getFacing();

        int plateauX = plateauSize.getSizeX();
        int plateauY = plateauSize.getSizeY();

        int x = rover.getRoverPosition().getX();
        int y = rover.getRoverPosition().getY();

        if(facing == CompassDirection.N) {
            if(rover.getRoverPosition().getY() == plateauY)
                rover.getRoverPosition().setY(0);
            else
                rover.getRoverPosition().setY(y+1);
        }
        if(facing == CompassDirection.E) {
            if(rover.getRoverPosition().getX() == plateauX)
                rover.getRoverPosition().setX(0);
            else
                rover.getRoverPosition().setX(x+1);
        }
        if(facing == CompassDirection.S) {
            if(rover.getRoverPosition().getY() != 0)
                rover.getRoverPosition().setY(y-1);
            else
                rover.getRoverPosition().setY(plateauY);
        }
        if(facing == CompassDirection.W) {
            if(rover.getRoverPosition().getX() != 0)
                rover.getRoverPosition().setX(x-1);
            else
                rover.getRoverPosition().setX(plateauX);
        }
    }
}
