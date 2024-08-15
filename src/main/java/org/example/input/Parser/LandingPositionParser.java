package org.example.input.Parser;

import org.example.input.CompassDirection;
import java.util.Scanner;

public class LandingPositionParser {

    public static String getStartPosition(String plateauSize) {
        Scanner scanner = new Scanner(System.in);
        String startPosition = "";
        System.out.println("Enter your landing position and facing direction (x, y, direction):");
        startPosition = scanner.next();
        String[] startPosArray = startPosition.split(",");

        while(startPosition.split(",").length != 3) {
            System.out.println("You must provide 3 arguments in the format: (x,y,direction). Try again:");
            startPosition = scanner.next();
        }
        startPosition = validateStartPosition(scanner, startPosition, plateauSize);

        return startPosition;
    }

    public static String validateStartPosition(Scanner scanner, String startPosition, String plateauSize) {
        String regexMatch = CompassDirection.N.name() + CompassDirection.E.name() + CompassDirection.S.name() + CompassDirection.W.name();
        boolean withinPlateauScope = false;

        String[] plateauSizeArray = plateauSize.split(",");
        String[] landingPosArray = startPosition.split(",");

        if(landingPosArray[2].matches("^["+ regexMatch+"]+$")) {
            if(landingPosArray[0].matches("[0-9]") && (landingPosArray[1].matches("[0-9]"))) {

                withinPlateauScope = checkPositionFitsInPlateau(landingPosArray, plateauSizeArray, withinPlateauScope);
                if(!withinPlateauScope) {
                        System.out.println("Please enter a valid starting point:");
                        startPosition = scanner.next();
                    }
                }
        } else {
            System.out.println("Invalid starting position. Please re-enter in the format (x,y,direction(N,E,S or W))");
            startPosition = scanner.next();
        }
        return startPosition;
    }

    public static boolean checkPositionFitsInPlateau(String[] landingPosArray, String[] plateauSizeArray, boolean withinPlateauScope) {
        int landingX = Integer.parseInt(landingPosArray[0]);
        int landingY = Integer.parseInt(landingPosArray[1]);
        int plateauX = Integer.parseInt(plateauSizeArray[0]);
        int plateauY = Integer.parseInt(plateauSizeArray[1]);

        if(landingX > plateauX || landingY > plateauY) {
            System.out.println("Landing position of Rover will be off the plateau.");
            return false;
        }
        return true;
    }
}
