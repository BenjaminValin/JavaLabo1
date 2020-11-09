package be.technifutur.java2020.gestionstage.stages;

import java.util.Scanner;

public class StageVue {

    public String saisirTexte(){
        String consigne = new Scanner(System.in).nextLine();
        return consigne;
    }

    public int saisirNombre(){
        int nombre = new Scanner(System.in).nextInt();
        return nombre;
    }
}
