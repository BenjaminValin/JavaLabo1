package be.technifutur.java2020.gestionstage;

import java.util.Scanner;

public class MenuGestionnaires {

    public void start(){

        Gestionnaires[] menu = new Gestionnaires[]{
                new Organisateur()
        };
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        menuChoixParticipant(menu);


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
