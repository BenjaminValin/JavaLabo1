package be.technifutur.java2020.gestionstage.menusroles;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.optionsstagiaires.InscriptionActivite;
import be.technifutur.java2020.gestionstage.optionsstagiaires.RetraitActivite;

public class Stagiaire implements Gestionnaires {


    private FonctionsUtiles util;
    private InscriptionActivite inscripactiv;
    private RetraitActivite retractiv;

    @Override
    public String getName() {
        String name = "Stagiaire/participant";
        return name;
    }

    @Override
    public void menu() {

        String[] menu = new String[]{"S'inscrire à une activité", "Se désinscrire d'une activité", "Fonctionnalité à venir"};
        int input;
        menuStage(menu);

        input = util.saisieNombre();

        while (input != 0) {
            if (input < (menu.length) && input >= 1) {
                int choice = input - 1;
                switch (input) {
                    case 1:
                        System.out.println("***" + menu[choice] + "***");
                        inscripactiv.associate();
                        break;
                    case 2:
                        System.out.println("***" + menu[choice] + "***");
                        retractiv.retire();
                        break;
                }
            } else {
                System.out.println("Choix impossible");
            }
            menuStage(menu);
            input = util.saisieNombre();
        }
        System.out.println("Retour au menu principal");

    }

    private static void menuStage(String[] menu) {
        System.out.println();
        System.out.println("***Menu des stagiaires/participants***");
        System.out.println("Que souhaitez-vous faire ?");
        System.out.println("Entrez le nombre correspondant au choix souhaité : ");
        System.out.println();
        for (int i = 0; i < menu.length; i++) {
            System.out.printf(" - %d : %s%n", i + 1, menu[i]);
        }
        System.out.printf(" - %s : %s%n", "0", "Quitter");
        System.out.println();
        System.out.print("Faites votre choix : ");
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

    public void setInscriptionActivite(InscriptionActivite inscriptionActivite) {
        this.inscripactiv = inscriptionActivite;
    }

    public void setRetraitActivite(RetraitActivite retraitActivite) {
        this.retractiv = retraitActivite;
    }
}
