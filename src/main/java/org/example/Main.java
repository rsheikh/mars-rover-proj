package org.example;

import org.example.input.InitiateRoverSetup;
import org.example.input.Instruction;
import org.example.input.Parser.InstructionParser;
import org.example.input.Parser.LandingPositionParser;
import org.example.input.Parser.PlateauParser;
import org.example.input.PlateauSize;
import org.example.input.Position;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello - welcome to the Rover App!");

        ArrayList<String> instructions = InitiateRoverSetup.getUserInput();
//        System.out.println("Validated Instructions: " + instructions);

        PlateauSize plateauSize = PlateauParser.parsePlateauInput(instructions.getFirst());
        Position landingPosition = LandingPositionParser.parseStartingPosition(instructions.get(1));
        ArrayList<Instruction> instructionList = InstructionParser.parseInstructions(instructions.getLast());

//        System.out.println("Parsed Plateau: " + plateauSize);
//        System.out.println("Parsed Landing Position: " + landingPosition);
//        System.out.println("Parsed Instruction List: " + instructionList.stream().toString());

    }
}