package be.technifutur.java2020.gestionstage.donnees;

import be.technifutur.java2020.gestionstage.comparaisons.CompareActivites;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Participation {

    public Participant personne;
    public Stage stage;
    private Set<Activite> activitesSuivies = new TreeSet<>(new CompareActivites());
    private Map<String, Double> tarifs = new HashMap<>();
    private Map<String, Double> facture = new HashMap<>();

    public String getPrenom() {
        return personne.getPrenom();
    }

    public String getNom() {
        return personne.getNom();
    }

    public Set<Activite> getActivitesSuivies() {
        return activitesSuivies;
    }

    public Map<String, Double> getTarifs() {
        return tarifs;
    }

    public Map<String, Double> getFacture() {
        return facture;
    }
}
