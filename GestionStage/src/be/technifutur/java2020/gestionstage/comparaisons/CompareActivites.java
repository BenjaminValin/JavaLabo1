package be.technifutur.java2020.gestionstage.comparaisons;

import be.technifutur.java2020.gestionstage.donnees.Activite;

import java.io.Serializable;
import java.util.Comparator;

public class CompareActivites implements Comparator<Activite>, Serializable {

    @Override
    public int compare(Activite a1, Activite a2) {
        int compare = 0;
        compare =  a1.getDateDebut().compareTo(a2.getDateDebut());
        if (compare == 0){
            compare = a1.getNomActivite().compareTo(a2.getNomActivite());
        }
        return compare;
    }
}
