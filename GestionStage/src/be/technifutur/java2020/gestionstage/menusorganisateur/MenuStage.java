package be.technifutur.java2020.gestionstage.menusorganisateur;

import be.technifutur.java2020.gestionstage.stages.Stage;
import be.technifutur.java2020.gestionstage.stages.StageCtrl;

import java.util.Scanner;

public class MenuStage implements MenusOrga {

    @Override
    public String getName() {
        String name = "Menu des stages";
        return name;
    }

    public void menu() {
        String[] choix = new String[]{"Création de stage", "Consultation de stage", "Suppression de stage", "Modification de stage (a venir)", "Ajout d'une activité à un stage", "Suppression d'une activité d'un stage"};
        Scanner scan = new Scanner(System.in);
        StageCtrl ctrl = new StageCtrl();
        int input, number;
        menuStage(choix);

        input = scan.nextInt();
        while (input != 0) {
            int choice = input;
            if (choice < (choix.length) && choice >= 1) {
                switch (choice) {
                    case 1:
                        System.out.println("***" + choix[0] + "***");
                        ctrl.add();
                        break;
                    case 2:
                        System.out.println("***" + choix[1] + "***");
                        System.out.println("Stages déjà encodés : " + Stage.StagesCreated);
                        ctrl.getList();
                        break;
                    case 3:
                        System.out.println("***" + choix[2] + "***");
                        System.out.println("Voici les stages déjà encodés :");
                        ctrl.getList();
                        System.out.println("Quel est le numéro du stage que vous voulez retirer ?");
                        number = scan.nextInt();
                        ctrl.remove(number);
                        break;
                    case 4:
                        System.out.println("***" + choix[3] + "***");
                        break;
                    case 5:
                        System.out.println("***" + choix[4] + "***");
                        ctrl.addLink();
                        break;
                    case 6:
                        System.out.println("***" + choix[5] + "***");
                        ctrl.deleteLink();
                        break;
                }
            } else {
                System.out.println("Choix impossible");
            }
            menuStage(choix);
            input = scan.nextInt();
        }
        System.out.println("Retour au menu des organisateurs");

    }

    private static void menuStage(String[] menu) {
        System.out.println();
        System.out.println("***Menu des stages***");
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
}
