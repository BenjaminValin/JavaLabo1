package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.menusorganisateur.*;
import be.technifutur.java2020.gestionstage.menusroles.*;
import be.technifutur.java2020.gestionstage.optionsvisiteurs.*;
import be.technifutur.java2020.gestionstage.participants.ListeParticipants;
import be.technifutur.java2020.gestionstage.stages.*;
import be.technifutur.java2020.gestionstage.activites.*;

public class Factory {

    private Organisateur orga;
    private MenuStage menus;
    private StageCtrl ctrls;
    private ListeStage listes;
    private FonctionsUtiles util;
    private ActiviteCtrl ctrla;
    private Visiteur visiteur;
    private ConsultPlanning consult;
    private ListeParticipants listep;

    public MenuPrincipal getMenu(){
        MenuPrincipal menu = new MenuPrincipal();
        menu.setOrga(getOrga());
        menu.setVisiteur(getVisiteur());
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
            this.ctrls.setListeParticipants(getListeParticipants());
            this.ctrls.setFonctionsUtiles(getFonctionsUtiles());
        }
        return ctrls;
    }

    private ListeParticipants getListeParticipants() {
        if (this.listep == null){
            this.listep = new ListeParticipants();
        }
        return listep;
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

    private Visiteur getVisiteur() {
        if (this.visiteur == null){
            this.visiteur = new Visiteur();
            this.visiteur.setConsultPlanning(getConsultPlanning());
        }
        return visiteur;
    }

    private ConsultPlanning getConsultPlanning() {
        if (this.consult == null){
            this.consult = new ConsultPlanning();
            this.consult.setListeStage(getListeStage());
            this.consult.setFonctionsUtiles(getFonctionsUtiles());
        }
        return consult;
    }

}
