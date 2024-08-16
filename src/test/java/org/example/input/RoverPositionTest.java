package org.example.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverPositionTest {

    Rover rover = new Rover("Rover1", new RoverPosition());

    @Test
    @DisplayName("Implement test to face East when passed R whilst facing North")
    void rotateRightOnRTest() {
        RoverPosition roverPosition = new RoverPosition();
        roverPosition.setFacing(CompassDirection.N);

        CompassDirection newDirection = rover.rotate(Instruction.R, roverPosition.getFacing());

        assertEquals(CompassDirection.E, newDirection);
    }

    @Test
    @DisplayName("Implement test to face West when passed L whilst facing North")
    void rotateLeftOnLTest() {
        RoverPosition roverPosition = new RoverPosition();
        roverPosition.setFacing(CompassDirection.N);

        CompassDirection newDirection = rover.rotate(Instruction.L, roverPosition.getFacing());

        assertEquals(CompassDirection.W, newDirection);
    }
/*
    @Test
    @DisplayName("Implement test to remain South when passed M whilst facing South")
    void noRotationWhenPassedMTest() {
        RoverPosition roverPosition = new RoverPosition();
        roverPosition.setFacing(CompassDirection.S);
        RoverPosition newRoverDirection = roverPosition.rotate(Instruction.M, roverPosition.getFacing());

        assertEquals(CompassDirection.S.name(), newRoverDirection.getFacing());
    }

    @Test
    @DisplayName("Implement test to move Rover when passed M whilst facing East within plateau scope")
    void moveWhenPassedMFacingEastWithinPlateauTest() {
        RoverPosition roverPosition = new RoverPosition();
        roverPosition.setFacing(CompassDirection.E);
        roverPosition.setX(0);
        roverPosition.setY(0);
        RoverPosition newRoverPosition = roverPosition.rotate(Instruction.M, roverPosition.getFacing());

        assertEquals(1, newRoverPosition.getX());
        assertEquals(0, newRoverPosition.getY());
        assertEquals(CompassDirection.E, newRoverPosition.getFacing());
    }

    @Test
    @DisplayName("Implement test to move Rover when passed M whilst facing South within plateau scope")
    void moveWhenPassedMFacingSWithinPlateau() {
        RoverPosition roverPosition = new RoverPosition();
        roverPosition.setFacing(CompassDirection.S);
        roverPosition.setX(4);
        roverPosition.setY(2);
        RoverPosition newRoverPosition = roverPosition.rotate(Instruction.M, roverPosition.getFacing());

        assertEquals(4, newRoverPosition.getX());
        assertEquals(1, newRoverPosition.getY());
        assertEquals(CompassDirection.S, newRoverPosition.getFacing());
    }

    //Must also implement tests to check plateau size before determining final position
*/
}