package org.example.input.Parser;

import org.example.input.CompassDirection;

import java.util.Scanner;

public class LandingPositionParser {

    public static String validateStartPosition(Scanner scanner, String startPosition, String plateauSize) {
        System.out.println(plateauSize);
        System.out.println(startPosition);
//        String landingPos = "";

        String regexMatch = CompassDirection.N.name() + CompassDirection.E.name() + CompassDirection.S.name() + CompassDirection.W.name();

        //check if landingPosition is valid entry type
        String[] plateauSizeArray = plateauSize.split(",");
        String[] landingPosArray = startPosition.split(",");

        if(landingPosArray[2].matches("^["+ regexMatch+"]+$")) {
            //great - valid input. Do next check
            if(landingPosArray[0].matches("[0-9]") && (landingPosArray[1].matches("[0-9]"))) {
                //yay correct 1st two args
                //do plateau scope check.
                checkPositionFitsInPlateau(landingPosArray, plateauSizeArray);
            }
        } else {
            System.out.println("Invalid starting position. Please re-enter in the format (x,y,direction(N,E,S or W))");
            startPosition = scanner.next();
            //invalid landing input. Try again
        }

        return startPosition;
    }

    public static boolean checkPositionFitsInPlateau(String[] landingPosArray, String[] plateauSizeArray) {
        //check if landing position is within scope of plateau
//        if(landingPosArray[0] > plateauSizeArray[0])
        //return same start position
        //else ask for user input again.
        return true;
    }
}
