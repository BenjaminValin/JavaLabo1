package be.technifutur.java2020.gestionstage.optionsorganisateur;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.donnees.ListeStage;

public class SupprimerStage {

    private ListeStage listes;
    private ConsulterStage consultstg;
    private FonctionsUtiles util;

    public void remove() {
        System.out.println("Stages déjà encodés : " + listes.getStagesCreated() + "\n");
        consultstg.getList();
        System.out.println("Quel est le numéro du stage que vous voulez retirer ?");
        int number = util.saisieNombre();
        listes.remove(number);
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }

    public void setConsulterStage(ConsulterStage consulterStage) {
        this.consultstg = consulterStage;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }
}
