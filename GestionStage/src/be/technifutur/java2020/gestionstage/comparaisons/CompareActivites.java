package be.technifutur.java2020.gestionstage.comparaisons;

import be.technifutur.java2020.gestionstage.activites.Activite;

import java.io.Serializable;
import java.util.Comparator;

public class CompareActivites implements Comparator<Activite>, Serializable {

    @Override
    public int compare(Activite a1, Activite a2) {
        int compare = 0;
        compare =  a1.getDateDebut().compareTo(a2.getDateDebut());
        return compare;
    }
}
