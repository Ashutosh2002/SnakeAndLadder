package org.example.utils;

public class DiceUtility {

    public static int roll(int numberOfDices){
        int min = numberOfDices;
        int max = 6 * numberOfDices;

        return (int)(Math.floor(Math.random() * (max - min + 1)) + min);
    }

}
