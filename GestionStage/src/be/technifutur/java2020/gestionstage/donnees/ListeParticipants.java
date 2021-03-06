package be.technifutur.java2020.gestionstage.donnees;
import be.technifutur.java2020.gestionstage.comparaisons.CompareNomsParticipants;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class ListeParticipants implements Serializable {

    private Set<Participant> listeParticipants = new TreeSet<>(new CompareNomsParticipants());

    public Set<Participant> getListeParticipants() {
        return listeParticipants;
    }

    public void addMember(Participant p) {
        this.listeParticipants.add(p);
    }

    public void removeMember(Participant p) {
        this.listeParticipants.remove(p);
    }

    public boolean verifMember(Stage s, Participant participant) {
        Set<Participant> test = s.getParticipants();
        boolean verif = true;

        for (Participant p : test) {
            if (p.equals(participant)) {
                verif = false;
                System.out.println("Ce participant ne peut pas être inclus dans le stage, car il s'y trouve déjà");
                System.out.println(p);
            }
        }

        return verif;
    }

    public boolean verifMember(Stage s, Participation participation) {
        Set<Participation> test = s.getParticipationsAuStage();
        boolean verif = true;

        for (Participation p : test) {
            if (p.equals(participation)) {
                verif = false;
                System.out.println("Ce participant ne peut pas être inclus dans le stage, car il s'y trouve déjà");
                System.out.println(p);
            }
        }

        return verif;
    }

    public Participant getMember(Stage s, Participant participant) {
        Participant pDoublon = null;
        Set<Participant> test = s.getParticipants();

        for (Participant p : test) {
            if (p.equals(participant)) {
                pDoublon = p;
            }
        }

        return pDoublon;
    }

    public Participant getMember(Participant participant) {
        Participant pDoublon = null;

        for (Participant p : listeParticipants) {
            if (p.equals(participant)) {
                pDoublon = p;
            }
        }

        return pDoublon;
    }

    @Override
    public String toString() {
        return "Liste des participants = " + listeParticipants;
    }
}
