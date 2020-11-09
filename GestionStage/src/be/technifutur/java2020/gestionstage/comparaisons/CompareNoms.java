package be.technifutur.java2020.gestionstage.comparaisons;

import be.technifutur.java2020.gestionstage.participants.Participant;

import java.io.Serializable;
import java.util.Comparator;

public class CompareNoms implements Comparator<Participant>, Serializable {

    @Override
    public int compare(Participant p1, Participant p2) {
        int compare = 0;
        compare =  p1.getNom().compareTo(p2.getNom());
        if (compare == 0){
            compare = p1.getPrenom().compareTo(p2.getPrenom());
        }
        return compare;
    }
}