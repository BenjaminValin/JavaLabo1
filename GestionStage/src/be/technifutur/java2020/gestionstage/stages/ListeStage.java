package be.technifutur.java2020.gestionstage.stages;

import be.technifutur.java2020.gestionstage.activites.Activite;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class ListeStage implements Serializable {

    private Map<Integer, Stage> listeStages = new HashMap<>();
    public int StagesCreated = 0;


    public void add(String data, LocalDateTime dateDebut, LocalDateTime dateFin) {

        Stage stage = new Stage();
        stage.setNomStage(data);
        stage.setDateDebut(dateDebut);
        stage.setDateFin(dateFin);
        this.StagesCreated++;
        listeStages.put(this.StagesCreated,stage);

    }

    public void consult(int key){
        Stage consult;
        consult = listeStages.get(key);
        System.out.println(consult.toString());
    }

    public void remove(int key){
        listeStages.remove(key);
    }

    public void getList(){
        int i = 1;
        for(Map.Entry map : listeStages.entrySet()){
            System.out.println("Stage " + i + " : " + map.getValue());
            i++;
        }
    }

    public Stage getStage(int i){
        Stage stage = listeStages.get(i);
        return stage;
    }

    public int getStagesCreated() {
        return StagesCreated;
    }

    public boolean addLink(int input1, Activite act) {

        Activite verif = act;
        Stage modif = listeStages.get(input1);
        Set<Activite> test = modif.getActivitesDuStage();
        boolean add = true;
        String message = null;
        LocalDateTime dateFinAct = act.getDateDebut();
        Long minstage = (long) act.getDureeActivite();
        dateFinAct = dateFinAct.plusMinutes(minstage);

        if (verif.getDateDebut().isBefore(modif.getDateDebut()) || verif.getDateDebut().isAfter(modif.getDateFin())){
            add = false;
            message = "La date de l'activité ne correspond pas aux dates du stage";
        }

        if (dateFinAct.isAfter(modif.getDateFin())){
            add = false;
            message = "L'activité prend fin après la fin du stage";
        }

        //TODO : Corriger le foreach et le transformer en while
        for(Activite a : test){
            if (a.equals(verif)){
                add = false;
                message = "Cette activité ne peut pas être ajoutée dans le stage, car elle s'y trouve déjà";
            }
        }

        if (add){
            message = "Activité ajoutée avec succès !";
            modif.getActivitesDuStage().add(verif);
        }

        System.out.println(message);
        return add;
    }
}
