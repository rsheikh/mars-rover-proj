package org.example.input.Parser;

import org.example.input.Instruction;

import java.util.ArrayList;
import java.util.Scanner;

public class InstructionParser {

    public static void getRoverInstructions() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> roverInstructions = new ArrayList<>(3);
        String plateauSize = "";
        String startPosition = "";
        String instructions = "";
        String regexMatch = Instruction.L.name() + Instruction.R.name() + Instruction.M.name();

        System.out.println("Enter size of the Plateau (x,y):");
        plateauSize = scanner.next();
        roverInstructions.add(plateauSize);

        System.out.println("Enter your landing position and facing direction (x, y, direction):");
        startPosition = scanner.next();
        roverInstructions.add(startPosition);

        System.out.println("Enter your instructions for the Rover: ");
        instructions = scanner.next();
        if(instructions.matches("^["+ regexMatch+"]+$")) {
            System.out.println("Yay good entry: " + instructions);
        } else {
            System.out.println("Instructions can only contain L, R or M only. Try again");
            instructions = scanner.next();
        }
        roverInstructions.add(instructions);

        System.out.println("Rover Instructions are: " + roverInstructions);
        parseInstructions(roverInstructions);
    }

    public static void parseInstructions(ArrayList<String> instructions) {
        System.out.println("In parse method");

        //should return the final position - then elsewhere we do other things
    }

}
