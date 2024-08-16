package org.example.input;

import org.example.input.Parser.InstructionParser;
import org.example.input.Parser.LandingPositionParser;
import org.example.input.Parser.PlateauParser;

import java.util.ArrayList;
import java.util.Scanner;

public class MissionControl {

    public static ArrayList<String> getUserInput() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> roverSetup = new ArrayList<>();
        String plateauSize = "";
        String name = "";
        String startPosition = "";
        String instructions = "";

        plateauSize = PlateauParser.getPlateauSize();
        roverSetup.add(plateauSize);

        name = LandingPositionParser.getRoverName();
        roverSetup.add(name);

        startPosition = LandingPositionParser.getStartPosition(plateauSize);
        roverSetup.add(LandingPositionParser.validateStartPosition(scanner, startPosition, plateauSize));

        instructions = InstructionParser.getRoverInstructions();
        roverSetup.add(instructions);

//        scanner.close();

        return roverSetup;
    }

    public static void moveTheRover(Rover rover, ArrayList<Instruction> instructions, PlateauSize plateauSize) {
        for(Instruction instruction : instructions) {
            if(instruction.name().equalsIgnoreCase(Instruction.L.name()) ||
                    instruction.name().equalsIgnoreCase(Instruction.R.name())) {
                CompassDirection newDirection = rover.rotate(instruction, rover.roverPosition.getFacing());
                rover.getRoverPosition().setFacing(newDirection);
            } else {
                rover.move(rover, plateauSize);
            }
        }
    }

    public static void addNewRoverOrMoveExisting() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        ArrayList<String> newRoverSetup = new ArrayList<>();

        System.out.println("\nWould what would you like to do next?");
        System.out.println("1 - Create a new rover");
        System.out.println("2 - Move existing rover");
        System.out.println("3 - Quit");

        choice = scanner.nextInt();

        while(choice != 1 && choice != 2) {
            System.out.println("That is not a valid selection");
            choice = scanner.nextInt();
        }

        if(choice == 1) {
            //call newRover setup name and position
        } else if(choice == 2) {
            //ask for existing rover name - maybe present list of all rovers.
            String roverToMove = "";
            ArrayList<Rover> rovers = PlateauSize.getInstance().getRovers();
            System.out.println("Which rover would you like to move?");
            for(Rover rover : rovers)
                System.out.println(rover.name);
            roverToMove = scanner.next();

            for(Rover rover : rovers)
                if(rover.name.equalsIgnoreCase(roverToMove)) {
                    //valid choice
                    System.out.println("Let's move " + roverToMove);
                    break;
                } else {
                    System.out.println(roverToMove + " does not exist. Try again");
                    roverToMove = scanner.next();
                }
        }

    }

}
