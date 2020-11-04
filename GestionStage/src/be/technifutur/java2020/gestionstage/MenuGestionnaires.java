package be.technifutur.java2020.gestionstage;

import java.util.Scanner;

public class MenuGestionnaires {

    public void start(){

        Gestionnaires[] menu = new Gestionnaires[]{
                new Organisateur(), new Tresorier(), new Secretaire(), new Stagiaire()
        };
        Scanner scan = new Scanner(System.in);
        int input;
        menuChoixParticipant(menu);

        input = scan.nextInt();
        while (input != 0) {
            int choice = input;
            if (choice < (menu.length) && choice >= 1) {
                switch (choice) {
                    case 1:
                        Organisateur orga = new Organisateur();
                        System.out.println("Entrée dans le menu des organisateurs :");
                        orga.menu();
                        break;
                    case 2:
                        System.out.println("Fonctionnalité à venir, soyez patients ;)");
                        break;
                    case 3:
                        System.out.println("Fonctionnalité à venir, soyez patients ;)");
                        break;
                    case 4:
                        System.out.println("Fonctionnalité à venir, soyez patients ;)");
                        break;
                }
            } else {
                System.out.println("Choix impossible");
            }
            menuChoixParticipant(menu);
            input = scan.nextInt();
        }
        System.out.println("Bonne journée !");
    }

    private static void menuChoixParticipant(Gestionnaires[] menu) {
        System.out.println();
        System.out.println("***Menu des gestionnaires***");
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
}
