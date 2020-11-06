package be.technifutur.java2020.gestionstage.menusroles;

import be.technifutur.java2020.gestionstage.Test;
import be.technifutur.java2020.gestionstage.menusorganisateur.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Organisateur implements Gestionnaires {

    private MenuStage menustg;

    @Override
    public String getName() {
        String name = "Organisateur";
        return name;
    }

    public void menu() throws FileNotFoundException {
        MenusOrga[] menu = new MenusOrga[]{
                menustg, new MenuStage()//A supprimer plus tard
        };
        Scanner scan = new Scanner(System.in);
        int input;
        menuOrganisateur(menu);

        input = scan.nextInt();
        /*input = Integer.parseInt(Test.Texte());
        System.out.println(input);*/

        while (input != 0) {
            if (input < (menu.length) && input >= 1) {
                int choice = input-1;
                switch (input) {
                    case 1:
                        System.out.println("Entrée dans le menu des stages :");
                        menu[choice].menu();
                        break;
                }
            } else {
                System.out.println("Choix impossible");
            }
            menuOrganisateur(menu);

            input = scan.nextInt();
            /*input = Integer.parseInt(Test.Texte());
            System.out.println(input);*/

        }
        System.out.println("Retour au menu des gestionnaires");

    }

    private static void menuOrganisateur(MenusOrga[] menu) {
        System.out.println();
        System.out.println("***Menu des organisateurs***");
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

    public void setMenuStage(MenuStage menuStage) {
        this.menustg = menuStage;
    }

}
