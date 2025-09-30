package org.example;

import java.util.Random;

public class Dice {

    private Random random;

    public Dice() {
        this.random = new Random();
    }

    public int rollDie() {
        return random.nextInt(6) + 1;
    }

    public int[] rollTwoDice() {
        int die1 = rollDie();
        int die2 = rollDie();
        return new int[]{die1, die2};
    }

    public int rollsUntilDouble() {
        int count = 0;
        while (true) {
            count++;
            int[] dice = rollTwoDice();
            int die1 = dice[0];
            int die2 = dice[1];
            System.out.println("Rolling the dice...");
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            if (die1 == die2) {
                System.out.println("You rolled a double!");
                break;
            } else {
                System.out.println("Try again.");
            }
        }
        System.out.println("It took " + count + " rolls to get a double.");
        return count;
    }

    public static void main(String[] args) {
        Dice diceGame = new Dice();
        diceGame.rollsUntilDouble();
    }
}

