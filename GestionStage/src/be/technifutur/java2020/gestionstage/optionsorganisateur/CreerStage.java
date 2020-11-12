package be.technifutur.java2020.gestionstage.optionsorganisateur;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.donnees.ListeStage;

import java.time.LocalDateTime;
import java.util.Scanner;

public class CreerStage {

    private FonctionsUtiles util;
    private ListeStage listes;

    public void newStage() {

        boolean datesOK = false;
        boolean stop;
        LocalDateTime dateDebut = null;
        LocalDateTime dateFin = null;
        Scanner scan = new Scanner(System.in);

        System.out.println("Insérez le nom du stage (q/Q pour quitter et revenir au menu des stages) :");
        String data = scan.nextLine().trim();
        stop = util.veutQuitter(data);
        if (!stop){
            while(util.vide(data)){
                System.out.println("Il faut absolument un nom pour le stage, recommencez :");
                data = scan.nextLine().trim();
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
            listes.add(data, dateDebut, dateFin);
            util.sauvegardeListeStage(listes);
        } else {
            System.out.println("Retour au menu des organisateurs");
        }

    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }
}
