package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.menusorganisateur.*;
import be.technifutur.java2020.gestionstage.menusroles.*;
import be.technifutur.java2020.gestionstage.stages.*;
import be.technifutur.java2020.gestionstage.activites.*;

public class Factory {

    private Organisateur orga;
    private MenuStage menus;
    private StageCtrl ctrls;
    private MenuActivite menua;
    private ListeStage listes;
    private FonctionsUtiles util;
    private ActiviteCtrl ctrla;
    private ListeActivite listea;


    public MenuPrincipal getMenu(){
        MenuPrincipal menu = new MenuPrincipal();
        menu.setOrga(getOrga());
        return menu;
    }

    private Organisateur getOrga() {
        if (this.orga == null){
            this.orga = new Organisateur();
            this.orga.setMenuStage(getMenuStage());
            this.orga.setMenuActivite(getMenuActivite());
        }
        return orga;
    }

    private MenuStage getMenuStage() {
        if (this.menus == null){
            this.menus = new MenuStage();
            this.menus.setStageCtrl(getStageCtrl());
        }
        return menus;
    }

    private StageCtrl getStageCtrl() {
        if (this.ctrls == null){
            this.ctrls = new StageCtrl();
            this.ctrls.setListeStage(getListeStage());
            this.ctrls.setFonctionsUtiles(getFonctionsUtiles());
        }
        return ctrls;
    }

    private ListeStage getListeStage() {
        if (this.listes == null){
            this.listes = new ListeStage();
        }
        return listes;
    }

    private FonctionsUtiles getFonctionsUtiles() {
        if (this.util == null){
            this.util = new FonctionsUtiles();
        }
        return util;
    }

    private MenuActivite getMenuActivite() {
        if (this.menua == null){
            this.menua = new MenuActivite();
            this.menua.setActiviteCtrl(getActiviteCtrl());
        }
        return menua;
    }

    private ActiviteCtrl getActiviteCtrl() {
        if (this.ctrla == null){
            this.ctrla = new ActiviteCtrl();
            this.ctrla.setListeActivites(getListeActivite());
            this.ctrla.setFonctionsUtiles(getFonctionsUtiles());
        }
        return ctrla;
    }

    private ListeActivite getListeActivite() {
        if (this.listea == null){
            this.listea = new ListeActivite();
        }
        return listea;
    }

}
