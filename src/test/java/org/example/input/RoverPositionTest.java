package org.example.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverPositionTest {

    PlateauSize plateauSize = PlateauSize.getInstance(4,4);
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

    @Test
    @DisplayName("Implement test to remain South when passed M whilst facing South")
    void noRotationWhenPassedMTest() {
        RoverPosition roverPosition = new RoverPosition();
        roverPosition.setFacing(CompassDirection.S);
        CompassDirection newDirection = rover.rotate(Instruction.M, roverPosition.getFacing());

        assertEquals(CompassDirection.S, newDirection);
    }

    @Test
    @DisplayName("Implement test to move Rover when passed M whilst facing East within plateau scope")
    void moveWhenPassedMFacingEastWithinPlateauTest() {
        RoverPosition currentPosition = new RoverPosition();
        currentPosition.setFacing(CompassDirection.E);
        currentPosition.setX(0);
        currentPosition.setY(0);
        rover.setRoverPosition(currentPosition);

        rover.move(rover, plateauSize);

        assertEquals(1, rover.getRoverPosition().getX());
        assertEquals(0, rover.getRoverPosition().getY());
        assertEquals(CompassDirection.E, rover.getRoverPosition().getFacing());
    }

    @Test
    @DisplayName("Implement test to move Rover when passed M whilst facing North within plateau scope")
    void moveWhenPassedMFacingNorthWithinPlateauTest() {
        RoverPosition currentPosition = new RoverPosition();
        currentPosition.setFacing(CompassDirection.N);
        currentPosition.setX(0);
        currentPosition.setY(0);
        rover.setRoverPosition(currentPosition);

        rover.move(rover, plateauSize);

        assertEquals(0, rover.getRoverPosition().getX());
        assertEquals(1, rover.getRoverPosition().getY());
        assertEquals(CompassDirection.N, rover.getRoverPosition().getFacing());
    }

    @Test
    @DisplayName("Implement test to move Rover when passed M whilst facing South within plateau scope")
    void moveWhenPassedMFacingSouthWithinPlateauTest() {
        RoverPosition currentPosition = new RoverPosition();
        currentPosition.setFacing(CompassDirection.S);
        currentPosition.setX(6);
        currentPosition.setY(5);
        rover.setRoverPosition(currentPosition);

        rover.move(rover, plateauSize);

        assertEquals(6, rover.getRoverPosition().getX());
        assertEquals(4, rover.getRoverPosition().getY());
        assertEquals(CompassDirection.S, rover.getRoverPosition().getFacing());
    }

    @Test
    @DisplayName("Implement test to move Rover when passed M whilst facing West within plateau scope")
    void moveWhenPassedMFacingWestWithinPlateauTest() {
        RoverPosition currentPosition = new RoverPosition();
        currentPosition.setFacing(CompassDirection.W);
        currentPosition.setX(6);
        currentPosition.setY(5);
        rover.setRoverPosition(currentPosition);

        rover.move(rover, plateauSize);

        assertEquals(5, rover.getRoverPosition().getX());
        assertEquals(5, rover.getRoverPosition().getY());
        assertEquals(CompassDirection.W, rover.getRoverPosition().getFacing());
    }

    @Test
    @DisplayName("Implement test to move Rover when passed M whilst facing West outside plateau scope")
    void moveWhenPassedMFacingWOutsidePlateauTest() {
        RoverPosition currentPosition = new RoverPosition();
        currentPosition.setFacing(CompassDirection.W);
        currentPosition.setX(0);
        currentPosition.setY(0);
        rover.setRoverPosition(currentPosition);

        rover.move(rover, plateauSize);
        //Loop like the moon!
        assertEquals(4, rover.getRoverPosition().getX());
        assertEquals(0, rover.getRoverPosition().getY());
        assertEquals(CompassDirection.W, rover.getRoverPosition().getFacing());
    }

    @Test
    @DisplayName("Implement test to move Rover when passed M whilst facing East outside plateau scope")
    void moveWhenPassedMFacingEOutsidePlateauTest() {
        RoverPosition currentPosition = new RoverPosition();
        currentPosition.setFacing(CompassDirection.E);
        currentPosition.setX(4);
        currentPosition.setY(2);
        rover.setRoverPosition(currentPosition);

        rover.move(rover, plateauSize);
        //Loop like the moon!
        assertEquals(0, rover.getRoverPosition().getX());
        assertEquals(2, rover.getRoverPosition().getY());
        assertEquals(CompassDirection.E, rover.getRoverPosition().getFacing());
    }

    @Test
    @DisplayName("Implement test to move Rover when passed M whilst facing North outside plateau scope")
    void moveWhenPassedMFacingNOutsidePlateauTest() {
        RoverPosition currentPosition = new RoverPosition();
        currentPosition.setFacing(CompassDirection.N);
        currentPosition.setX(2);
        currentPosition.setY(4);
        rover.setRoverPosition(currentPosition);

        rover.move(rover, plateauSize);
        //Loop like the moon!
        assertEquals(2, rover.getRoverPosition().getX());
        assertEquals(0, rover.getRoverPosition().getY());
        assertEquals(CompassDirection.N, rover.getRoverPosition().getFacing());
    }

    @Test
    @DisplayName("Implement test to move Rover when passed M whilst facing South outside plateau scope")
    void moveWhenPassedMFacingSOutsidePlateauTest() {
        RoverPosition currentPosition = new RoverPosition();
        currentPosition.setFacing(CompassDirection.S);
        currentPosition.setX(4);
        currentPosition.setY(0);
        rover.setRoverPosition(currentPosition);

        rover.move(rover, plateauSize);
        //Loop like the moon!
        assertEquals(4, rover.getRoverPosition().getX());
        assertEquals(4, rover.getRoverPosition().getY());
        assertEquals(CompassDirection.S, rover.getRoverPosition().getFacing());
    }

}