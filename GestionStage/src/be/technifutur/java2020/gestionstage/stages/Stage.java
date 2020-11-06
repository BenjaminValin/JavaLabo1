package be.technifutur.java2020.gestionstage.stages;

import be.technifutur.java2020.gestionstage.activites.Activite;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;


public class Stage implements Serializable {

    private String nomStage;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private Set<Activite> activitesDuStage = new HashSet<>();
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

    public Set<Activite> getActivitesDuStage() {
        return activitesDuStage;
    }

    public void setActivitesDuStage(Set<Activite> activitesDuStage) {
        this.activitesDuStage = activitesDuStage;
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
        return " Nom du stage : " + nomStage + ", activité du stage : " + activitesDuStage + ", date de début du stage : " + dateDebut + ", date de fin du stage : " + dateFin + ".";
    }
}
