package be.technifutur.java2020.gestionstage;

import java.time.LocalDateTime;
import java.util.Objects;

public class Stage {

    private String nomStage;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
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
        return "Stage : Nom du stage : " + nomStage + ", date de début : " + dateDebut + ", date de fin : " + dateFin + ".";
    }
}
