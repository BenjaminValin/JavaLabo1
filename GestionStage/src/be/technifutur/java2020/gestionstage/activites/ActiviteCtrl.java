package be.technifutur.java2020.gestionstage.activites;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ActiviteCtrl {

    private FonctionsUtiles util;

    public Activite add() {

        LocalDateTime dateDebut;
        int duree;
        Activite act = new Activite();

        System.out.println("Insérez le nom de l'activité :");
        String data = new Scanner(System.in).nextLine();
        System.out.println("Création de la date de début de l'activité :");
        dateDebut = util.saisieDate();
        System.out.println("Insérez la durée de l'activité (en minutes) :");
        duree = new Scanner(System.in).nextInt();
        while (duree<=0){
            System.out.println("L'activité doit au moins durer une minute... Recommencez");
            duree = new Scanner(System.in).nextInt();
        }
        act.add(data, dateDebut, duree);
        return act;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

}
