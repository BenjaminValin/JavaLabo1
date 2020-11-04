package be.technifutur.java2020.gestionstage;

import java.time.LocalDateTime;

public class Stage {

    private String nomStage;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

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
}
