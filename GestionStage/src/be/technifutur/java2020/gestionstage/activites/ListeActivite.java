package be.technifutur.java2020.gestionstage.activites;

import be.technifutur.java2020.gestionstage.stages.Stage;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ListeActivite {

    public static Map<Integer, Activite> listeActivites = new HashMap<>();
    private Activite activite = new Activite();

    public void addActivity(String data, LocalDateTime dateDebut, int duree) {

        activite.setNomActivite(data);
        activite.setDateDebut(dateDebut);
        activite.setDureeActivite(duree);
        Activite.ActivitiesCreated++;
        listeActivites.put(Activite.ActivitiesCreated,activite);

    }

    public void consultActivity(int key){
        Activite consult;
        consult = listeActivites.get(key);
        System.out.println(consult.toString());
    }

    public void removeActivity(int key){
        listeActivites.remove(key);
        Activite.ActivitiesCreated++;
    }

    public void getActivitiesList(){
        for(Map.Entry map : listeActivites.entrySet()){
            System.out.println("Activité : " + map);
        }
    }

}
