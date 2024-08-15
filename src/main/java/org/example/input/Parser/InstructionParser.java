package org.example.input.Parser;

import org.example.input.Instruction;

import java.util.ArrayList;
import java.util.Scanner;

public class InstructionParser {

    public static String getRoverInstructions() {
        Scanner scanner = new Scanner(System.in);
        String instructions = "";
        String regexMatch = Instruction.L.name() + Instruction.R.name() + Instruction.M.name();

        //get instructions
        System.out.println("Enter your instructions for the Rover: ");
        instructions = scanner.next();
        if(instructions.matches("^["+ regexMatch+"]+$")) {
            System.out.println("Yay good entry: " + instructions);
        } else {
            System.out.println("Instructions can only contain L, R or M only. Try again");
            instructions = scanner.next();
        }
        return instructions;
    }

    public static void parseInstructions(ArrayList<String> instructions) {
        System.out.println("In parseInstructions method to set classes with values");

        //should return the final position - then elsewhere we do other things
    }

}
