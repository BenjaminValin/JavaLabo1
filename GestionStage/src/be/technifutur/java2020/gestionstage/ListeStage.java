package be.technifutur.java2020.gestionstage;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ListeStage {

    public static Map<Integer, Stage> listeStages = new HashMap<>();
    private Stage stage = new Stage();


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

    public void getStageList(){
        for(Map.Entry map : listeStages.entrySet()){
            System.out.println("Stage : " + map);
        }
    }
}
