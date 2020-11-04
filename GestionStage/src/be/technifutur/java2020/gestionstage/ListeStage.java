package be.technifutur.java2020.gestionstage;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListeStage {

    static Map<Integer, Stage> listeStages = new HashMap<>();
    Stage stage = new Stage();
    FonctionsUtiles util = new FonctionsUtiles();


    public void addStage() {
        String data;
        boolean datesOK = false;
        LocalDateTime dateDebut;
        LocalDateTime dateFin;

        System.out.println("Insérez le nom du stage :");
        data = new Scanner(System.in).nextLine();
        stage.setNomStage(data);

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
            stage.setDateDebut(dateDebut);
            stage.setDateFin(dateFin);
            Stage.stagesCrees++;
            listeStages.put(Stage.stagesCrees,stage);
        }
    }

    public void consultStage(int key){
        Stage consult;
        consult = listeStages.get(key);
        System.out.println(consult.toString());
    }

}
