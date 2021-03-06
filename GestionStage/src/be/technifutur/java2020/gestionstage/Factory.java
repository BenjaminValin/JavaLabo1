package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.donnees.ListeStage;
import be.technifutur.java2020.gestionstage.menusroles.*;
import be.technifutur.java2020.gestionstage.optionsorganisateur.*;
import be.technifutur.java2020.gestionstage.optionsstagiaires.InscriptionActivite;
import be.technifutur.java2020.gestionstage.optionsstagiaires.RetraitActivite;
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
    private RetraitActivite retractiv;
    private CreerStage createstg;
    private ConsulterStage consultstg;
    private SupprimerStage deletestg;
    private AjoutActivite ajact;
    private SupprimerActivite suppract;
    private AjoutParticipant ajpart;
    private SupprimerParticipant supprpart;
    private Tresorier tresorier;
    private AffecterTarif afftarif;
    private VoirFactureParticipant voirfactpart;
    private VoirRecettesStage voirrecettes;

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
            this.orga.setCreerStage(getCreerStage());
            this.orga.setConsulterStage(getConsulterStage());
            this.orga.setSupprimerStage(getSupprimerStage());
            this.orga.setAjoutActivite(getAjoutActivite());
            this.orga.setAjoutParticipant(getAjoutParticipant());
            this.orga.setSupprimerActivite(getSupprimerActivite());
            this.orga.setSupprimerParticipant(getSupprimerParticipant());
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

    private SupprimerActivite getSupprimerActivite() {
        if (this.suppract == null){
            this.suppract = new SupprimerActivite();
            this.suppract.setFonctionsUtiles(getFonctionsUtiles());
            this.suppract.setListeStage(getListeStage());
        }
        return suppract;
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

    private SupprimerParticipant getSupprimerParticipant() {
        if (this.supprpart == null){
            this.supprpart = new SupprimerParticipant();
            this.supprpart.setFonctionsUtiles(getFonctionsUtiles());
            this.supprpart.setListeStage(getListeStage());
        }
        return supprpart;
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
            this.stagiaire.setRetraitActivite(getRetraitActivite());
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

    private RetraitActivite getRetraitActivite() {
        if (this.retractiv == null){
            this.retractiv = new RetraitActivite();
            this.retractiv.setListeStage(getListeStage());
            this.retractiv.setListeParticipants(getListeParticipants());
            this.retractiv.setFonctionsUtiles(getFonctionsUtiles());
        }
        return retractiv;
    }

    private Tresorier getTresorier() {
        if (this.tresorier == null) {
            this.tresorier = new Tresorier();
            this.tresorier.setFonctionsUtiles(getFonctionsUtiles());
            this.tresorier.setAffecterTarif(getAffecterTarif());
            this.tresorier.setVoirFactureParticipant(getVoirFactureParticipant());
            this.tresorier.setVoirRecettesStage(getVoirRecettesStage());
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

    private VoirFactureParticipant getVoirFactureParticipant() {
        if (this.voirfactpart == null) {
            this.voirfactpart = new VoirFactureParticipant();
            this.voirfactpart.setListeStage(getListeStage());
            this.voirfactpart.setFonctionsUtiles(getFonctionsUtiles());
        }
        return voirfactpart;
    }

    private VoirRecettesStage getVoirRecettesStage() {
        if (this.voirrecettes == null) {
            this.voirrecettes = new VoirRecettesStage();
            this.voirrecettes.setListeStage(getListeStage());
            this.voirrecettes.setFonctionsUtiles(getFonctionsUtiles());
        }
        return voirrecettes;
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
