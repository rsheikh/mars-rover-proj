package org.example.input.Parser;

import org.example.input.Instruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Test
    @DisplayName("Test getRoverInstructions with Valid Input")
    void getRoverInstructionsWithValidInputTest() {
        String simulatedInput = "LLRM";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        String returnedResult = InstructionParser.getRoverInstructions();

        assertEquals(simulatedInput, returnedResult);
    }

    @Test
    @DisplayName("Test getRoverInstructions with Invalid Input")
    void getRoverInstructionsWithInvalidInputTest() {
        String simulatedInput = "ABC";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);
        System.setOut(new PrintStream(out)); //console's output

        String errorMessage = "Enter your instructions for the Rover: \n" +
                "Instructions can only contain L, R or M only. Try again";

        assertThrows(NoSuchElementException.class, InstructionParser::getRoverInstructions);
        assertEquals(errorMessage.trim(), out.toString().trim());
    }

    @Test
    @DisplayName("Test parseInstructions to create an ArrayList of Instructions")
    void parseInstructionsTest() {
        String input = "LRMM";
        ArrayList<Instruction> expectedList = new ArrayList<>();
        expectedList.add(Instruction.L);
        expectedList.add(Instruction.R);
        expectedList.add(Instruction.M);
        expectedList.add(Instruction.M);

        ArrayList<Instruction> instructionsList = InstructionParser.parseInstructions(input);

        assertEquals(expectedList, instructionsList);
        assertEquals(4, instructionsList.size());
    }
}