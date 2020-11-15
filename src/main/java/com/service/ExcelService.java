package com.service;

import com.entity.Automobilis;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public interface ExcelService {

     void write(List<Automobilis> automobiliai) throws IOException;

     void createRows(XSSFSheet sheet);

     void fillFirstColumn(XSSFWorkbook wb, XSSFSheet sheet);

     void fillData(XSSFWorkbook wb, XSSFSheet sheet, List<Automobilis> automobiliai);

     void writeAndClose(XSSFWorkbook wb) throws IOException;

     void autosizeColumns(XSSFSheet sheet);

}

