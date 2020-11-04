package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.activites.ActiviteCtrl;
import be.technifutur.java2020.gestionstage.activites.ListeActivite;
import be.technifutur.java2020.gestionstage.stages.ListeStage;
import be.technifutur.java2020.gestionstage.stages.StageCtrl;

public class Factory {

    public MenuPrincipal getMenu(){

        MenuPrincipal menu = new MenuPrincipal();
        StageCtrl ctrls = new StageCtrl();
        ListeStage listes = new ListeStage();
        ActiviteCtrl ctrla = new ActiviteCtrl();
        ListeActivite listea = new ListeActivite();

        return menu;
    }


}
