package be.technifutur.java2020.gestionstage.stages;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.activites.Activite;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class StageCtrl {

    private ListeStage liste;
    private FonctionsUtiles util;

    public void add() {

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

    public void addLink(Activite act) {

        Activite actAdd = act;
        boolean verif = false;

        while (!verif){
            System.out.println("Voici la liste des stages :");
            getList();
            System.out.println("Insérez le numéro du stage auquel vous voulez ajouter une activité");
            int input1 = new Scanner(System.in).nextInt();
            verif = liste.addLink(input1, actAdd);
        }


    }

    /*public void deleteLink() {} pas encore demandé */

    public void save(){
        File fichier = new File("stagesencodes.stage");
        ListeStage liste = this.liste;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {

            oos.writeObject(liste);
            System.out.println(fichier.exists());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(){
        File fichier = new File("stagesencodes.stage");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {

            ListeStage liste = (ListeStage) ois.readObject();
            this.liste = liste;
            System.out.println(liste);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setListeStage(ListeStage listeStage) {
        this.liste = listeStage;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }


}
