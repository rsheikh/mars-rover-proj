package org.example.input.Parser;

import org.example.input.Instruction;

import java.util.ArrayList;
import java.util.Scanner;

public class InstructionParser {

    public static String getRoverInstructions() {
        Scanner scanner = new Scanner(System.in);
        String instructions = "";
        String regexMatch = Instruction.L.name() + Instruction.R.name() + Instruction.M.name();

        System.out.println("Enter your instructions for the Rover: ");
        instructions = scanner.next();
        if(instructions.matches("^["+ regexMatch+"]+$")) {
            //Correct input
        } else {
            System.out.println("Instructions can only contain L, R or M only. Try again");
            instructions = scanner.next();
        }
        return instructions;
    }

    public static ArrayList<Instruction> parseInstructions(String instructions) {
        ArrayList<Instruction> instructionList = new ArrayList<>();
        String[] values = instructions.split("");

        for(String instruction : values) {
            if (instruction.equalsIgnoreCase(Instruction.L.toString()))
                instructionList.add(Instruction.L);
            else if (instruction.equalsIgnoreCase(Instruction.R.toString()))
                instructionList.add(Instruction.R);
            else if (instruction.equalsIgnoreCase(Instruction.M.toString()))
                instructionList.add(Instruction.M);
        }
        return instructionList;
    }
}
