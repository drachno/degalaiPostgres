package com.degalaiPostgres.degalai;

import com.degalaiPostgres.entity.Automobiliai;
import com.degalaiPostgres.entity.AutomobiliaiForma;

import java.util.List;

public interface DegalaiService {

    AutomobiliaiForma skaiciuotiKaina(AutomobiliaiForma forma);

    void supiltiDegalus(AutomobiliaiForma forma);

    void degaluPaskirstymas(List<Automobiliai> list, double degaluKiekis);
}
