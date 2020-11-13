package com.degalaiPostgres.degalai;

import java.util.Random;

public class DegalaiUtils {
    static double getRandomNumber(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

}
