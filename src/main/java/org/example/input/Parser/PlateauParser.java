package org.example.input.Parser;

import org.example.input.PlateauSize;

import java.util.Scanner;

public class PlateauParser {
    public static String getPlateauSize() {
        Scanner scanner = new Scanner(System.in);
        String plateauSize = "";
        System.out.println("Enter size of the Plateau (x,y):");
        plateauSize = scanner.next();

        while(plateauSize.split(",").length != 2) {
            System.out.println("You must provide 2 numbers in the format (x,y). Try again:");
            plateauSize = scanner.next();
        }
        //check if valid arguments, i,e can be parsed into numbers
        for(String input : plateauSize.split(",")) {
            try{
                Integer.parseInt(input);
            } catch(NumberFormatException nfe) {
                System.out.println("You must provide 2 numbers in the format (x,y). Try again:");
                plateauSize = scanner.next();
                break;
            }
        }
        //@TODO close scanner
        return plateauSize;
    }

    public static PlateauSize parsePlateauInput (String plateauSizeInput) {
        String[] plateauValues = plateauSizeInput.split(",");

        return PlateauSize.getInstance(Integer.parseInt(plateauValues[0]), Integer.parseInt(plateauValues[1]));
    }
}
