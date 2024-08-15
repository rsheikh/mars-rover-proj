package org.example.input.Parser;

import org.example.input.CompassDirection;

public class LandingPositionParser {

    public static String validateLandingPosition(String landingPosition, String plateauSize) {
        System.out.println(plateauSize);
        System.out.println(landingPosition);

        String regexMatch = CompassDirection.N.name() + CompassDirection.E.name() + CompassDirection.S.name() + CompassDirection.W.name();

        //check if landingPosition is valid entry type
        String[] plateauSizeArray = plateauSize.split(",");
        String[] landingPosArray = landingPosition.split(",");

        if(landingPosArray.length != 3) {
            //incorrect number of args passed
            //try again with correct arguments.
        }

        if(landingPosArray[2].matches("^["+ regexMatch+"]+$")) {
            //great - valid input. Do next check
            if(landingPosArray[0].matches("[0-9]") && (landingPosArray[1].matches("[0-9]"))) {
                //yay correct 1st two args
                //do plateau scope check.
                checkPositionFitsInPlateau(landingPosArray, plateauSizeArray);
            }
        } else {
            //invalid landing input. Try again
        }

        //check if landing position is within scope of plateau
//        if(landingPosArray[0] > plateauSizeArray[0])
        //return same start position
        //else ask for user input again.
        return "";
    }

    public static boolean checkPositionFitsInPlateau(String[] landingPosArray, String[] plateauSizeArray) {

        return true;
    }
}
