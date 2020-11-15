package com.controller;


import com.entity.Automobilis;
import com.entity.AutomobiliaiForma;
import com.service.DegalaiServiceImpl;
import com.service.ExcelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

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
        List<Automobilis> automobiliai = degalaiService.getAllAutomobiliai();
        excelService.write(automobiliai);
        return "outputForm";
    }
}
