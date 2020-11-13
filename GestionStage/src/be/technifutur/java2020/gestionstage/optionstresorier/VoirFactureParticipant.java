package be.technifutur.java2020.gestionstage.optionstresorier;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.donnees.ListeStage;
import be.technifutur.java2020.gestionstage.donnees.Participant;
import be.technifutur.java2020.gestionstage.donnees.Stage;

import java.util.Map;

public class VoirFactureParticipant {

    private ListeStage listes;
    private FonctionsUtiles util;

    public void getBill() {
/*
        Stage s;
        Participant p = new Participant();
        double totalFact = 0.0;

        System.out.println("Voici la liste des stages :");
        listes.getList();
        System.out.println("Dans quel stage se trouve le participant voulu ?");
        int choix = util.saisieNombre();
        s = listes.getStage(choix);

        System.out.println("Insérez le nom du participant :");
        p.setNom(util.saisieDonneeNonVide());
        System.out.println("Insérez le prénom du participant :");
        p.setPrenom(util.saisieDonneeNonVide());

        if(!s.verifMember(p)){
            System.out.println("Ce participant n'a pas été trouvé dans ce stage.");
        } else {
            p = s.getMember(p);
            Map<String, Double> facture = p.getFacture();

            for (double d : facture.values()) {
                totalFact = totalFact + d;
            }

            for(Map.Entry m : facture.entrySet()){
                System.out.println(m);
            }

            System.out.print("Le participant doit payer ");
            System.out.print(util.affichePrix(totalFact));
            System.out.print(" pour le stage");
        }*/
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

}
