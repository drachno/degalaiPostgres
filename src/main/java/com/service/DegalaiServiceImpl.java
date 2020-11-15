package com.service;

import com.entity.Automobilis;
import com.entity.AutomobiliaiForma;
import com.repository.AutomobiliuRepozitorija;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.utility.Randomizer.getRandomNumber;

@Service
public class DegalaiServiceImpl implements DegalaiService {

    @Autowired
    private AutomobiliuRepozitorija automobiliuRepozitorija;

    @Override
    public AutomobiliaiForma skaiciuotiKaina(AutomobiliaiForma forma) {
        forma.setBenzinoKaina(forma.getBenzinasMoketa() / forma.getBenzinasKiekis());
        forma.setDyzelinoKaina(forma.getDyzelinasMoketa() / forma.getDyzelinasKiekis());
        forma.setDujuKaina(forma.getDujosMoketa() / forma.getDujosKiekis());
        return forma;
    }

    @Override
    public void supiltiDegalus(AutomobiliaiForma forma) {
        List<Automobilis> auto = automobiliuRepozitorija.findAll();
        List<Automobilis> dyzeliniai = auto.stream().filter(a -> a.getDegalutipas().equals(Automobilis.Degalutipas.DYZELINAS)).collect(Collectors.toList());
        paskirstytiDegalus(dyzeliniai, forma.getDyzelinasKiekis());
        List<Automobilis> benzininiai = auto.stream().filter(a -> a.getDegalutipas().equals(Automobilis.Degalutipas.BENZINAS)).collect(Collectors.toList());
        paskirstytiDegalus(benzininiai, forma.getBenzinasKiekis());
        List<Automobilis> dujiniai = auto.stream().filter(a -> a.getDegalutipas().equals(Automobilis.Degalutipas.DUJOS)).collect(Collectors.toList());
        paskirstytiDegalus(dujiniai, forma.getDujosKiekis());
    }

    @Override
    public void paskirstytiDegalus(List<Automobilis> list, double degaluKiekis) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                list.get(i).setSunaudojoDegalu(degaluKiekis);
            } else {
                list.get(i).setSunaudojoDegalu(getRandomNumber((degaluKiekis * 0.3), (degaluKiekis * 0.7)));
                degaluKiekis = degaluKiekis - list.get(i).getSunaudojoDegalu();
            }
        }
    }

    public List<Automobilis> getAllAutomobiliai() {
        return automobiliuRepozitorija.findAll();
    }
}