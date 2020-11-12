package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.menusroles.*;
import be.technifutur.java2020.gestionstage.optionsorganisateur.*;
import be.technifutur.java2020.gestionstage.optionsstagiaires.InscriptionActivite;
import be.technifutur.java2020.gestionstage.optionsvisiteurs.*;
import be.technifutur.java2020.gestionstage.participants.ListeParticipants;
import be.technifutur.java2020.gestionstage.stages.*;
import be.technifutur.java2020.gestionstage.activites.*;

public class Factory {

    private Organisateur orga;
    private Organisateur menus;
    private StageCtrl ctrls;
    private ListeStage listes;
    private FonctionsUtiles util;
    private ActiviteCtrl ctrla;
    private Visiteur visiteur;
    private ConsultPlanning consult;
    private ListeParticipants listep;
    private Stagiaire stagiaire;
    private InscriptionActivite inscractiv;
    private CreerStage createstg;
    private ConsulterStage consultstg;
    private SupprimerStage deletestg;
    private AjoutActivite ajact;
    private AjoutParticipant ajpart;

    public MenuPrincipal getMenu(){
        MenuPrincipal menu = new MenuPrincipal();
        menu.setOrga(getOrga());
        menu.setVisiteur(getVisiteur());
        menu.setStagiaire(getStagiaire());
        menu.setFonctionsUtiles(getFonctionsUtiles());
        return menu;
    }

    private Organisateur getOrga() {
        if (this.orga == null){
            this.orga = new Organisateur();
            this.orga.setStageCtrl(getStageCtrl());
            this.orga.setActiviteCtrl(getActiviteCtrl());
            this.orga.setFonctionsUtiles(getFonctionsUtiles());
            this.orga.setListeStage(getListeStage());
            this.orga.setCreerStage(getCreerStage());
            this.orga.setConsulterStage(getConsulterStage());
            this.orga.setSupprimerStage(getSupprimerStage());
            this.orga.setAjoutActivite(getAjoutActivite());
            this.orga.setAjoutParticipant(getAjoutParticipant());
        }
        return orga;
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
            //this.util.chargementListeStage();
        }
        return util;
    }

    private CreerStage getCreerStage() {
        if (this.createstg == null){
            this.createstg = new CreerStage();
            this.createstg.setFonctionsUtiles(getFonctionsUtiles());
            this.createstg.setListeStage(getListeStage());
        }
        return createstg;
    }

    private ConsulterStage getConsulterStage() {
        if (this.consultstg == null){
            this.consultstg = new ConsulterStage();
            this.consultstg.setListeStage(getListeStage());
        }
        return consultstg;
    }

    private SupprimerStage getSupprimerStage() {
        if (this.deletestg == null){
            this.deletestg = new SupprimerStage();
            this.deletestg.setListeStage(getListeStage());
            this.deletestg.setConsulterStage(getConsulterStage());
            this.deletestg.setFonctionsUtiles(getFonctionsUtiles());
        }
        return deletestg;
    }

    private AjoutActivite getAjoutActivite() {
        if (this.ajact == null){
            this.ajact = new AjoutActivite();
            this.ajact.setFonctionsUtiles(getFonctionsUtiles());
            this.ajact.setConsulterStage(getConsulterStage());
            this.ajact.setListeStage(getListeStage());
        }
        return ajact;
    }

    private AjoutParticipant getAjoutParticipant() {
        if (this.ajpart == null){
            this.ajpart = new AjoutParticipant();
            this.ajpart.setFonctionsUtiles(getFonctionsUtiles());
            this.ajpart.setConsulterStage(getConsulterStage());
            this.ajpart.setListeStage(getListeStage());
            this.ajpart.setListeParticipants(getListeParticipants());
        }
        return ajpart;
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
            this.visiteur.setFonctionsUtiles(getFonctionsUtiles());
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

    private Stagiaire getStagiaire() {
        if (this.stagiaire == null){
            this.stagiaire = new Stagiaire();
            this.stagiaire.setFonctionsUtiles(getFonctionsUtiles());
            this.stagiaire.setInscriptionActivite(getInscriptionActivite());
        }
        return stagiaire;
    }

    private InscriptionActivite getInscriptionActivite() {
        if (this.inscractiv == null){
            this.inscractiv = new InscriptionActivite();
            this.inscractiv.setListeStage(getListeStage());
            this.inscractiv.setListeParticipants(getListeParticipants());
            this.inscractiv.setFonctionsUtiles(getFonctionsUtiles());
        }
        return inscractiv;
    }

}
