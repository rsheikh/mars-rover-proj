package org.example.input.Parser;

import org.example.input.PlateauSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauParserTest {

    @Test
    @DisplayName("Get a Plateau instance from valid input")
    void getPlateauSizeObjectTest() {
        String input = "8,9";
        String[] plateauValues = input.split(",");

        assertEquals(PlateauSize.getInstance(8,9),
                PlateauSize.getInstance(Integer.parseInt(plateauValues[0]),Integer.parseInt(plateauValues[1])));
    }


//    @Test
//    @DisplayName("Test valid input for Plateau")
//    void getPlateauSizeTest() {
//        String input = "8,9";
//
//        assertEquals("8,9", PlateauParser.getPlateauSize());
//    }
}