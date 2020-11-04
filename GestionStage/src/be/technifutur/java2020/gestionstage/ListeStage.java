package be.technifutur.java2020.gestionstage;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListeStage {

    static Map<Integer, Stage> listeStages = new HashMap<>();
    Stage stage = new Stage();
    FonctionsUtiles util = new FonctionsUtiles();


    public void addStage(String data, LocalDateTime dateDebut, LocalDateTime dateFin) {

        stage.setNomStage(data);
        stage.setDateDebut(dateDebut);
        stage.setDateFin(dateFin);
        Stage.stagesCrees++;
        listeStages.put(Stage.stagesCrees,stage);

    }

    public void consultStage(int key){
        Stage consult;
        consult = listeStages.get(key);
        System.out.println(consult.toString());
    }

    public void removeStage(int key){
        listeStages.remove(key);
    }

    public void getListeStages(){
        for(Map.Entry map : listeStages.entrySet()){
            System.out.println("Stage : " + map);
        }
    }
}
