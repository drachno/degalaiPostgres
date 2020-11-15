package com.utility;

import java.util.Random;

public class Randomizer {
    public static double getRandomNumber(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

}
