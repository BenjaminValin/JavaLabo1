package be.technifutur.java2020.gestionstage.activites;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ActiviteCtrl {

    ListeActivite liste = new ListeActivite();
    FonctionsUtiles util = new FonctionsUtiles();

    public void add() {

        LocalDateTime dateDebut;
        int duree;

        System.out.println("Insérez le nom de l'activité :");
        String data = new Scanner(System.in).nextLine();
        System.out.println("Création de la date de début de l'activité :");
        dateDebut = util.saisieDate();
        System.out.println("Insérez la durée de l'activité (en minutes) :");
        duree = new Scanner(System.in).nextInt();
        while (duree<=0){
            System.out.println("L'activité doit au moins durer une minute... Recommencez");
            duree = new Scanner(System.in).nextInt();
        }
        liste.add(data, dateDebut, duree);
    }

    public void consult(int key) {
        liste.consult(key);
    }

    public void remove(int key) {
        liste.remove(key);
    }

    public void getList() {
        liste.getList();
    }

    public void setListeActivites(ListeActivite listeActivite) {
        this.liste = listeActivite;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }
}
