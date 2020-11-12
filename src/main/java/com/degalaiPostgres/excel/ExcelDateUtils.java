package com.degalaiPostgres.excel;

import java.time.LocalDate;

public class ExcelDateUtils {
    public static boolean isVasarosLaikas() {
        if (LocalDate.now().isLeapYear()) {
            return LocalDate.now().getDayOfYear() > 121 || LocalDate.now().getDayOfYear() < 336;
        } else {
            return LocalDate.now().getDayOfYear() > 120 || LocalDate.now().getDayOfYear() < 335;
        }
    }
}
