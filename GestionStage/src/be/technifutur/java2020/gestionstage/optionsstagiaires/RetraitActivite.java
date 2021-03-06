package be.technifutur.java2020.gestionstage.optionsstagiaires;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.donnees.*;

public class RetraitActivite {

    private ListeStage listes;
    private ListeParticipants listep;
    private FonctionsUtiles util;

    public void retire() {
        Stage stage;
        Participant participant = new Participant();
        Participation participation = new Participation();
        Activite a = new Activite();
        int number;

        System.out.println("Insérez votre nom :");
        participant.setNom(util.saisieDonneeNonVide());
        System.out.println("Insérez votre prénom :");
        participant.setPrenom(util.saisieDonneeNonVide());
        participation.setParticipant(participant);

        System.out.println("Voici les stages existants, avec leurs activités et participants");
        listes.getList();
        System.out.println("Quel est le numéro du stage dans lequel vous êtes inscrit ?");
        number = util.saisieNombre();
        stage = listes.getStage(number);

        if(!stage.verifMember(participation)){
            System.out.println("Vous n'êtes pas inscrit dans ce stage.");
        } else {
            participant = stage.getMember(participation);
            participation = stage.getParticipation(participant);
            System.out.println("Entrez le nom de l'activité pour laquelle vous voulez vous désinscrire :");
            String data = util.saisieDonneeNonVide();
            a.setNomActivite(data);
            if(!stage.verifActivity(a)){
                System.out.println("Cette activité n'est pas présente dans le stage choisi");
            } else {
                a = stage.getActivity(a);
                if (participation.verifAct(a)) {
                    participation.getActivitesSuivies().remove(a);
                    System.out.println("Inscription à l'activité " + a.getNomActivite() + " supprimée !");
                    util.sauvegardeListeStage(listes);
                    util.sauvegardeListeParticipants(listep);
                } else {
                    System.out.println("Vous n'êtes pas inscrit à cette activité");
                }
            }
        }
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }

    public void setListeParticipants(ListeParticipants listeParticipants) {
        this.listep = listeParticipants;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }
}
