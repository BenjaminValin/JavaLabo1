package be.technifutur.java2020.gestionstage.optionstresorier;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.donnees.*;
import be.technifutur.java2020.gestionstage.tarifs.*;

import java.util.Scanner;

public class AffecterTarif {

    private ListeStage listes;
    private FonctionsUtiles util;

    Tarif[] prix = new Tarif[]{
            new TarifDeBase(), new TarifEnfant(), new TarifSocial()
    };

    public void givePrice(){

        System.out.println("Voici la liste des stages :");
        listes.getList();
        System.out.println("Dans quel stage se trouve l'activité voulue ?");
        int choix = util.saisieNombre();
        Stage s = listes.getStage(choix);
        System.out.println("Insérez le nom de l'activité voulue :");
        Activite a = s.getActivity(util.saisieDonneeNonVide());
        System.out.println("Voulez-vous affecter toute la gamme de tarifs à cette activité, choisir les tarifs à affecter parmi la totalité, ou ajouter un seul tarif ?");
        System.out.println("Tapez 1 pour affecter tous les tarifs, 2 pour choisir les tarifs adaptés, 3 pour un ajout unique :");
        choix = util.saisieNombre();
        while(choix < 1 || choix > 3){
            System.out.println("Erreur dans le choix.");
            System.out.println("Tapez 1 pour affecter tous les tarifs, 2 pour choisir les tarifs adaptés, 3 pour un ajout unique :");
            choix = util.saisieNombre();
        }
        switch (choix) {
            case 1:
                giveAllPrices(a);
                break;
            case 2:
                giveSpecificPrice(a);
                break;
            case 3:
                giveUniquePrice(a);
                break;
        }
    };

    public void giveAllPrices(Activite a) {

        int i = 0;

        while (i < prix.length){
            a.putPrice(prix[i].getName(),prix[i].tarif(a));
            i++;
        }
        System.out.println("Tarifs ajoutés");
    }

    public void giveSpecificPrice(Activite a) {

        int i = 0;
        Scanner scan = new Scanner(System.in);

        while (i < prix.length){
            System.out.println(prix[i].getName());
            System.out.println("Voulez-vous affecter ce tarif ? Tapez O pour oui, N (ou autre caractère) pour non");
            char r = Character.toUpperCase(scan.nextLine().charAt(0));
            if (r == 'O'){
                System.out.println("Tarif ajouté");
                a.putPrice(prix[i].getName(),prix[i].tarif(a));
            } else {
                System.out.println("Tarif ignoré");
            }
            i++;
        }
    }

    public void giveUniquePrice(Activite a) {

        int i = 0;

        System.out.println("Voici la liste des tarifs :");
        while (i < prix.length){
            System.out.println((i+1) + ") " + prix[i].getName());
            i++;
        }
        System.out.println("Insérez le numéro placé devant le tarif que vous voulez ajouter :");
        i = util.saisieNombre();
        i = i-1;
        while(i<0 || i>prix.length){
            System.out.println("Ce choix n'est pas possible. Recommencez :");
            System.out.println("Insérez le numéro placé devant le tarif que vous voulez ajouter :");
            i = util.saisieNombre();
            i = i-1;
        }
        a.putPrice(prix[i].getName(),prix[i].tarif(a));
        System.out.println("Tarif ajouté");
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }
}
