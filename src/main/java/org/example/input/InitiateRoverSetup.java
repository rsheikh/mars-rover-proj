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
        String startPosition = "";
        String instructions = "";
        String regexMatch = Instruction.L.name() + Instruction.R.name() + Instruction.M.name();

        //get plateau size
        plateauSize = PlateauParser.getPlateauSize();
        roverSetup.add(plateauSize);
        //get start position
        startPosition = LandingPositionParser.getStartPosition(plateauSize);
        roverSetup.add(LandingPositionParser.validateStartPosition(scanner, startPosition, plateauSize));
        //get instructions
        instructions = InstructionParser.getRoverInstructions();
        roverSetup.add(instructions);

        System.out.println("Rover Instructions are: " + roverSetup);
        InstructionParser.parseInstructions(roverSetup);

        return roverSetup;
    }
}
