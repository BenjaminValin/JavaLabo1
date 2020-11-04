package be.technifutur.java2020.gestionstage.activites;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.stages.ListeStage;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ActiviteCtrl {

    ListeActivite liste = new ListeActivite();
    FonctionsUtiles util = new FonctionsUtiles();

    public void addActivity() {

        boolean datesOK = false;
        LocalDateTime dateDebut = null;
        int duree = 0;

        System.out.println("Insérez le nom de l'activité :");
        String data = new Scanner(System.in).nextLine();
        System.out.println("Création de la date de début de l'activité :");
        dateDebut = util.saisieDate();
        System.out.println("Insérez la durée de l'activité (en minutes) :");
        duree = new Scanner(System.in).nextInt();
        liste.addActivity(data, dateDebut, duree);
    }

    public void consultActivity(int key) {
        liste.consultActivity(key);
    }

    public void removeActivity(int key) {
        liste.removeActivity(key);
    }

    public void getActivitiesList() {
        liste.getActivitiesList();
    }
}
