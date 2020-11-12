package be.technifutur.java2020.gestionstage.optionsvisiteurs;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.stages.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class ConsultPlanning {

    private ListeStage liste;
    private FonctionsUtiles util;

    public void consult(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Voici la liste des stages :");
        liste.getList();
        System.out.println("De quel stage voulez-vous consulter le planning ? Insérez son numéro :");
        int input = scan.nextInt();
        Stage stage = liste.getStage(input);

        LocalDateTime dateDebutStage = stage.getDateDebut();
        LocalDateTime dateFinStage = stage.getDateFin();
        int dureeStage = dateFinStage.getDayOfYear() - dateDebutStage.getDayOfYear();
        ArrayList<Activite> liste = new ArrayList<>();
        Set<Activite> act = stage.getActivitesDuStage();

        Iterator<Activite> iterator = act.iterator();
        int x = 0;
        while(iterator.hasNext()){
            liste.add(x, iterator.next());
            x++;
        }

        System.out.println("Planning du stage " + stage.getNomStage());
        System.out.println("Le stage commence le " + util.afficheDate(dateDebutStage) + ".");
        System.out.println("Le stage finit le " + util.afficheDate(dateFinStage) + ".");
        System.out.println("Durée du stage : " + (dureeStage+1) + " jours");
        System.out.println("Voici le planning détaillé de ce stage : ");
        System.out.println();

        for (int i = 0; i <= dureeStage; i++){
            LocalDateTime date = dateDebutStage.plusDays(i);
            LocalDate jour = date.toLocalDate();
            boolean verif = false;
            for (int j = 0; j < liste.size(); j++){
                LocalDate jourActiv = liste.get(j).getDateDebut().toLocalDate();
                if (jourActiv.equals(jour)){
                    verif = true;
                }
            }
            if (verif){
                System.out.println(util.afficheDateFR(jour) + " :");
                for (int j = 0; j < liste.size(); j++){
                    Activite activ = liste.get(j);
                    LocalDate jourActiv = activ.getDateDebut().toLocalDate();
                    LocalTime heureActiv = activ.getDateDebut().toLocalTime();
                    if (jourActiv.equals(jour)){
                        LocalTime heureFin = heureActiv.plusMinutes(liste.get(j).getDureeActivite());
                        System.out.println(heureActiv +
                                " - " + heureFin +
                                " : " + activ.getNomActivite() +
                                " (" + activ.getDureeActivite() + " minutes)" );
                    }
                }
                System.out.println();
            }
        }
    }

    public void setListeStage(ListeStage listeStage) {
        this.liste = listeStage;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }
}
