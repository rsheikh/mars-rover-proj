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
        RoverPosition newPosition = new RoverPosition();
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
            //M = move forward
        }

        //Then set new facing direction dependent on instruction above
        //Set new (x,y) if moving.

        return compassDirection;
    }
}
