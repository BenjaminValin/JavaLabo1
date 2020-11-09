package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.participants.Participant;

import java.time.LocalDateTime;
import java.util.Comparator;

public class CompareDates implements Comparator<LocalDateTime> {

    @Override
    public int compare(LocalDateTime d1, LocalDateTime d2) {
        int compare = 0;
        compare =  d1.compareTo(d2);
        return compare;
    }
}
