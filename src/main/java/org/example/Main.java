package org.example;

import org.example.input.InitiateRoverSetup;
import org.example.input.Instruction;
import org.example.input.Parser.InstructionParser;
import org.example.input.Parser.LandingPositionParser;
import org.example.input.Parser.PlateauParser;
import org.example.input.PlateauSize;
import org.example.input.RoverPosition;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello - welcome to Red's Rover App!");

        ArrayList<String> instructions = InitiateRoverSetup.getUserInput();

        PlateauSize plateauSize = PlateauParser.parsePlateauInput(instructions.getFirst());
        RoverPosition landingPosition = LandingPositionParser.parseStartingPosition(instructions.get(1));
        ArrayList<Instruction> instructionList = InstructionParser.parseInstructions(instructions.getLast());

    }
}