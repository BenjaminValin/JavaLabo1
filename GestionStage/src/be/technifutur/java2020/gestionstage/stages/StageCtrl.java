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
        LocalDateTime dateDebut = null;
        LocalDateTime dateFin = null;

        System.out.println("Insérez le nom du stage :");
        String data = new Scanner(System.in).nextLine();

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
    }

    public void newMember() {
        Participant p = new Participant();
        Stage s;
        char r = ' ';
        System.out.println("Insérez le nom du participant :");
        p.setNom(new Scanner(System.in).nextLine());
        System.out.println("Insérez le prénom du participant :");
        p.setPrenom(new Scanner(System.in).nextLine());

        System.out.println("Voici la liste des stages :");
        getList();
        System.out.println("Insérez le numéro du stage auquel vous voulez ajouter ce participant");
        int input = new Scanner(System.in).nextInt();
        s = liste.getStage(input);
        boolean ok = listep.verifMember(s,p);
        listep.addMember(ok, s, p);
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

        while (!verif){
            System.out.println("Voici la liste des stages :");
            getList();
            System.out.println("Insérez le numéro du stage auquel vous voulez ajouter une activité");
            int input = new Scanner(System.in).nextInt();
            verif = liste.addLink(input, actAdd);
        }
    }

    /*public void deleteLink() {} pas encore demandé */

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
