package be.technifutur.java2020.gestionstage.optionsstagiaires;

import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.stages.ListeStage;
import be.technifutur.java2020.gestionstage.stages.Stage;

import java.util.Scanner;
import java.util.Set;

public class ConsultPlanning {

    private ListeStage liste;

    public void consult(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Voici la liste des stages :");
        liste.getList();
        System.out.println("De quel stage voulez-vous consulter le planning ?");
        int input = scan.nextInt();
        Stage stage = liste.getStage(input);
        Set<Activite> act = stage.getActivitesDuStage();
        

    }

    public void setListeStage(ListeStage listeStage) {
        this.liste = listeStage;
    }
}
