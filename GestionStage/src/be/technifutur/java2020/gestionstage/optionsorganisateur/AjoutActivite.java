package be.technifutur.java2020.gestionstage.optionsorganisateur;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.stages.ListeStage;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AjoutActivite {

    private FonctionsUtiles util;
    private ConsulterStage consultstg;
    private ListeStage listes;

    public Activite add() {

        LocalDateTime dateDebut;
        int duree;
        boolean stop;
        Activite act = new Activite();

        System.out.println("Insérez le nom de l'activité (q/Q pour quitter et revenir au menu des stages) :");
        String data = new Scanner(System.in).nextLine().trim();
        stop = util.veutQuitter(data);
        if (!stop){
            while(util.vide(data)){
                System.out.println("Il faut absolument un nom pour l'activité, recommencez (q/Q pour quitter et revenir au menu des stages) :");
                data = new Scanner(System.in).nextLine().trim();
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

    public void addActivity(Activite act){

        Activite actAdd = act;
        boolean verif = false;

        if (actAdd != null){
            while (!verif){
                System.out.println("Voici la liste des stages :");
                consultstg.getList();
                System.out.println("Insérez le numéro du stage auquel vous voulez ajouter une activité");
                int input = new Scanner(System.in).nextInt();
                verif = listes.addLink(input, actAdd);
            }
        }
    }


    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

    public void setConsulterStage(ConsulterStage consulterStage) {
        this.consultstg = consulterStage;
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }
}
