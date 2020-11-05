package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.activites.*;
import be.technifutur.java2020.gestionstage.stages.*;

public class Factory {

    private StageCtrl ctrls;
    private ListeStage listes;
    private ActiviteCtrl ctrla;
    private ListeActivite listea;

    public MenuPrincipal getMenu(){

        MenuPrincipal menu = new MenuPrincipal();

        StageCtrl ctrls = new StageCtrl();
        ListeStage listes = new ListeStage();
        ActiviteCtrl ctrla = new ActiviteCtrl();
        ListeActivite listea = new ListeActivite();

        return menu;
    }

    public StageCtrl getStageCtrl() {
        if (this.ctrls == null){
            this.ctrls = new StageCtrl();
        }
        return ctrls;
    }

    public void setStageCtrl(StageCtrl ctrls){
        this.ctrls = ctrls;
    }


}
