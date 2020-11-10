package be.technifutur.java2020.gestionstage.activites;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ActiviteCtrl {

    private FonctionsUtiles util;

    public Activite add() {

        LocalDateTime dateDebut;
        int duree;
        boolean stop;
        Activite act = new Activite();

        System.out.println("Insérez le nom de l'activité (q/Q pour quitter et revenir au menu des stages) :");
        String data = new Scanner(System.in).nextLine();
        stop = util.veutQuitter(data);
        if (!stop){
            while(util.vide(data)){
                System.out.println("Il faut absolument un nom pour l'activité, recommencez (q/Q pour quitter et revenir au menu des stages) :");
                data = new Scanner(System.in).nextLine();
                stop = util.veutQuitter(data);
            }
            if (!stop){
                System.out.println("Création de la date de début de l'activité :");
                dateDebut = util.saisieDate();
                System.out.println("Insérez la durée de l'activité (en minutes) :");
                duree = new Scanner(System.in).nextInt();
                while (duree<=0){
                    System.out.println("L'activité doit au moins durer une minute... Recommencez");
                    duree = new Scanner(System.in).nextInt();
                }
                act.add(data, dateDebut, duree);
            } else {
                act = null;
            }
        } else {
            act = null;
        }
        return act;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

}
