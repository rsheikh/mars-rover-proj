package org.example;

import org.example.input.InitiateRoverSetup;
import org.example.input.Parser.InstructionParser;
import org.example.input.PlateauSize;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello - welcome to the Rover App!");

        ArrayList<String> instructions = InitiateRoverSetup.getUserInput();
        System.out.println("Validated Instructions: " + instructions);
    }
}