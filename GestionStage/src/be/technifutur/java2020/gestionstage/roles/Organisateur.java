package be.technifutur.java2020.gestionstage.roles;

import be.technifutur.java2020.gestionstage.Stage;

import java.util.Scanner;

public class Organisateur implements Gestionnaires {

    private String name = "Organisateur";

    @Override
    public String getName() {
        return name;
    }

    public void menu() {
        String[] choix = new String[]{"Création de stage", "Consultation de stage"};
        Scanner scan = new Scanner(System.in);
        int input;
        menuOrganisateur(choix);

        input = scan.nextInt();
        while (input != 0) {
            int choice = input;
            if (choice < (choix.length) && choice >= 1) {
                switch (choice) {
                    case 1:
                        Stage stage = new Stage();
                        System.out.println("Création de stage :");
                        stage.add();
                        break;
                    case 2:
                        System.out.println("Fonctionnalité à venir, soyez patients ;)");
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
