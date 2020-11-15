package com.service;

import com.entity.Automobilis;
import com.utility.ExcelStyles;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import static com.utility.DateUtils.isVasarosLaikas;

@Component
public class ExcelServiceImpl implements ExcelService {

    private final static int COLUMNS = 6;

    @Override
    public void write(List<Automobilis> automobiliai) throws IOException {

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("First sheet");

        createRows(sheet);

        fillFirstColumn(wb, sheet);

        fillData(wb, sheet, automobiliai);

        autosizeColumns(sheet);

        writeAndClose(wb);
    }

    @Override
    public void createRows(XSSFSheet sheet) {

        for (int i = 0; i < COLUMNS; i++) {
            sheet.createRow(i);
        }
    }

    @Override
    public void fillFirstColumn(XSSFWorkbook wb, XSSFSheet sheet) {

        XSSFCell cell1 = sheet.getRow(0).createCell(0);
        cell1.setCellValue("");
        XSSFCell cell2 = sheet.getRow(1).createCell(0);
        cell2.setCellValue("Kuras:");
        cell2.setCellStyle(ExcelStyles.firstColumnStyle(wb));
        XSSFCell cell3 = sheet.getRow(2).createCell(0);
        if (isVasarosLaikas()) {
            cell3.setCellValue("Norma(vasara):");
        } else {
            cell3.setCellValue("Norma(žiema):");
        }
        cell3.setCellStyle(ExcelStyles.firstColumnStyle(wb));
        XSSFCell cell4 = sheet.getRow(3).createCell(0);
        cell4.setCellStyle(ExcelStyles.firstColumnStyle(wb));
        XSSFCell cell5 = sheet.getRow(4).createCell(0);
        cell5.setCellValue("Kiekis(L):");
        cell5.setCellStyle(ExcelStyles.firstColumnStyle(wb));
        XSSFCell cell6 = sheet.getRow(5).createCell(0);
        cell6.setCellValue("Rida:");
        cell6.setCellStyle(ExcelStyles.firstColumnStyle(wb));
    }

    @Override
    public void fillData(XSSFWorkbook wb, XSSFSheet sheet, List<Automobilis> automobiliai) {
        int i = 1;
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        for (Automobilis automobilis : automobiliai) {
            XSSFCell langelis = sheet.getRow(0).createCell(i);
            langelis.setCellValue(automobilis.getName());
            langelis.setCellStyle(ExcelStyles.firstRowStyle(wb));
            XSSFCell langelis2 = sheet.getRow(1).createCell(i);

            langelis2.setCellValue(String.valueOf(automobilis.getDegalutipas()));
            langelis2.setCellStyle(ExcelStyles.dataStyle(wb));
            XSSFCell langelis3 = sheet.getRow(2).createCell(i);

            if (isVasarosLaikas()) {
                langelis3.setCellValue(automobilis.getSanaudosVasara());
            } else {
                langelis3.setCellValue(automobilis.getSanaudosZiema());
            }

            XSSFCell langelis5 = sheet.getRow(4).createCell(i);
            langelis5.setCellValue(df.format(automobilis.getSunaudojoDegalu()));
            langelis5.setCellStyle(ExcelStyles.dataStyle(wb));
            XSSFCell langelis6 = sheet.getRow(5).createCell(i);
            langelis6.setCellValue(df.format(automobilis.getSunaudojoDegalu() / (automobilis.getSanaudosVasara() / 100)));
            langelis6.setCellStyle(ExcelStyles.dataStyle(wb));

            i++;
        }
    }

    @Override
    public void writeAndClose(XSSFWorkbook wb) throws IOException {
        wb.write(new FileOutputStream("degalai.xlsx"));
        wb.close();
    }

    @Override
    public void autosizeColumns(XSSFSheet sheet) {
        int lastCell = sheet.getRow(0).getLastCellNum();
        for (int i = 0; i <= lastCell; i++)
            sheet.autoSizeColumn(i);
    }


}
