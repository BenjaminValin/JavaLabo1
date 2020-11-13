package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.donnees.ListeStage;
import be.technifutur.java2020.gestionstage.menusroles.*;
import be.technifutur.java2020.gestionstage.optionsorganisateur.*;
import be.technifutur.java2020.gestionstage.optionsstagiaires.InscriptionActivite;
import be.technifutur.java2020.gestionstage.optionstresorier.*;
import be.technifutur.java2020.gestionstage.optionsvisiteurs.*;
import be.technifutur.java2020.gestionstage.donnees.ListeParticipants;

import java.util.Scanner;

public class Factory {

    private FonctionsUtiles util;
    private Organisateur orga;
    private ListeStage listes;
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
    private Tresorier tresorier;
    private AffecterTarif afftarif;
    private CreerFactureParticipant creerfactpart;

    public MenuPrincipal getMenu(){
        MenuPrincipal menu = new MenuPrincipal();

        load();

        menu.setOrga(getOrga());
        menu.setVisiteur(getVisiteur());
        menu.setStagiaire(getStagiaire());
        menu.setTresorier(getTresorier());
        menu.setFonctionsUtiles(getFonctionsUtiles());
        return menu;
    }

    private Organisateur getOrga() {
        if (this.orga == null){
            this.orga = new Organisateur();
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

    private Tresorier getTresorier() {
        if (this.tresorier == null) {
            this.tresorier = new Tresorier();
            this.tresorier.setFonctionsUtiles(getFonctionsUtiles());
            this.tresorier.setAffecterTarif(getAffecterTarif());
            this.tresorier.setCreerFactureParticipant(getCreerFactureParticipant());
        }
        return tresorier;
    }

    private AffecterTarif getAffecterTarif() {
        if (this.afftarif == null) {
            this.afftarif = new AffecterTarif();
            this.afftarif.setListeStage(getListeStage());
            this.afftarif.setFonctionsUtiles(getFonctionsUtiles());
        }
        return afftarif;
    }

    private CreerFactureParticipant getCreerFactureParticipant() {
        if (this.creerfactpart == null) {
            this.creerfactpart = new CreerFactureParticipant();
            this.creerfactpart.setListeStage(getListeStage());
            this.creerfactpart.setFonctionsUtiles(getFonctionsUtiles());
        }
        return creerfactpart;
    }

    private void load(){
        System.out.println("Voulez-vous charger les données précédemment enregistrées? Tapez O pour oui, tout autre caractère pour non :");
        String data = new Scanner(System.in).nextLine();
        char r = Character.toUpperCase(data.charAt(0));
        if(r == 'O' && this.util == null){
            this.util = new FonctionsUtiles();
            this.listes = util.chargementListeStage();
            this.listep = util.chargementListeParticipants();
            System.out.println("Chargement de la sauvegarde réussi !");
        }
    }

}
