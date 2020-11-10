package be.technifutur.java2020.gestionstage.menusroles;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.optionsvisiteurs.ConsultPlanning;

import java.util.Scanner;

public class Visiteur implements Gestionnaires {

    private ConsultPlanning consult;
    private FonctionsUtiles util;

    @Override
    public String getName() {
        String name = "Visiteur";
        return name;
    }

    @Override
    public void menu() {
        String[] menu = new String[]{"Consultation du calendrier d'un stage", "Fonction à venir"};
        Scanner scan = new Scanner(System.in);
        int input;
        String choix;
        menuVisiteur(menu);

        choix = scan.nextLine();
        while (!util.estUnNombre(choix)){
            System.out.println("Ceci n'est pas un nombre. Recommencez :");
            choix = scan.nextLine();
        }
        input = Integer.parseInt(choix);

        while (input != 0) {
            if (input < (menu.length) && input >= 1) {
                int choice = input-1;
                switch (input) {
                    case 1:
                        System.out.println("***" + menu[choice] + "***");
                        consult.consult();
                        break;
                }
            } else {
                System.out.println("Choix impossible");
            }
            menuVisiteur(menu);

            choix = scan.nextLine();
            while (!util.estUnNombre(choix)){
                System.out.println("Ceci n'est pas un nombre. Recommencez :");
                choix = scan.nextLine();
            }
            input = Integer.parseInt(choix);

        }
        System.out.println("Retour au menu des gestionnaires");


    }

    private static void menuVisiteur(String[] menu) {
        System.out.println();
        System.out.println("***Menu des visiteurs***");
        System.out.println("A quel sous-menu souhaitez-vous accéder ?");
        System.out.println("Entrez le nombre correspondant au choix souhaité : ");
        System.out.println();
        for (int i = 0; i < menu.length; i++) {
            System.out.printf(" - %d : %s%n", i + 1, menu[i]);
        }
        System.out.printf(" - %s : %s%n", "0", "Quitter");
        System.out.println();
        System.out.print("Faites votre choix : ");
    }

    public void setConsultPlanning(ConsultPlanning consultPlanning) {
        this.consult = consultPlanning;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }
}
