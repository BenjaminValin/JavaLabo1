package be.technifutur.java2020.gestionstage.menusroles;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.optionstresorier.AffecterTarif;
import be.technifutur.java2020.gestionstage.optionstresorier.CreerFactureParticipant;
import be.technifutur.java2020.gestionstage.optionstresorier.VoirFactureParticipant;

public class Tresorier implements Gestionnaires {

    private FonctionsUtiles util;
    private AffecterTarif afftarif;
    private CreerFactureParticipant creafactpart;
    private VoirFactureParticipant voirfactpart;

    @Override
    public String getName() {
        String name = "Trésorier";
        return name;
    }

    @Override
    public void menu() {
        String[] menu = new String[]{"Affecter un tarif à une activité", "Créer une facture pour un participant", "Voir le coût du stage pour un participant", "Fonctionnalité à venir"};
        int input;
        menuTresorier(menu);

        input = util.saisieNombre();

        while (input != 0) {
            if (input < (menu.length) && input >= 1) {
                int choice = input - 1;
                switch (input) {
                    case 1:
                        System.out.println("***" + menu[choice] + "***");
                        afftarif.givePrice();
                        break;
                    case 2:
                        System.out.println("***" + menu[choice] + "***");
                        creafactpart.createBill();
                        break;
                    case 3:
                        System.out.println("***" + menu[choice] + "***");
                        voirfactpart.getBill();
                        break;
                }
            } else {
                System.out.println("Choix impossible");
            }
            menuTresorier(menu);
            input = util.saisieNombre();
        }
        System.out.println("Retour au menu principal");
    }

    private static void menuTresorier(String[] menu) {
        System.out.println();
        System.out.println("***Menu des trésoriers***");
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

    public void setAffecterTarif(AffecterTarif affecterTarif) {
        this.afftarif = affecterTarif;
    }

    public void setCreerFactureParticipant(CreerFactureParticipant creerFactureParticipant) {
        this.creafactpart = creerFactureParticipant;
    }

    public void setVoirFactureParticipant(VoirFactureParticipant voirFactureParticipant) {
        this.voirfactpart = voirFactureParticipant;
    }
}
