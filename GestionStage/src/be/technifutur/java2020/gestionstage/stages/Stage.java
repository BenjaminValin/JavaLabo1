package be.technifutur.java2020.gestionstage.stages;

import be.technifutur.java2020.gestionstage.activites.Activite;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Stage {

    private String nomStage;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private Activite activite = null;
    public Map<Integer, Activite> listeActivites = new HashMap<>();
    public static int StageKey = 0;
    public static int StagesCreated = 0;

    public String getNomStage() {
        return nomStage;
    }

    public void setNomStage(String nomStage) {
        this.nomStage = nomStage;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public Activite getActivite() {
        return activite;
    }

    public Map<Integer, Activite> getListeActivites() {
        return listeActivites;
    }

    public void setListeActivites(Map<Integer, Activite> listeActivites) {
        this.listeActivites = listeActivites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return Objects.equals(nomStage, stage.nomStage) &&
                Objects.equals(dateDebut, stage.dateDebut) &&
                Objects.equals(dateFin, stage.dateFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomStage, dateDebut, dateFin);
    }

    @Override
    public String toString() {
        return " Nom du stage : " + nomStage + ", activité du stage : " + activite + ", date de début : " + dateDebut + ", date de fin : " + dateFin + ".";
    }
}
