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

        plateauSize = PlateauParser.getPlateauSize();
        roverSetup.add(plateauSize);

        startPosition = LandingPositionParser.getStartPosition(plateauSize);
        roverSetup.add(LandingPositionParser.validateStartPosition(scanner, startPosition, plateauSize));

        instructions = InstructionParser.getRoverInstructions();
        roverSetup.add(instructions);

        scanner.close();

        return roverSetup;
    }
}
