package be.technifutur.java2020.gestionstage.tarifs;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.donnees.Activite;

public class TarifDeBase implements Tarif {

    @Override
    public String getName() {
        return "Tarif de base";
    }

    @Override
    public double tarif(Activite a) {
        double coutHoraire = 50;
        double coutActivite;
        double heuresActivite = (float)a.getDureeActivite()/60;
        coutActivite = heuresActivite*coutHoraire;
        System.out.println(coutActivite);
        return coutActivite;
    }

    /*public static void main(String[] args) {
        FonctionsUtiles util = new FonctionsUtiles();
        TarifDeBase t = new TarifDeBase();
        Activite a = new Activite();
        a.setDureeActivite(150);
        util.affichePrix(t.tarif(a));
    }*/

}
