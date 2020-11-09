package be.technifutur.java2020.gestionstage.participants;

import java.util.Objects;

public class Participant {

    private Nom nom;
    private String nomClub = null;
    private String mail = null;

    private class Nom {
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
    }

    public Nom getNom() {
        return nom;
    }

    public void setNom(Nom nom) {
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
}
