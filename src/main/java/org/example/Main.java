package org.example;

import org.example.input.*;
import org.example.input.Parser.InstructionParser;
import org.example.input.Parser.LandingPositionParser;
import org.example.input.Parser.PlateauParser;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello - welcome to Red's Rover App!");

        ArrayList<String> instructions = InitiateRoverSetup.getUserInput();

        PlateauSize plateauSize = PlateauParser.parsePlateauInput(instructions.getFirst());
        Rover rover = LandingPositionParser.parseStartingPosition(instructions.get(1), instructions.get(2));
        ArrayList<Instruction> instructionList = InstructionParser.parseInstructions(instructions.getLast());

        System.out.println("Rover " + rover.getName() + " has successfully landed at " + rover.getRoverPositionToString());

        InitiateRoverSetup.moveTheRover(rover, instructionList, plateauSize);
        System.out.println("Rover " + rover.getName() + " is on the move and reached " + rover.getRoverPositionToString());
    }
}