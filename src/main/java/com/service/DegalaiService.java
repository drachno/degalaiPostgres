package com.service;

import com.entity.Automobiliai;
import com.entity.AutomobiliaiForma;

import java.util.List;

public interface DegalaiService {

    AutomobiliaiForma skaiciuotiKaina(AutomobiliaiForma forma);

    void supiltiDegalus(AutomobiliaiForma forma);

    void degaluPaskirstymas(List<Automobiliai> list, double degaluKiekis);
}
