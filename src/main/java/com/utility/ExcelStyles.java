package com.utility;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelStyles {


    public static CellStyle firstRowStyle(XSSFWorkbook wb) {

        XSSFCellStyle style1 = wb.createCellStyle();
        XSSFFont font = wb.createFont();
        font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        style1.setAlignment(HorizontalAlignment.CENTER);
        style1.setBorderBottom(BorderStyle.THIN);
        style1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style1.setFont(font);
        return style1;
    }

    public static CellStyle dataStyle(XSSFWorkbook wb) {

        XSSFCellStyle style2 = wb.createCellStyle();
        style2.setAlignment(HorizontalAlignment.RIGHT);
        return style2;
    }

    public static CellStyle firstColumnStyle(XSSFWorkbook wb) {

        XSSFCellStyle style3 = wb.createCellStyle();
        XSSFFont font3 = wb.createFont();
        font3.setFontHeightInPoints((short) 12);
        font3.setBold(true);
        style3.setFont(font3);
        style3.setBorderRight(BorderStyle.THIN);
        style3.setRightBorderColor(IndexedColors.BLACK.getIndex());
        return style3;
    }
}
