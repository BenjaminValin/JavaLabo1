package be.technifutur.java2020.gestionstage.menusroles;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.optionsorganisateur.*;

public class Organisateur implements Gestionnaires {

    private FonctionsUtiles util;
    private CreerStage createstg;
    private ConsulterStage consultstg;
    private SupprimerStage deletestg;
    private AjoutActivite addact;
    private SupprimerActivite suppract;
    private AjoutParticipant ajpart;
    private SupprimerParticipant supprpart;

    @Override
    public String getName() {
        return "Organisateur";
    }

    public void menu() {
        String[] menu = new String[]{"Création de stage", "Consultation de stage", "Suppression de stage", "Ajout d'une activité à un stage", "Supprimer une activité d'un stage", "Ajout d'un participant à un stage", "Supprimer le participant d'un stage", "Fonctionnalité à venir"};
        int input;
        menuStage(menu);

        input = util.saisieNombre();

        while (input != 0) {
            if (input < (menu.length) && input >= 1) {
                int choice = input - 1;
                switch (input) {
                    case 1:
                        System.out.println("***" + menu[choice] + "***");
                        createstg.newStage();
                        break;
                    case 2:
                        System.out.println("***" + menu[choice] + "***");
                        consultstg.getList();
                        break;
                    case 3:
                        System.out.println("***" + menu[choice] + "***");
                        deletestg.remove();
                        break;
                    case 4:
                        System.out.println("***" + menu[choice] + "***");
                        addact.addActivity(addact.add());
                        break;
                    case 5:
                        System.out.println("***" + menu[choice] + "***");
                        suppract.deleteActivity();
                        break;
                    case 6:
                        System.out.println("***" + menu[choice] + "***");
                        ajpart.newMember();
                        break;
                    case 7:
                        System.out.println("***" + menu[choice] + "***");
                        supprpart.deleteMember();
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

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
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
        this.addact = ajoutActivite;
    }

    public void setAjoutParticipant(AjoutParticipant ajoutParticipant) {
        this.ajpart = ajoutParticipant;
    }

    public void setSupprimerActivite(SupprimerActivite supprimerActivite) {
        this.suppract = supprimerActivite;
    }

    public void setSupprimerParticipant(SupprimerParticipant supprimerParticipant) {
        this.supprpart = supprimerParticipant;
    }
}
