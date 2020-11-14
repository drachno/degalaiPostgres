package com.service;

import com.entity.Automobiliai;
import com.entity.AutomobiliaiForma;
import com.repository.AutomobiliuRepozitorija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.utility.DegalaiUtils.getRandomNumber;

@Service
public class DegalaiServiceImpl implements DegalaiService {

    @Autowired
    AutomobiliuRepozitorija automobiliuRepozitorija;

    @Override
    public AutomobiliaiForma skaiciuotiKaina(AutomobiliaiForma forma) {
        forma.setBenzinoKaina(forma.getBenzinasMoketa() / forma.getBenzinasKiekis());
        forma.setDyzelinoKaina(forma.getDyzelinasMoketa() / forma.getDyzelinasKiekis());
        forma.setDujuKaina(forma.getDujosMoketa() / forma.getDujosKiekis());
        return forma;
    }

    @Override
    public void supiltiDegalus(AutomobiliaiForma forma) {
        List<Automobiliai> auto = automobiliuRepozitorija.findAll();
        List<Automobiliai> dyzeliniai = auto.stream().filter(a -> a.getDegalutipas().equals(Automobiliai.Degalutipas.DYZELINAS)).collect(Collectors.toList());
        degaluPaskirstymas(dyzeliniai, forma.getDyzelinasKiekis());
        List<Automobiliai> benzininiai = auto.stream().filter(a -> a.getDegalutipas().equals(Automobiliai.Degalutipas.BENZINAS)).collect(Collectors.toList());
        degaluPaskirstymas(benzininiai, forma.getBenzinasKiekis());
        List<Automobiliai> dujiniai = auto.stream().filter(a -> a.getDegalutipas().equals(Automobiliai.Degalutipas.DUJOS)).collect(Collectors.toList());
        degaluPaskirstymas(dujiniai, forma.getDujosKiekis());
    }

    @Override
    public void degaluPaskirstymas(List<Automobiliai> list, double degaluKiekis) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                list.get(i).setSunaudojoDegalu(degaluKiekis);
            } else {
                list.get(i).setSunaudojoDegalu(getRandomNumber((degaluKiekis * 0.3), (degaluKiekis * 0.7)));
                degaluKiekis = degaluKiekis - list.get(i).getSunaudojoDegalu();
            }
        }
    }

    public List<Automobiliai> getAllAutomobiliai() {
        return automobiliuRepozitorija.findAll();
    }
}