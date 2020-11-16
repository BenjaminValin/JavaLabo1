package be.technifutur.java2020.gestionstage.optionstresorier;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.donnees.*;
import be.technifutur.java2020.gestionstage.tarifs.*;

import java.util.HashMap;
import java.util.Map;

public class AffecterTarif {

    private ListeStage listes;
    private FonctionsUtiles util;

    Tarif[] prix = new Tarif[]{
            new TarifDeBase(), new TarifEnfant(), new TarifSocial()
    };

    public void givePrice(){

        Participant participant = new Participant();
        Participation participation = new Participation();

        System.out.println("Voici la liste des stages :");
        listes.getList();
        System.out.println("De quel stage voulez-vous extraire un participant ?");
        int choix = util.saisieNombre();
        Stage s = listes.getStage(choix);

        System.out.println("Insérez le nom du participant :");
        participant.setNom(util.saisieDonneeNonVide());
        System.out.println("Insérez le prénom du participant :");
        participant.setPrenom(util.saisieDonneeNonVide());
        participation.setParticipant(participant);

        if(s.verifMember(participation)){
            participant = s.getMember(participation);
            participation = s.getParticipation(participant);
            System.out.println("Quel tarif doit être appliqué à ce participant ?");
            menuTarifs(prix);
            int input = util.saisieNombre();
            participation.setTarif(prix[input-1]);

            util.sauvegardeListeStage(listes);

        } else {
            System.out.println("Ce participant n'est pas dans le stage sélectionné");
        }
    }

    private static void menuTarifs(Tarif[] menu) {
        System.out.println("Entrez le nombre correspondant au choix souhaité : ");
        System.out.println();
        for (int i = 0; i < menu.length; i++) {
            System.out.printf(" - %d : %s%n", i + 1, menu[i].getName());
        }
        System.out.printf(" - %s : %s%n", "0", "Quitter");
        System.out.println();
        System.out.print("Faites votre choix : ");
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }
}
