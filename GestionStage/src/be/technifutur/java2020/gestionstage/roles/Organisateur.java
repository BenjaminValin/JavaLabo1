package be.technifutur.java2020.gestionstage.roles;

import be.technifutur.java2020.gestionstage.ListeStage;
import be.technifutur.java2020.gestionstage.Stage;
import be.technifutur.java2020.gestionstage.StageCtrl;

import java.util.Scanner;

public class Organisateur implements Gestionnaires {

    @Override
    public String getName() {
        String name = "Organisateur";
        return name;
    }

    public void menu() {
        String[] choix = new String[]{"Création de stage", "Consultation de stage", "Suppression de stage", "Modification de stage (a venir)"};
        Scanner scan = new Scanner(System.in);
        StageCtrl ctrl = new StageCtrl();
        ListeStage liste = new ListeStage();
        int input, number;
        menuOrganisateur(choix);

        input = scan.nextInt();
        while (input != 0) {
            int choice = input;
            if (choice < (choix.length) && choice >= 1) {
                switch (choice) {
                    case 1:
                        System.out.println("***" + choix[0] + "***");
                        ctrl.addStage();
                        break;
                    case 2:
                        System.out.println("***" + choix[1] + "***");
                        System.out.println("Stages déjà encodés : " + Stage.stagesCrees);
                        System.out.println("Quel stage voulez-vous consulter ?");
                        System.out.println("Insérez le numéro du stage :");
                        number = scan.nextInt();
                        liste.consultStage(number);
                        break;
                    case 3:
                        System.out.println("***" + choix[2] + "***");
                        System.out.println("Voici les stages déjà encodés :");
                        liste.getListeStages();
                        System.out.println("Quel est le numéro du stage que vous voulez retirer ?");
                        number = scan.nextInt();
                        liste.removeStage(number);
                        break;
                    case 4:
                        System.out.println("A venir");
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
