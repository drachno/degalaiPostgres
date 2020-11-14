package com.utility;

import java.util.Random;

public class DegalaiUtils {
    public static double getRandomNumber(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

}
