package be.technifutur.java2020.gestionstage.donnees;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.comparaisons.CompareNoms;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Activite implements Serializable {

    private String nomActivite;
    private LocalDateTime dateDebut;
    private int dureeActivite;
    public static int ActivitiesCreated = 0;
    private Set<Participant> inscritsActivite = new TreeSet<>(new CompareNoms());

    public Activite add(String data, LocalDateTime dateDebut, int duree) {

        Activite activite = new Activite();
        setNomActivite(data);
        setDateDebut(dateDebut);
        setDureeActivite(duree);
        ActivitiesCreated++;
        return activite;

    }

    public String getNomActivite() {
        return nomActivite;
    }

    public void setNomActivite(String nomStage) {
        this.nomActivite = nomStage;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getDureeActivite() {
        return dureeActivite;
    }

    public void setDureeActivite(int dureeActivite) {
        this.dureeActivite = dureeActivite;
    }

    public Set<Participant> getInscritsActivite() {
        return inscritsActivite;
    }

    public boolean verifMember(Participant p){
        Set<Participant> test = getInscritsActivite();
        boolean verif = false;

        for (Participant part : test) {
            if (part.equals(p)) {
                verif = true;
            }
        }
        return verif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activite activite = (Activite) o;
        return Objects.equals(nomActivite, activite.nomActivite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomActivite, dateDebut, dureeActivite);
    }

    @Override
    public String toString() {
        FonctionsUtiles util = new FonctionsUtiles();
        return nomActivite + ", date de début = " + util.afficheDate(dateDebut) + ", durée de l'activité = " + dureeActivite + " minutes";
    }
}
