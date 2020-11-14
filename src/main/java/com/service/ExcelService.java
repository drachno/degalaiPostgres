package com.service;

import com.entity.Automobiliai;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public interface ExcelService {

     void write(List<Automobiliai> automobiliai) throws IOException;

     void createSheet(XSSFSheet sheet);

     void fillFirstColumn(XSSFWorkbook wb, XSSFSheet sheet);

     void fillData(XSSFWorkbook wb, XSSFSheet sheet, List<Automobiliai> automobiliai);

     void writeAndClose(XSSFWorkbook wb) throws IOException;

     void autosizeColumns(XSSFSheet sheet);

}

