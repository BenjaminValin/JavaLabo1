package be.technifutur.java2020.gestionstage.optionsstagiaires;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.stages.*;

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
        Set<Activite> act = stage.getActivitesDuStage();

        planndesordre = new Activite[act.size()];   //TODO : trouver une méthode plus simple pour trier le set
        plannordre = new Activite[act.size()];

        System.out.println("Planning du stage " + stage.getNomStage());
        System.out.println("Le stage commence le " + util.afficheDate(dateDebutStage) + ".");
        System.out.println("Le stage finit le " + util.afficheDate(dateFinStage) + ".");
        System.out.println("Durée du stage : " + (dureeStage+1) + " jours");
        System.out.println("Voici le planning détaillé de ce stage : ");
        System.out.println();

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

        for (i=0; i <= dureeStage;i++){
            LocalDateTime date = dateDebutStage.plusDays(i);
            LocalDate jour = date.toLocalDate();
            boolean verif = false;
            for (int j = 0; j < act.size(); j++){
                LocalDate jourActiv = plannordre[j].getDateDebut().toLocalDate();
                if (jourActiv.equals(jour)){
                    verif = true;
                }
            }
            if (verif){
                System.out.println(util.afficheDateFR(jour) + " :");
                for (int j = 0; j < act.size(); j++){
                    LocalDate jourActiv = plannordre[j].getDateDebut().toLocalDate();
                    if (jourActiv.equals(jour)){
                        LocalTime heureFin = plannordre[j].getDateDebut().toLocalTime().plusMinutes(plannordre[j].getDureeActivite());
                        System.out.println(plannordre[j].getDateDebut().toLocalTime() +
                                " - " + heureFin +
                                " : " + plannordre[j].getNomActivite() +
                                " (" + plannordre[j].getDureeActivite() + " minutes)" );
                    }
                }
                System.out.println();
            }
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
