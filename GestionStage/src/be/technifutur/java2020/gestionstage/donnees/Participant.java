package be.technifutur.java2020.gestionstage.donnees;

import be.technifutur.java2020.gestionstage.comparaisons.CompareActivites;

import java.io.Serializable;
import java.util.*;

public class Participant implements Serializable {

    private String prenom;
    private String nom;
    private String nomClub = "Pas de club";
    private String mail = "Pas de mail";

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomClub() {
        return nomClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(prenom, that.prenom) &&
                Objects.equals(nom, that.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prenom, nom);
    }

    @Override
    public String toString() {
        return prenom + " " + nom + ", nom du club : " + nomClub + ", adresse mail : " + mail;
    }
}
