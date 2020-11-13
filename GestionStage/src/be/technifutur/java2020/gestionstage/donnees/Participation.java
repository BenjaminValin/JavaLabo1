package be.technifutur.java2020.gestionstage.donnees;

import be.technifutur.java2020.gestionstage.comparaisons.CompareActivites;

import java.io.Serializable;
import java.util.*;

public class Participation implements Serializable {

    public Participant participant;
    public Stage stage;
    private Set<Activite> activitesSuivies = new TreeSet<>(new CompareActivites());
    private Map<String, Double> tarifs = new HashMap<>();
    private Map<String, Double> facture = new HashMap<>();

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Set<Activite> getActivitesSuivies() {
        return activitesSuivies;
    }

    public void setActivitesSuivies(Set<Activite> activitesSuivies) {
        this.activitesSuivies = activitesSuivies;
    }

    public Map<String, Double> getTarifs() {
        return tarifs;
    }

    public void setTarifs(Map<String, Double> tarifs) {
        this.tarifs = tarifs;
    }

    public Map<String, Double> getFacture() {
        return facture;
    }

    public void setFacture(Map<String, Double> facture) {
        this.facture = facture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participation that = (Participation) o;
        return Objects.equals(participant, that.participant);
    }

    public boolean verifAct(Activite a) {
        Set<Activite> test = this.getActivitesSuivies();
        boolean verif = false;

        for (Activite ac : test) {
            if (ac.equals(a)) {
                verif = true;
            }
        }
        return verif;
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant, stage);
    }

    @Override
    public String toString() {
        return " " + participant;
    }
}
