package be.technifutur.java2020.gestionstage.donnees;

import be.technifutur.java2020.gestionstage.comparaisons.CompareActivites;
import be.technifutur.java2020.gestionstage.comparaisons.CompareNoms;
import be.technifutur.java2020.gestionstage.FonctionsUtiles;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.Objects;
import java.util.TreeSet;


public class Stage implements Serializable {

    private String nomStage;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private Set<Activite> activitesDuStage = new TreeSet<>(new CompareActivites());             //set trié par date d'activités
    private Set<Participant> participantsAuStage = new TreeSet<>(new CompareNoms());            //set trié par nom, puis prénom du participant

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

    public Set<Participant> getParticipantsAuStage() {
        return participantsAuStage;
    }

    public void setParticipantsAuStage(Set<Participant> participantsAuStage) {
        this.participantsAuStage = participantsAuStage;
    }

    public boolean verifMember(Participant participant) {
        Set<Participant> test = getParticipantsAuStage();
        boolean verif = false;

        for (Participant p : test) {
            if (p.equals(participant)) {
                verif = true;
            }
        }
        return verif;
    }

    public Participant getMember(Participant participant) {
        Set<Participant> test = getParticipantsAuStage();
        Participant p = null;

        for (Participant pr : test) {
            if (pr.equals(participant)) {
                p = pr;
            }
        }
        return p;
    }

    public boolean verifActivity(Activite activite) {
        Set<Activite> test = getActivitesDuStage();
        boolean verif = false;

        for (Activite a : test) {
            if (a.getNomActivite().equals(activite.getNomActivite())) {
                verif = true;
            }
        }
        return verif;
    }

    public Activite getActivity(Activite activite) {
        Set<Activite> test = getActivitesDuStage();
        Activite act = activite;

        for (Activite a : test) {
            if (a.getNomActivite().equals(act.getNomActivite())) {
                act = a;
            }
        }
        return act;
    }

    public Activite getActivity(String n) {
        Set<Activite> test = getActivitesDuStage();
        Activite act = null;

        for (Activite a : test) {
            if (a.getNomActivite().equals(n)) {
                act = a;
            }
        }
        return act;
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
        FonctionsUtiles util = new FonctionsUtiles();
        return " Nom du stage : " + nomStage + "\nActivités du stage : " + activitesDuStage + "\nParticipants au stage : " + participantsAuStage + "\nDate de début du stage : " + util.afficheDate(dateDebut) + ", date de fin du stage : " + util.afficheDate(dateFin) + ".\n";
    }
}
