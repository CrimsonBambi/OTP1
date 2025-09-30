package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    private Dice dice;

    @BeforeEach
    void setUp() {
        dice = new Dice();
    }

    @Test
    void testRollDieRange() {
        for (int i = 0; i < 100; i++) {
            int result = dice.rollDie();
            assertTrue(result >= 1 && result <= 6, "Die roll out of range");
        }
    }

    @Test
    void testRollTwoDiceRange() {
        for (int i = 0; i < 100; i++) {
            int[] result = dice.rollTwoDice();
            assertEquals(2, result.length);
            assertTrue(result[0] >= 1 && result[0] <= 6);
            assertTrue(result[1] >= 1 && result[1] <= 6);
        }
    }

    @Test
    void testRollsUntilDoubleReturnsPositive() {
        int rolls = dice.rollsUntilDouble();
        assertTrue(rolls > 0, "Number of rolls should be positive");
    }

    @Test
    void testMainPrintsOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Dice.main(new String[]{});

        System.setOut(originalOut);

        String output = outContent.toString();

        assertTrue(output.contains("Rolling the dice..."), "Output should mention rolling the dice");
        assertTrue(output.contains("Die 1:"), "Output should show Die 1");
        assertTrue(output.contains("Die 2:"), "Output should show Die 2");
        assertTrue(output.contains("You rolled a double!") || output.contains("Try again."),
                "Output should mention double or try again");
        assertTrue(output.contains("It took"), "Output should mention number of rolls");
    }
}

