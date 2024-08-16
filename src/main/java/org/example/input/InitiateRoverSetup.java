package org.example.input;

import org.example.input.Parser.InstructionParser;
import org.example.input.Parser.LandingPositionParser;
import org.example.input.Parser.PlateauParser;

import java.util.ArrayList;
import java.util.Scanner;

public class InitiateRoverSetup {

    public static ArrayList<String> getUserInput() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> roverSetup = new ArrayList<>(3);
        String plateauSize = "";
        String name = "";
        String startPosition = "";
        String instructions = "";

        plateauSize = PlateauParser.getPlateauSize();
        roverSetup.add(plateauSize);

        name = LandingPositionParser.getRoverName();
        roverSetup.add(name);

        startPosition = LandingPositionParser.getStartPosition(plateauSize);
        roverSetup.add(LandingPositionParser.validateStartPosition(scanner, startPosition, plateauSize));

        instructions = InstructionParser.getRoverInstructions();
        roverSetup.add(instructions);

        scanner.close();

        return roverSetup;
    }

    public static void moveTheRover(Rover rover, ArrayList<Instruction> instructions, PlateauSize plateauSize) {
        for(Instruction instruction : instructions) {
            if(instruction.name().equalsIgnoreCase(Instruction.L.name()) ||
                    instruction.name().equalsIgnoreCase(Instruction.R.name())) {
                CompassDirection newDirection = rover.rotate(instruction, rover.roverPosition.getFacing());
                rover.getRoverPosition().setFacing(newDirection);
            } else {
                rover.move(rover, plateauSize);
            }
        }
    }

}
