package be.technifutur.java2020.gestionstage.optionsstagiaires;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.participants.ListeParticipants;
import be.technifutur.java2020.gestionstage.participants.Participant;
import be.technifutur.java2020.gestionstage.stages.ListeStage;
import be.technifutur.java2020.gestionstage.stages.Stage;

public class InscriptionActivite {

    private ListeStage listes;
    private ListeParticipants listep;
    private FonctionsUtiles util;

    public void associate() {
        Stage stage;
        Participant p = new Participant();
        Activite a = new Activite();
        int number;

        load();                                     //TODO : trouver une solution pour unifier les listes après chargement de la sauvegarde, load utilisé provisoirement
        System.out.println("Insérez votre nom :");
        p.setNom(util.saisieDonneeNonVide());
        System.out.println("Insérez votre prénom :");
        p.setPrenom(util.saisieDonneeNonVide());

        System.out.println("Voici les stages existants, avec leurs activités et participants");
        listes.getList();
        System.out.println("Quel est le numéro du stage dans lequel vous êtes inscrit ?");
        number = util.saisieNombre();
        stage = listes.getStage(number);

        if(!stage.verifMember(p)){
            System.out.println("Vous n'êtes pas inscrit dans ce stage.");
        } else {
            p = stage.getMember(p);
            System.out.println("Entrez le nom de l'activité à laquelle vous voulez vous inscrire :");
            String data = util.saisieDonneeNonVide();
            a.setNomActivite(data);
            if(!stage.verifActivity(a)){
                System.out.println("Cette activité n'est pas présente dans le stage choisi");
            } else {
                a = stage.getActivity(a);
                if (a.verifMember(p)) {
                    System.out.println("Vous êtes déjà inscrit à cette activité");
                } else {
                    a.getInscritsActivite().add(p);
                    //p.getActivitesSuivies().add(a);                   // problème ClassCastException dans cette opération
                    System.out.println("Inscription à l'activité " + a.getNomActivite() + " validée !");
                    util.sauvegardeListeStage(this.listes);
                }
            }
        }
    }

    public void load(){
        this.listes = util.chargementListeStage();
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