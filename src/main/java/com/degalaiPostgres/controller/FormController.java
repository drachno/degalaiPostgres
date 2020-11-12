package com.degalaiPostgres.controller;


import com.degalaiPostgres.entity.AutomobiliaiForma;
import com.degalaiPostgres.degalai.DegalaiServiceImpl;
import com.degalaiPostgres.excel.ExcelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class FormController {

    @Autowired
    private DegalaiServiceImpl degalaiService;

    @Autowired
    private ExcelServiceImpl excelService;

    @GetMapping("/form")
    public String read(@ModelAttribute("forma") AutomobiliaiForma forma) {
        return "inputForm";
    }

    @PostMapping("/form")
    public String resultGenerator(@ModelAttribute("forma") AutomobiliaiForma forma) throws IOException {
        degalaiService.skaiciuotiKaina(forma);
        degalaiService.supiltiDegalus(forma);
        excelService.writeExcel();
        return "outputForm";
    }
}
