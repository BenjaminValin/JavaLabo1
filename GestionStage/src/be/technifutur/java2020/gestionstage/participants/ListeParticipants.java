package be.technifutur.java2020.gestionstage.participants;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.comparaisons.CompareNoms;
import be.technifutur.java2020.gestionstage.stages.Stage;

import java.io.Serializable;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ListeParticipants implements Serializable {

    private Set<Participant> listeParticipants = new TreeSet<>(new CompareNoms());

    public Set<Participant> getListeParticipants() {
        return listeParticipants;
    }

    public void setListeParticipants(Set<Participant> listeParticipants) {
        this.listeParticipants = listeParticipants;
    }

    public void addMember(Participant p) {
        this.listeParticipants.add(p);
    }

    public void addMember(Boolean add, Stage s, Participant part) {

        FonctionsUtiles util = new FonctionsUtiles();
        char r = ' ';
        Scanner scan = new Scanner(System.in);

        if (add){
            System.out.println("Le participant a t'il un club ? Tapez O pour oui, N (ou un autre caractère) pour non :");
            r = Character.toUpperCase(scan.nextLine().charAt(0));
            if (r == 'O'){
                System.out.println("Insérez le nom du club du participant :");
                String club = scan.nextLine().trim();
                part.setNomClub(club);
            }
            System.out.println("Le participant a t'il une adresse mail ? Tapez O pour oui, N (ou un autre caractère) pour non :");
            r = Character.toUpperCase(scan.nextLine().charAt(0));
            if (r == 'O'){
                System.out.println("Insérez l'adresse mail du participant :");
                String club = scan.nextLine().trim();
                part.setMail(club);
            }
            System.out.println("Participant ajoutée avec succès !");
            s.getParticipantsAuStage().add(part);
            addMember(part);
        } else {
            Participant doublon = getMember(s, part);
            System.out.println("Voulez-vous néanmoins modifier son club/son mail ? Tapez O pour oui, N (ou un autre caractère) pour non :");
            r = Character.toUpperCase(scan.nextLine().charAt(0));
            if (r == 'O') {
                System.out.println("Voulez-vous modifier son club ? Tapez O pour oui, N (ou un autre caractère) pour non :");
                r = Character.toUpperCase(scan.nextLine().charAt(0));
                if (r == 'O') {
                    System.out.println("Insérez le nom du club du participant :");
                    String club = scan.nextLine().trim();
                    part.setNomClub(club);
                } else {
                    part.setNomClub(doublon.getNomClub());
                }
                System.out.println("Voulez-vous modifier son adresse mail ? Tapez O pour oui, N (ou un autre caractère) pour non :");
                r = Character.toUpperCase(scan.nextLine().charAt(0));
                if (r == 'O') {
                    System.out.println("Insérez l'adresse mail du participant :");
                    String mail = util.saisieMail().trim();
                    part.setMail(mail);
                } else {
                    part.setMail(doublon.getMail());
                }
                s.getParticipantsAuStage().remove(doublon);
                s.getParticipantsAuStage().add(part);
                removeMember(doublon);
                addMember(part);
            } else {
                System.out.println("Voulez-vous retirer cet utilisateur du stage ? Tapez O pour oui, N (ou un autre caractère) pour non :");
                r = Character.toUpperCase(scan.nextLine().charAt(0));
                if (r == 'O') {
                    s.getParticipantsAuStage().remove(doublon);
                }
            }
        }
    }

    public void removeMember(Participant p) {
        this.listeParticipants.remove(p);
    }

    public boolean verifMember(Stage s, Participant participant) {
        Set<Participant> test = s.getParticipantsAuStage();
        boolean verif = true;

        for (Participant p : test) {
            if (p.equals(participant)) {
                verif = false;
                System.out.println("Ce participant ne peut pas être inclus dans le stage, car il s'y trouve déjà");
                System.out.println(p);
            }
        }

        return verif;
    }

    public Participant getMember(Stage s, Participant participant) {
        Participant pDoublon = null;
        Set<Participant> test = s.getParticipantsAuStage();

        for (Participant p : test) {
            if (p.equals(participant)) {
                pDoublon = p;
            }
        }

        return pDoublon;
    }

    public Participant getMember(Participant participant) {
        Participant pDoublon = null;

        for (Participant p : listeParticipants) {
            if (p.equals(participant)) {
                pDoublon = p;
            }
        }

        return pDoublon;
    }

    @Override
    public String toString() {
        return "Liste des participants = " + listeParticipants;
    }

}
