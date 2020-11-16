package be.technifutur.java2020.gestionstage.optionstresorier;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.donnees.ListeStage;
import be.technifutur.java2020.gestionstage.donnees.Participant;
import be.technifutur.java2020.gestionstage.donnees.Participation;
import be.technifutur.java2020.gestionstage.donnees.Stage;

public class VoirFactureParticipant {

    private ListeStage listes;
    private FonctionsUtiles util;

    public void getBill() {

        Stage s;
        Participant participant = new Participant();
        Participation participation = new Participation();
        double cout;

        System.out.println("Voici la liste des stages :");
        listes.getList();
        System.out.println("De quel stage voulez-vous extraire un participant ?");
        int choix = util.saisieNombre();
        s = listes.getStage(choix);

        System.out.println("Insérez le nom du participant :");
        participant.setNom(util.saisieDonneeNonVide());
        System.out.println("Insérez le prénom du participant :");
        participant.setPrenom(util.saisieDonneeNonVide());
        participation.setParticipant(participant);

        if (s.verifMember(participation)) {
            participant = s.getMember(participation);
            participation = s.getParticipation(participant);
            cout = participation.getTarif().tarif(participation.getActivitesSuivies());
            System.out.println("Pour " + participation.getParticipant().getPrenom() + " " + participation.getParticipant().getNom() + ", le coût du stage est à l'heure actuelle de " + util.affichePrix(cout));
        } else {
            System.out.println("Ce participant n'est pas dans le stage sélectionné");
        }
        util.sauvegardeListeStage(listes);
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

}
