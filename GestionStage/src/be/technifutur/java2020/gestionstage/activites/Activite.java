package be.technifutur.java2020.gestionstage.activites;

import java.time.LocalDateTime;
import java.util.Objects;

public class Activite {

    private String nomActivite;
    private LocalDateTime dateDebut;
    private int dureeActivite;
    public static int ActivitiesCreated = 0;

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
        return " Nom de l'activité = " + nomActivite + ", date de début = " + dateDebut + ", durée de l'activité = " + dureeActivite + " minutes";
    }
}
