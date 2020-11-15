package com.service;

import com.entity.Automobilis;
import com.entity.AutomobiliaiForma;

import java.util.List;

public interface DegalaiService {

    AutomobiliaiForma skaiciuotiKaina(AutomobiliaiForma forma);

    void supiltiDegalus(AutomobiliaiForma forma);

    void paskirstytiDegalus(List<Automobilis> list, double degaluKiekis);
}
