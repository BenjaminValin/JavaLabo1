package be.technifutur.java2020.gestionstage.optionsstagiaires;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.stages.ListeStage;
import be.technifutur.java2020.gestionstage.stages.Stage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.Set;

public class ConsultPlanning {

    private ListeStage liste;
    private FonctionsUtiles util;

    public void consult(){

        Scanner scan = new Scanner(System.in);
        Activite[] planndesordre, plannordre;
        int i = 0;

        load();                                     //TODO : trouver une solution pour unifier les listes après chargement de la sauvegarde, load utilisé provisoirement
        System.out.println("Voici la liste des stages :");
        liste.getList();
        System.out.println("De quel stage voulez-vous consulter le planning ? Insérez son numéro :");
        int input = scan.nextInt();
        Stage stage = liste.getStage(input);

        LocalDateTime dateDebutStage = stage.getDateDebut();
        LocalDateTime dateFinStage = stage.getDateFin();
        int dureeStage = dateFinStage.getDayOfYear() - dateDebutStage.getDayOfYear();

        /*LocalDate dateDebutStage = stage.getDateDebut().toLocalDate();
        LocalDate dateFinStage = stage.getDateFin().toLocalDate();
        LocalTime heureDebutStage = stage.getDateDebut().toLocalTime();
        LocalTime heureFinStage = stage.getDateFin().toLocalTime();*/

        Set<Activite> act = stage.getActivitesDuStage();

        planndesordre = new Activite[act.size()];
        plannordre = new Activite[act.size()];

        System.out.println("Planning du stage " + stage.getNomStage());
        System.out.println("Le stage commence le " + util.afficheDate(dateDebutStage) + ".");
        System.out.println("Le stage finit le " + util.afficheDate(dateFinStage) + ".");
        System.out.println("Durée du stage : " + (dureeStage+1) + " jours");
        System.out.println("Voici la liste des activités de ce stage : ");

        for(Activite a : act){
            planndesordre[i] = a;
            i++;
        }

        for (int cpt = 0; cpt < act.size(); cpt++){
            i=0;
            Activite a = planndesordre[cpt];
            for (int cpt2 = 0; cpt2 < act.size(); cpt2++){
                if (a.getDateDebut().isAfter(planndesordre[cpt2].getDateDebut())){
                    i++;
                }
            }
            plannordre[i] = a;
        }

        for (i = 0;i < act.size(); i++){
            System.out.println(plannordre[i]);
        }

        for (i=0;i <= dureeStage;i++){
            LocalDate jour = dateDebutStage.toLocalDate().plusDays(i);
            System.out.println("Activités du " + util.afficheDate(jour) + " :");
        }


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
}
