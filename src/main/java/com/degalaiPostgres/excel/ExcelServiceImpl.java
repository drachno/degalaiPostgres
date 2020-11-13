package com.degalaiPostgres.excel;

import com.degalaiPostgres.entity.Automobiliai;
import com.degalaiPostgres.repository.AutomobiliuRepozitorija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService{

    @Autowired
    AutomobiliuRepozitorija automobiliuRepozitorija;

    @Autowired
    ExcelWriter excelWriter;

    public void writeExcel() throws IOException {
        List<Automobiliai> automobiliai = automobiliuRepozitorija.findAll();

        excelWriter.write(automobiliai);
    }
}
