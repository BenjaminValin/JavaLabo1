package be.technifutur.java2020.gestionstage.menusroles;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.activites.ActiviteCtrl;
import be.technifutur.java2020.gestionstage.optionsorganisateur.AjoutActivite;
import be.technifutur.java2020.gestionstage.optionsorganisateur.ConsulterStage;
import be.technifutur.java2020.gestionstage.optionsorganisateur.CreerStage;
import be.technifutur.java2020.gestionstage.optionsorganisateur.SupprimerStage;
import be.technifutur.java2020.gestionstage.stages.ListeStage;
import be.technifutur.java2020.gestionstage.stages.StageCtrl;

import java.util.Scanner;

public class Organisateur implements Gestionnaires {

    private StageCtrl ctrls;
    private ActiviteCtrl ctrla;
    private FonctionsUtiles util;
    private ListeStage listes;
    private CreerStage createstg;
    private ConsulterStage consultstg;
    private SupprimerStage deletestg;
    private AjoutActivite ajact;

    @Override
    public String getName() {
        String name = "Organisateur";
        return name;
    }

    public void menu() {
        String[] menu = new String[]{"Création de stage", "Consultation de stage", "Suppression de stage", "Ajout d'une activité à un stage", "Ajout d'un participant à un stage", "Sauvegarder la liste des stages", "Charger une liste de stages déjà encodée", "Afficher tous les participants aux stages", "Fonction à venir"};
        Scanner scan = new Scanner(System.in);
        int input, number;
        menuStage(menu);

        input = util.saisieNombre();

        while (input != 0) {
            if (input < (menu.length) && input >= 1) {
                int choice = input - 1;
                switch (input) {
                    case 1:
                        System.out.println("***" + menu[choice] + "***");
                        ctrls.newStage();
                        break;
                    case 2:
                        System.out.println("***" + menu[choice] + "***");
                        ctrls.getList();
                        break;
                    case 3:
                        System.out.println("***" + menu[choice] + "***");
                        System.out.println("Stages déjà encodés : " + listes.getStagesCreated() + "\n");
                        ctrls.getList();
                        System.out.println("Quel est le numéro du stage que vous voulez retirer ?");
                        number = scan.nextInt();
                        ctrls.remove(number);
                        break;
                    case 4:
                        System.out.println("***" + menu[choice] + "***");
                        Activite newact = ctrla.add();
                        ctrls.addActivity(newact);
                        break;
                    case 5:
                        System.out.println("***" + menu[choice] + "***");
                        ctrls.newMember();
                        break;
                    case 6:
                        System.out.println("***" + menu[choice] + "***");
                        ctrls.save();
                        break;
                    case 7:
                        System.out.println("***" + menu[choice] + "***");
                        ctrls.load();
                        break;
                    case 8:
                        System.out.println("***" + menu[choice] + "***");
                        System.out.println(ctrls.getListeParticipants());
                        break;
                }
            } else {
                System.out.println("Choix impossible");
            }
            menuStage(menu);
            input = util.saisieNombre();
        }
        System.out.println("Retour au menu principal");

    }

    private static void menuStage(String[] menu) {
        System.out.println();
        System.out.println("***Menu des organisateurs***");
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

    public void setStageCtrl(StageCtrl stageCtrl) {
        this.ctrls = stageCtrl;
    }

    public void setActiviteCtrl(ActiviteCtrl activiteCtrl) {
        this.ctrla = activiteCtrl;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }

    public void setCreerStage(CreerStage creerStage) {
        this.createstg = creerStage;
    }

    public void setConsulterStage(ConsulterStage consulterStage) {
        this.consultstg = consulterStage;
    }

    public void setSupprimerStage(SupprimerStage supprimerStage) {
        this.deletestg = supprimerStage;
    }

    public void setAjoutActivite(AjoutActivite ajoutActivite) {
        this.ajact = ajoutActivite;
    }
}
