package be.technifutur.java2020.gestionstage.optionsstagiaires;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.stages.ListeStage;
import be.technifutur.java2020.gestionstage.stages.Stage;

import java.util.Scanner;
import java.util.Set;

public class ConsultPlanning {

    private ListeStage liste;

    public void consult(){

        Scanner scan = new Scanner(System.in);
        Activite[] planndesordre, plannordre;
        int i = 0;

        load();                                     //TODO : trouver une solution pour unifier les listes après chargement de la sauvegarde, load utilisé provisoirement
        System.out.println("Voici la liste des stages :");
        liste.getList();
        System.out.println("De quel stage voulez-vous consulter le planning ?");
        int input = scan.nextInt();
        Stage stage = liste.getStage(input);
        Set<Activite> act = stage.getActivitesDuStage();

        planndesordre = new Activite[act.size()];
        plannordre = new Activite[act.size()];

        System.out.println(stage);

        for(Activite a : act){
            System.out.println(a);
            planndesordre[i] = a;
            i++;
        }
    }

    public void load(){
        FonctionsUtiles fct = new FonctionsUtiles();
        this.liste = fct.chargementListeStage();
    }

    public void setListeStage(ListeStage listeStage) {
        this.liste = listeStage;
    }


}
