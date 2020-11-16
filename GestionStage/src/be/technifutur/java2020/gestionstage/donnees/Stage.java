package be.technifutur.java2020.gestionstage.donnees;

import be.technifutur.java2020.gestionstage.comparaisons.CompareActivites;
import be.technifutur.java2020.gestionstage.comparaisons.CompareNomsParticipations;
import be.technifutur.java2020.gestionstage.FonctionsUtiles;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;


public class Stage implements Serializable {

    private String nomStage;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private Set<Activite> activitesDuStage = new TreeSet<>(new CompareActivites());                         //set trié par date d'activités
    private Set<Participation> participationsAuStage = new TreeSet<>(new CompareNomsParticipations());      //set trié par nom, puis prénom du participant

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

    public Set<Participation> getParticipationsAuStage() {
        return participationsAuStage;
    }

    public Set<Participant> getParticipants() {
        Set<Participant> p = new HashSet<>();
        for (Participation pr : this.getParticipationsAuStage()) {
            p.add(pr.getParticipant());
        }
        return p;
    }

    public boolean verifMember(Participation participation) {
        Set<Participation> test = getParticipationsAuStage();
        boolean verif = false;

        for (Participation pr : test) {
            if (pr.equals(participation)) {
                verif = true;
            }
        }
        return verif;
    }

    public Participant getMember(Participation participation) {
        Set<Participation> test = getParticipationsAuStage();
        Participant p = null;

        for (Participation pr : test) {
            if (pr.equals(participation)) {
                p = pr.getParticipant();
            }
        }
        return p;
    }

    public Participation getParticipation(Participant participant) {
        Set<Participation> test = getParticipationsAuStage();
        Participation p = null;

        for (Participation pr : test) {
            if (pr.getParticipant().equals(participant)) {
                p = pr;
            }
        }
        return p;
    }

    public Participation removeParticipation(Participant participant) {
        Set<Participation> test = getParticipationsAuStage();
        Participation p = null;

        for (Participation pr : test) {
            if (pr.getParticipant().equals(participant)) {
                test.remove(pr);
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

    public Activite removeActivity(Activite activite) {
        Set<Activite> test = getActivitesDuStage();
        Activite act = activite;

        for (Activite a : test) {
            if (a.getNomActivite().equals(act.getNomActivite())) {
                test.remove(a);
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
        return " Nom du stage : " + nomStage + "\nActivités du stage : " + activitesDuStage + "\nParticipations au stage : " + participationsAuStage + "\nDate de début du stage : " + util.afficheDate(dateDebut) + ", date de fin du stage : " + util.afficheDate(dateFin) + ".\n";
    }
}
