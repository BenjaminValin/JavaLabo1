package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.menusroles.*;

import java.io.FileNotFoundException;

public class MenuPrincipal {

    public Organisateur orga;
    private Visiteur visiteur;
    private FonctionsUtiles util;
    private Stagiaire stagiaire;

    public void start() throws FileNotFoundException {

        Gestionnaires[] menu = new Gestionnaires[]{
                orga, visiteur, stagiaire, new Secretaire(), new Tresorier()
        };
        int input;
        menuChoixParticipant(menu);

        input = util.saisieNombre();

        while (input != 0) {
            if (input < (menu.length) && input >= 1) {
                int choice = input-1;
                switch (input) {
                    case 1:
                        System.out.println("Entrée dans le menu des organisateurs :");
                        menu[choice].menu();
                        break;
                    case 2:
                        System.out.println("Entrée dans le menu des visiteurs :");
                        menu[choice].menu();
                        break;
                    case 3:
                        System.out.println("Entrée dans le menu des stagiaires :)");
                        menu[choice].menu();
                        break;
                    case 4:
                        System.out.println("Fonctionnalité à venir, soyez patients ;)");
                        break;
                }
            } else {
                System.out.println("Choix impossible");
            }
            menuChoixParticipant(menu);

            input = util.saisieNombre();

        }
        System.out.println("Bonne journée !");
    }

    private static void menuChoixParticipant(Gestionnaires[] menu) {
        System.out.println();
        System.out.println("***Menu principal***");
        System.out.println("Quel est votre rôle ?");
        System.out.println("Entrez le nombre correspondant au choix souhaité : ");
        System.out.println();
        for (int i = 0; i < menu.length; i++) {
            System.out.printf(" - %d : %s%n", i + 1, menu[i].getName());
        }
        System.out.printf(" - %s : %s%n", "0", "Quitter");
        System.out.println();
        System.out.print("Faites votre choix : ");
    }


    public void setOrga(Organisateur orga) {
        this.orga = orga;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }
}
