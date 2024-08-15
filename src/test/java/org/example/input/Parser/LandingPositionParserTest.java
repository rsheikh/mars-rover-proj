package org.example.input.Parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LandingPositionParserTest {

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Test
    @DisplayName("Return valid starting position within scope of Plateau size")
    void getStartPositionTestWithinPlateauScope() {
        String input = "9,9";
        String simulatedLandingPosition = "2,3,N";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedLandingPosition.getBytes());
        System.setIn(inputStream);

        String returnedResult = LandingPositionParser.getStartPosition(input);

        assertEquals(simulatedLandingPosition, returnedResult);
    }

    @Test
    @DisplayName("Return valid starting position out of scope of Plateau size")
    void getStartPositionTestOutsidePlateauScope() {
        String input = "9,9";
        String simulatedLandingPosition = "10,3,N";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedLandingPosition.getBytes());
        System.setIn(inputStream); //simulating passed-in user input
        System.setOut(new PrintStream(out)); //console's sout print msg

        String errMessage = "Enter your landing position and facing direction (x, y, direction):\n" +
                "Landing position of Rover will be off the plateau.\n" +
                "Please enter a valid starting point:";

        assertThrows(NoSuchElementException.class, () -> LandingPositionParser.getStartPosition(input));
        assertEquals(errMessage.trim(), out.toString().trim());
    }

    @Test
    void checkPositionFitsInPlateau() {
    }

    @Test
    void parseStartingPosition() {
    }
}