package be.technifutur.java2020.gestionstage.menusorganisateur;

import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.activites.ActiviteCtrl;

import java.util.Scanner;

public class MenuActivite {

    public void menu() {
        String[] choix = new String[]{"Création d'activité", "Consultation des activités", "Suppression d'une activité", "Modification d'une activité (a venir)"};
        Scanner scan = new Scanner(System.in);
        ActiviteCtrl ctrl = new ActiviteCtrl();
        int input, number;
        menuActivite(choix);

        input = scan.nextInt();
        while (input != 0) {
            int choice = input;
            if (choice < (choix.length) && choice >= 1) {
                switch (choice) {
                    case 1:
                        System.out.println("***" + choix[0] + "***");
                        ctrl.addActivity();
                        break;
                    case 2:
                        System.out.println("***" + choix[1] + "***");
                        System.out.println("Stages déjà encodés : " + Activite.ActivitiesCreated);
                        ctrl.getActivitiesList();
                        break;
                    case 3:
                        System.out.println("***" + choix[2] + "***");
                        System.out.println("Voici les stages déjà encodés :");
                        ctrl.getActivitiesList();
                        System.out.println("Quel est le numéro du stage que vous voulez retirer ?");
                        number = scan.nextInt();
                        ctrl.removeActivity(number);
                        break;
                    case 4:
                        System.out.println("A venir");
                        break;
                }
            } else {
                System.out.println("Choix impossible");
            }
            menuActivite(choix);
            input = scan.nextInt();
        }
        System.out.println("Retour au menu des gestionnaires");

    }

    private static void menuActivite(String[] choix) {
        System.out.println();
        System.out.println("***Menu des activités***");
        System.out.println("Que souhaitez-vous faire ?");
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
