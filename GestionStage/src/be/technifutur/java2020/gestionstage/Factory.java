package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.menusorganisateur.*;
import be.technifutur.java2020.gestionstage.menusroles.*;
import be.technifutur.java2020.gestionstage.optionsstagiaires.*;
import be.technifutur.java2020.gestionstage.stages.*;
import be.technifutur.java2020.gestionstage.activites.*;

public class Factory {

    private Organisateur orga;
    private MenuStage menus;
    private StageCtrl ctrls;
    private ListeStage listes;
    private FonctionsUtiles util;
    private ActiviteCtrl ctrla;
    private Stagiaire stagiaire;
    private ConsultPlanning consult;

    public MenuPrincipal getMenu(){
        MenuPrincipal menu = new MenuPrincipal();
        menu.setOrga(getOrga());
        menu.setStagiaire(getStagiaire());
        return menu;
    }

    private Organisateur getOrga() {
        if (this.orga == null){
            this.orga = new Organisateur();
            this.orga.setMenuStage(getMenuStage());
        }
        return orga;
    }

    private MenuStage getMenuStage() {
        if (this.menus == null){
            this.menus = new MenuStage();
            this.menus.setStageCtrl(getStageCtrl());
            this.menus.setActiviteCtrl(getActiviteCtrl());
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

    private ActiviteCtrl getActiviteCtrl() {
        if (this.ctrla == null){
            this.ctrla = new ActiviteCtrl();
            this.ctrla.setFonctionsUtiles(getFonctionsUtiles());
        }
        return ctrla;
    }

    private Stagiaire getStagiaire() {
        if (this.stagiaire == null){
            this.stagiaire = new Stagiaire();
            this.stagiaire.setConsultPlanning(getConsultPlanning());
        }
        return stagiaire;
    }

    private ConsultPlanning getConsultPlanning() {
        if (this.consult == null){
            this.consult = new ConsultPlanning();
            this.consult.setListeStage(getListeStage());
        }
        return consult;
    }

}
