package be.technifutur.java2020.gestionstage.menusorganisateur;

import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.activites.ActiviteCtrl;

import java.util.Scanner;

public class MenuActivite implements MenusOrga {

    private ActiviteCtrl ctrl;

    @Override
    public String getName() {
        String name = "Menu des activités";
        return name;
    }

    public void menu() {
        String[] choix = new String[]{"Création d'activité", "Consultation des activités", "Suppression d'une activité", "Modification d'une activité (a venir)"};
        Scanner scan = new Scanner(System.in);
        int input, number;
        menuActivite(choix);

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
                        System.out.println("Activités déjà encodées : " + Activite.ActivitiesCreated);
                        ctrl.getList();
                        break;
                    case 3:
                        System.out.println("***" + choix[2] + "***");
                        System.out.println("Voici les activités déjà encodées :");
                        ctrl.getList();
                        System.out.println("Quel est le numéro de l'activité que vous voulez retirer ?");
                        number = scan.nextInt();
                        ctrl.remove(number);
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
        System.out.println("Retour au menu des organisateurs");

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

    public void setActiviteCtrl(ActiviteCtrl activiteCtrl) {
        this.ctrl = activiteCtrl;
    }
}
