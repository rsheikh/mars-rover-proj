package org.example.input.Parser;

import org.example.input.Instruction;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InstructionParser {

    public static String getRoverInstructions() {
        Scanner scanner = new Scanner(System.in);
        String instructions = "";
        String regexMatch = Instruction.L.name() + Instruction.R.name() + Instruction.M.name();
        System.out.println(regexMatch);

//        try {
            System.out.println("Enter your instructions for the Rover: ");
            instructions = scanner.next();
            if(instructions.matches("^["+ regexMatch+"]+$")) {
                System.out.println("Yay good entry: " + instructions);
            } else {
                System.out.println("Instructions can only contain L, R or M only. Try again");
                instructions = scanner.next();
            }

//        } catch (InputMismatchException e) {
//            System.out.println("Invalid Input. Instructions can only contain L, R or M only. Try again.");
//            scanner.nextLine();
//        }
        System.out.println("Instructions are: " + instructions);
        parseInstructions(instructions);
        return "";
    }

    public static void parseInstructions(String instructions) {


    }

}
