package be.technifutur.java2020.gestionstage.tarifs;

import be.technifutur.java2020.gestionstage.donnees.Activite;

public class TarifSocial implements Tarif{

    @Override
    public double tarif(Activite a) {
        double coutHoraire = 35;
        double coutActivite;
        double heuresActivite = (float)a.getDureeActivite()/60;
        coutActivite = heuresActivite*coutHoraire;
        System.out.println(coutActivite);
        return coutActivite;
    }
}
