package com.utility;

import java.time.LocalDate;

public class DateUtils {
    public static boolean isVasarosLaikas() {
        int today = LocalDate.now().getDayOfYear();
        if (LocalDate.now().isLeapYear()) {
            return today > 121 && today < 336;
        } else {
            return today > 120 && today < 335;
        }
    }
}
