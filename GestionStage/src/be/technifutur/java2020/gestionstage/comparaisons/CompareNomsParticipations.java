package be.technifutur.java2020.gestionstage.comparaisons;

import be.technifutur.java2020.gestionstage.donnees.Participant;
import be.technifutur.java2020.gestionstage.donnees.Participation;

import java.io.Serializable;
import java.util.Comparator;

public class CompareNomsParticipations implements Comparator<Participation>, Serializable {

    @Override
    public int compare(Participation p1, Participation p2) {
        int compare = 0;
        compare =  p1.getParticipant().getNom().compareTo(p2.getParticipant().getNom());
        if (compare == 0){
            compare = p1.getParticipant().getPrenom().compareTo(p2.getParticipant().getPrenom());
        }
        return compare;
    }
}