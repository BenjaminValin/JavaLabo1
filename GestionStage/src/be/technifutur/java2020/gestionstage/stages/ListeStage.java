package be.technifutur.java2020.gestionstage.stages;

import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.activites.ListeActivite;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ListeStage {

    public static Map<Integer, Stage> listeStages = new HashMap<>();
    public Stage stage;

    public void add(String data, LocalDateTime dateDebut, LocalDateTime dateFin) {

        Stage stage = new Stage();
        this.stage = stage;
        stage.setNomStage(data);
        stage.setDateDebut(dateDebut);
        stage.setDateFin(dateFin);
        Stage.StagesCreated++;
        Stage.StageKey++;
        listeStages.put(Stage.StagesCreated,stage);

    }

    public void consult(int key){
        Stage consult;
        consult = listeStages.get(key);
        System.out.println(consult.toString());
    }

    public void remove(int key){
        listeStages.remove(key);
        Stage.StagesCreated--;
    }

    public void getList(){
        for(Map.Entry map : listeStages.entrySet()){
            System.out.println("Stage : " + map);
        }
    }

    public void addLink(int input1, int input2) {
        Stage stagemodif = listeStages.get(input1);
        Activite activite = ListeActivite.listeActivites.get(input2);
        System.out.println(stagemodif);
        System.out.println(activite);
        //TODO : Ajouter activité dans stage
        //Map<Integer,Activite> map = new HashMap<>();
        //stagemodif.setListeActivites(map);
    }

    /*public void getListWithoutActivities(){
        for(Map.Entry map : listeStages.entrySet()){
            if (map.getValue().getActivite() == null){
                System.out.println("Stage : " + map);
            }
        }
    }*/
}
