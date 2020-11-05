package be.technifutur.java2020.gestionstage.stages;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.activites.ListeActivite;

import java.time.LocalDateTime;
import java.util.Scanner;

public class StageCtrl {

    ListeStage liste = new ListeStage();
    FonctionsUtiles util = new FonctionsUtiles();

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
            if (dateDebut.compareTo(dateFin) > 0) {
                System.out.println("La date de fin arrive avant la date de début. Veuillez recommencer :");
            } else if (dateDebut.compareTo(dateFin) == 0) {
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

    public void addLink() {
        System.out.println("Voici la liste des stages :");
        getList();
        System.out.println("Insérez le numéro du stage auquel vous voulez ajouter une activité");
        int input1 = new Scanner(System.in).nextInt();
        System.out.println("Voici la liste des activités :");
        ListeActivite.getList();
        System.out.println("Insérez le numéro de l'activité que vous voulez joindre au stage " + input1);
        int input2 = new Scanner(System.in).nextInt();
        liste.addLink(input1, input2);
    }

    public void deleteLink() {
        System.out.println("Voici la liste des stages :");
        getList();
    }
}
