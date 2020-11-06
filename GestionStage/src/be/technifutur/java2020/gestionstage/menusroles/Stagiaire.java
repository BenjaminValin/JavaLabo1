package be.technifutur.java2020.gestionstage.menusroles;

import be.technifutur.java2020.gestionstage.menusstagiaires.*;

import java.util.Scanner;

public class Stagiaire implements Gestionnaires {

    private MenuConsult menucslt;

    @Override
    public String getName() {
        String name = "Stagiaire";
        return name;
    }

    @Override
    public void menu() {
        MenusStagiaires[] menu = new MenusStagiaires[]{
                menucslt, new MenuConsult()//A supprimer plus tard
        };
        Scanner scan = new Scanner(System.in);
        int input;
        menuStagiaire(menu);

        input = scan.nextInt();

        while (input != 0) {
            if (input < (menu.length) && input >= 1) {
                int choice = input-1;
                switch (input) {
                    case 1:
                        System.out.println("Entrée dans le menu de consultation :");
                        menu[choice].menu();
                        break;
                }
            } else {
                System.out.println("Choix impossible");
            }
            menuStagiaire(menu);

            input = scan.nextInt();

        }
        System.out.println("Retour au menu des gestionnaires");


    }

    private static void menuStagiaire(MenusStagiaires[] menu) {
        System.out.println();
        System.out.println("***Menu des stagiaires***");
        System.out.println("A quel sous-menu souhaitez-vous accéder ?");
        System.out.println("Entrez le nombre correspondant au choix souhaité : ");
        System.out.println();
        for (int i = 0; i < menu.length; i++) {
            System.out.printf(" - %d : %s%n", i + 1, menu[i].getName());
        }
        System.out.printf(" - %s : %s%n", "0", "Quitter");
        System.out.println();
        System.out.print("Faites votre choix : ");
    }

    public void setMenuConsult(MenuConsult menuConsult) {
        this.menucslt = menuConsult;
    }
}
