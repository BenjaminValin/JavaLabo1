package be.technifutur.java2020.gestionstage.tarifs;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.donnees.Activite;

import java.io.Serializable;
import java.util.Set;

public class TarifEnfant implements Tarif, Serializable {

    @Override
    public String getName() {
        return "Tarif enfant";
    }

    @Override
    public double tarif(Set<Activite> a) {
        FonctionsUtiles util = new FonctionsUtiles();
        double tauxHoraireTarif = 50;
        double coutHoraireBase = 50;
        double coutHoraireSpecifique;
        double coutTotal = 0.0;
        double coutActiv;
        int act;

        TarifActivite[] values = TarifActivite.values();

        for (Activite ac : a) {
            act = 0;
            for (TarifActivite value : values) {
                if (ac.getNomActivite().equals(value.name())) {
                    act++;
                    coutHoraireSpecifique = value.getTauxHoraire();
                    coutActiv = (((double) ac.getDureeActivite() / 60) * (coutHoraireSpecifique*(tauxHoraireTarif/100)));
                    coutTotal = coutTotal + coutActiv;
                    System.out.println(ac.getNomActivite() + " (" + ac.getDureeActivite() + " minutes) : " + util.affichePrix(coutActiv));
                }
            }
            if(act == 0){
                coutActiv = (((double)ac.getDureeActivite()/60) * (coutHoraireBase*(tauxHoraireTarif/100)));
                coutTotal = coutTotal + coutActiv;
                System.out.println(ac.getNomActivite() + " (" + ac.getDureeActivite() + " minutes) : " + util.affichePrix(coutActiv));
            }
        }

        return coutTotal;
    }

    /*@Override
    public double tarif(Set<Activite> a) {
        double coutHoraireBase = 25;
        double tauxHoraireTarif = 50;
        double coutHoraireSpecifique;
        double coutActivite;
        double heuresActivite = 0.0;

        for (Activite ac : a) {
            heuresActivite = heuresActivite + ac.getDureeActivite();
        }
        heuresActivite = heuresActivite/60;
        coutActivite = heuresActivite*coutHoraireBase;
        return coutActivite;
    }*/
}
