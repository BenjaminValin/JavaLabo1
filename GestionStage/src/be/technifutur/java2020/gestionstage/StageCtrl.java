package be.technifutur.java2020.gestionstage;

import java.time.LocalDateTime;
import java.util.Scanner;

public class StageCtrl {

    ListeStage liste = new ListeStage();
    FonctionsUtiles util = new FonctionsUtiles();

    public void addStage() {

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
        liste.addStage(data, dateDebut, dateFin);
    }

    public void consultStage(int key) {
        liste.consultStage(key);
    }

    public void removeStage(int key) {
        liste.removeStage(key);
    }

    public void getStageList() {
        liste.getStageList();
    }
}
