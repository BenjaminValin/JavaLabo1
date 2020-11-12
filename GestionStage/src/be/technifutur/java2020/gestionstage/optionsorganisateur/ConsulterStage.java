package be.technifutur.java2020.gestionstage.optionsorganisateur;

import be.technifutur.java2020.gestionstage.donnees.ListeStage;

public class ConsulterStage {

    private ListeStage listes;

    public void getList() {
        System.out.println("Stages encodés :");
        listes.getList();
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }
}
