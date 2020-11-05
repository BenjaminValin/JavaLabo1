package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.activites.*;
import be.technifutur.java2020.gestionstage.stages.*;

public class Factory {

    private MenuPrincipal menu;
    private StageCtrl ctrls;
    private ListeStage listes;
    private ActiviteCtrl ctrla;
    private ListeActivite listea;

    public MenuPrincipal getMenu(){
        if (this.menu == null){
            this.menu = new MenuPrincipal();
        }
        return menu;
    }

    public StageCtrl getCtrls() {
        if (this.ctrls == null){
            this.ctrls = new StageCtrl();
        }
        return ctrls;
    }

    public ListeStage getListes() {
        if (this.listes == null){
            this.listes = new ListeStage();
        }
        return listes;
    }

    public ActiviteCtrl getCtrla() {
        if (this.ctrla == null){
            this.ctrla = new ActiviteCtrl();
        }
        return ctrla;
    }

    public ListeActivite getListea() {
        if (this.listea == null){
            this.listea = new ListeActivite();
        }
        return listea;
    }

}
