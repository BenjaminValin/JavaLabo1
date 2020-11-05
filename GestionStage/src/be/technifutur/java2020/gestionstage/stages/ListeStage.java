package be.technifutur.java2020.gestionstage.stages;

import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.activites.ListeActivite;

import java.time.LocalDateTime;
import java.util.*;

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
        int i = 1;
        for(Map.Entry map : listeStages.entrySet()){
            System.out.println("Stage " + i + " : " + map.getValue());
            i++;
        }
    }

    public void addLink(int input1, int input2) {

        Activite verif = ListeActivite.listeActivites.get(input2);
        Stage modif = listeStages.get(input1);
        Set<Activite> test = modif.getActivitesDuStage();
        boolean add = true;
        String message = null;

        if (verif.getDateDebut().compareTo(modif.getDateDebut()) < 0 || verif.getDateDebut().compareTo(modif.getDateFin()) > 0){
            add = false;
            message = "La date de l'activité ne correspond pas aux dates du stage";
        }

        //TODO : Corriger le foreach et le transformer en while
        for(Activite a : test){
            if (a == verif){
                add = false;
                message = "Cette activité ne peut pas être ajoutée dans le stage, car elle s'y trouve déjà";
            }
        }

        if (!add){
            System.out.println(message);
        } else {
            modif.getActivitesDuStage().add(verif);
        }

        //modif.setActivites(verif);
    }
}
