package be.technifutur.java2020.gestionstage.menusorganisateur;

import be.technifutur.java2020.gestionstage.stages.Stage;

import java.util.Scanner;

public class MenuLiaisonsStagesActivites implements MenusOrga {
    @Override
    public String getName() {
        String name = "Menu des liaisons stages-activités";
        return name;
    }

    @Override
    public void menu() {
        String[] choix = new String[]{"Création de liaison", "Suppression de liaison"};
        Scanner scan = new Scanner(System.in);

        int input, number;
        menuStage(choix);

        input = scan.nextInt();
        while (input != 0) {
            int choice = input;
            if (choice < (choix.length) && choice >= 1) {
                switch (choice) {
                    case 1:
                        System.out.println("***" + choix[0] + "***");

                        break;
                    case 2:
                        System.out.println("***" + choix[1] + "***");
                        System.out.println("Liaisons existantes : " + Stage.StagesCreated);
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
        System.out.println("***Menu des liaisons stages-activités***");
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
