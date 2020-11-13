package be.technifutur.java2020.gestionstage.optionstresorier;

import be.technifutur.java2020.gestionstage.tarifs.Tarif;
import be.technifutur.java2020.gestionstage.tarifs.TarifDeBase;
import be.technifutur.java2020.gestionstage.tarifs.TarifEnfant;
import be.technifutur.java2020.gestionstage.tarifs.TarifSocial;

public class AffecterTarif {

    Tarif[] prix = new Tarif[]{
            new TarifDeBase(), new TarifEnfant(), new TarifSocial()
    };

    public void givePrice() {

    }

}
