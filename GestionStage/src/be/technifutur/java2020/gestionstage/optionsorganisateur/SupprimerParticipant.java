package be.technifutur.java2020.gestionstage.optionsorganisateur;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.donnees.*;

public class SupprimerParticipant {

    private FonctionsUtiles util;
    private ListeStage listes;

    public void deleteMember(){
        Stage stage;
        Participant participant = new Participant();
        Participation participation = new Participation();

        System.out.println("Voici les stages existants, avec leurs activités et participants");
        listes.getList();
        System.out.println("Quel est le numéro du stage dans lequel le participant se trouve ?");
        int number = util.saisieNombre();
        stage = listes.getStage(number);

        System.out.println("Insérez le nom du participant :");
        participant.setNom(util.saisieDonneeNonVide());
        System.out.println("Insérez le prénom du participant :");
        participant.setPrenom(util.saisieDonneeNonVide());
        participation.setParticipant(participant);

        if (stage.verifMember(participation)) {
            participant = stage.getMember(participation);
            stage.removeParticipation(participant);
            util.sauvegardeListeStage(listes);
        } else {
            System.out.println("Cette personne n'est pas inscrita au stage");
        }
    }


    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }

}
