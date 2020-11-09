package be.technifutur.java2020.gestionstage.participants;

import java.util.Objects;
import java.util.Scanner;

public class Participant {

    //private Nom nom;
    private String prenom;
    private String nom;
    private String nomClub = "Pas de club";
    private String mail = "Pas de mail";

    /*private class Nom {
        private String nom;
        private String prenom;

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Nom nom1 = (Nom) o;
            return Objects.equals(nom, nom1.nom) &&
                    Objects.equals(prenom, nom1.prenom);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nom, prenom);
        }
    }*/

    /*public Nom getNom() {
        return nom;
    }

    public void createNom() {
        Nom n = new Nom();
        String s;
        System.out.println("Insérez le nom du participant :");
        s = new Scanner(System.in).nextLine();
        n.setNom(s);
        System.out.println("Insérez le prénom du participant :");
        s = new Scanner(System.in).nextLine();
        n.setPrenom(s);
        this.nom = n;
    }

    public void setNom(Nom nom) {
        this.nom = nom;
    }*/

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
}
