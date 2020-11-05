package be.technifutur.java2020.gestionstage.activites;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ListeActivite {

    public static Map<Integer, Activite> listeActivites = new HashMap<>();

    public void add(String data, LocalDateTime dateDebut, int duree) {

        Activite activite = new Activite();
        activite.setNomActivite(data);
        activite.setDateDebut(dateDebut);
        activite.setDureeActivite(duree);
        Activite.ActivitiesCreated++;
        listeActivites.put(Activite.ActivitiesCreated,activite);

    }

    public void consult(int key){
        Activite consult;
        consult = listeActivites.get(key);
        System.out.println(consult.toString());
    }

    public void remove(int key){
        listeActivites.remove(key);
        Activite.ActivitiesCreated++;
    }

    public static void getList(){
        for(Map.Entry map : listeActivites.entrySet()){
            System.out.println("Activité : " + map);
        }
    }

}
