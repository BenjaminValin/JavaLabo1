package be.technifutur.java2020.gestionstage.optionsstagiaires;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.participants.ListeParticipants;
import be.technifutur.java2020.gestionstage.participants.Participant;
import be.technifutur.java2020.gestionstage.stages.ListeStage;
import be.technifutur.java2020.gestionstage.stages.Stage;

import java.util.Scanner;
import java.util.Set;

public class InscriptionActivite {

    private ListeStage listes;
    private ListeParticipants listep;
    private FonctionsUtiles util;

    public void associate() {
        Stage stage;
        Participant p = null;
        int number;

        System.out.println("Insérez votre nom :");
        p.setNom(util.saisieDonneeNonVide());
        System.out.println("Insérez votre prénom :");
        p.setPrenom(util.saisieDonneeNonVide());

        System.out.println("Voici les stages existants, avec leurs activités et participants");
        listes.getList();
        System.out.println("Quel est le numéro du stage dans lequel vous êtes inscrit ?");
        number = util.saisieNombre();
        stage = listes.getStage(number);

        if(!stage.verifMember(stage, p)){
            System.out.println("Vous n'êtes pas inscrit dans ce stage.");
        } else {
            //Set<Participant> partstage = stage.getParticipantsAuStage();
            //Set<Activite> actstage = stage.getActivitesDuStage();
            System.out.println("Entrez le nom de l'activité à laquelle vous voulez vous inscrire :");
            String data = util.saisieDonneeNonVide();
            if(!stage.verifActivity(stage, data)){
                System.out.println("Cette activité n'est pas présente dans le stage choisi");
            } else if () {
                //TODO Vérifier si le stagiaire n'est pas déjà inscrit dans l'activité choisie
            } else {
                System.out.println("Inscription à l'activité validée");
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
