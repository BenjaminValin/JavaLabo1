package be.technifutur.java2020.gestionstage.menusroles;

import be.technifutur.java2020.gestionstage.menusorganisateur.MenuActivite;
import be.technifutur.java2020.gestionstage.menusorganisateur.MenuStage;

import java.util.Scanner;

public class Organisateur implements Gestionnaires {

    @Override
    public String getName() {
        String name = "Organisateur";
        return name;
    }

    public void menu() {
        String[] choix = new String[]{"Stages", "Activités", "(a venir)"};
        Scanner scan = new Scanner(System.in);
        int input;
        menuOrganisateur(choix);

        input = scan.nextInt();
        while (input != 0) {
            int choice = input;
            if (choice < (choix.length) && choice >= 1) {
                switch (choice) {
                    case 1:
                        MenuStage menustage = new MenuStage();
                        System.out.println("***" + choix[0] + "***");
                        menustage.menu();
                        break;
                    case 2:
                        MenuActivite menuact = new MenuActivite();
                        System.out.println("***" + choix[1] + "***");
                        menuact.menu();
                        break;
                    case 3:
                        System.out.println("***" + choix[2] + "***");
                        break;
                }
            } else {
                System.out.println("Choix impossible");
            }
            menuOrganisateur(choix);
            input = scan.nextInt();
        }
        System.out.println("Retour au menu des gestionnaires");

    }

    private static void menuOrganisateur(String[] choix) {
        System.out.println();
        System.out.println("***Menu des organisateurs***");
        System.out.println("A quel sous-menu souhaitez-vous accéder ?");
        System.out.println("Entrez le nombre correspondant au choix souhaité : ");
        System.out.println();
        for (int i = 0; i < choix.length; i++) {
            System.out.printf(" - %d : %s%n", i + 1, choix[i]);
        }
        System.out.printf(" - %s : %s%n", "0", "Quitter");
        System.out.println();
        System.out.print("Faites votre choix : ");
    }
}
