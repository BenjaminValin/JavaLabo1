package be.technifutur.java2020.gestionstage.stages;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.participants.ListeParticipants;
import be.technifutur.java2020.gestionstage.participants.Participant;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;

public class StageCtrl {

    private ListeStage liste;
    private ListeParticipants listep;
    private FonctionsUtiles util;

    public void newStage() {

        boolean datesOK = false;
        boolean stop;
        LocalDateTime dateDebut = null;
        LocalDateTime dateFin = null;

        System.out.println("Insérez le nom du stage (q/Q pour quitter et revenir au menu des stages) :");
        String data = new Scanner(System.in).nextLine();
        stop = util.veutQuitter(data);
        if (!stop){
            while(util.vide(data)){
                System.out.println("Il faut absolument un nom pour le stage, recommencez :");
                data = new Scanner(System.in).nextLine();
            }

            while(!datesOK){
                System.out.println("Création de la date de début du stage :");
                dateDebut = util.saisieDate();
                System.out.println("Création de la date de fin du stage :");
                dateFin = util.saisieDate();
                if (dateDebut.isAfter(dateFin)) {
                    System.out.println("La date de fin arrive avant la date de début. Veuillez recommencer :");
                } else if (dateDebut.isEqual(dateFin)) {
                    System.out.println("Les deux dates sont exactement les mêmes. Veuillez recommencer :");
                } else {
                    System.out.println("Ajout validé !");
                    datesOK = true;
                }
            }
            liste.add(data, dateDebut, dateFin);
        } else {
            System.out.println("Retour au menu des stages");
        }

    }

    public void newMember() {
        Participant p = new Participant();
        Stage s;
        char r = ' ';
        boolean ok = true;
        boolean stop;
        String data;

        System.out.println("Le participant existe t'il déjà dans la liste des participants ?");
        System.out.println("Tapez O pour oui, N (ou autre caractère) pour non, q/Q pour quitter et revenir au menu des stages");
        data = new Scanner(System.in).nextLine();
        stop = util.veutQuitter(data);
        if (!stop){
            r = Character.toUpperCase(new Scanner(System.in).nextLine().charAt(0));
            if(r == 'O'){
                System.out.println("Voici la liste des participants :");
                System.out.println(listep.getListeParticipants());
                System.out.println("Insérez le nom du participant que vous voulez récupérer :");
                data = new Scanner(System.in).nextLine();
                while (util.vide(data)){
                    System.out.println("Le nom ne peut être vide. Recommencez :");
                    data = new Scanner(System.in).nextLine();
                }
                p.setNom(data);
                System.out.println("Insérez le prénom du participant que vous voulez récupérer :");
                data = new Scanner(System.in).nextLine();
                while (util.vide(data)){
                    System.out.println("Le prénom ne peut être vide. Recommencez :");
                    data = new Scanner(System.in).nextLine();
                }
                p.setPrenom(data);
                p = listep.getMember(p);
                if (p == null){
                    System.out.println("Le participant n'a pas été trouvé. Avez-vous fait une erreur dans le nom ou le prénom ?");
                    ok = false;
                }
            } else {
                System.out.println("Création d'un nouveau participant");
                System.out.println("Insérez le nom du participant :");
                data = new Scanner(System.in).nextLine();
                while (util.vide(data)){
                    System.out.println("Le nom ne peut être vide. Recommencez :");
                    data = new Scanner(System.in).nextLine();
                }
                p.setNom(data);
                System.out.println("Insérez le prénom du participant :");
                data = new Scanner(System.in).nextLine();
                while (util.vide(data)){
                    System.out.println("Le prénom ne peut être vide. Recommencez :");
                    data = new Scanner(System.in).nextLine();
                }
                p.setPrenom(data);
            }
            if (ok){
                System.out.println("Voici la liste des stages :");
                getList();
                System.out.println("Insérez le numéro du stage auquel vous voulez ajouter ce participant");
                int key = new Scanner(System.in).nextInt();
                s = liste.getStage(key);
                ok = listep.verifMember(s,p);
                listep.addMember(ok, s, p);
            }
        } else {
            System.out.println("Retour au menu des stages");
        }
    }

    public void consult(int key) {
        liste.consult(key);
    }

    public void remove(int key) {
        liste.remove(key);
    }

    public void getList() {
        liste.getList();
    }

    public int getStagesCreated() {
        return liste.getStagesCreated();
    }

    public Stage getStage(int i) {
        return liste.getStage(i);
    }

    public Set<Participant> getListeParticipants() {
        return listep.getListeParticipants();
    }

    public void addActivity(Activite act) {

        Activite actAdd = act;
        boolean verif = false;

        if (actAdd != null){
            while (!verif){
                System.out.println("Voici la liste des stages :");
                getList();
                System.out.println("Insérez le numéro du stage auquel vous voulez ajouter une activité");
                int input = new Scanner(System.in).nextInt();
                verif = liste.addLink(input, actAdd);
            }
        }
    }

    public void save(){
        util.sauvegardeListeStage(this.liste);
    }

    public void load(){
        this.liste = util.chargementListeStage();
    }

    public void setListeStage(ListeStage listeStage) {
        this.liste = listeStage;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

    public void setListeParticipants(ListeParticipants listeParticipants) {
        this.listep = listeParticipants;
    }
}
