package be.technifutur.java2020.gestionstage.menusroles;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.optionsorganisateur.*;
import be.technifutur.java2020.gestionstage.donnees.ListeStage;

public class Organisateur implements Gestionnaires {

    private FonctionsUtiles util;
    private ListeStage listes;
    private CreerStage createstg;
    private ConsulterStage consultstg;
    private SupprimerStage deletestg;
    private AjoutActivite addact;
    private AjoutParticipant ajpart;

    @Override
    public String getName() {
        String name = "Organisateur";
        return name;
    }

    public void menu() {
        String[] menu = new String[]{"Création de stage", "Consultation de stage", "Suppression de stage", "Ajout d'une activité à un stage", "Ajout d'un participant à un stage", "Sauvegarder la liste des stages (plus utile désormais, sauvegarde auto ajoutée)", "Fonctionnalité à venir"};
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
                        deletestg.remove();
                        break;
                    case 4:
                        System.out.println("***" + menu[choice] + "***");
                        addact.addActivity(addact.add());
                        break;
                    case 5:
                        System.out.println("***" + menu[choice] + "***");
                        ajpart.newMember();
                        break;
                    case 6:
                        System.out.println("***" + menu[choice] + "***");
                        util.sauvegardeListeStage(this.listes);
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
        this.addact = ajoutActivite;
    }

    public void setAjoutParticipant(AjoutParticipant ajoutParticipant) {
        this.ajpart = ajoutParticipant;
    }

}
