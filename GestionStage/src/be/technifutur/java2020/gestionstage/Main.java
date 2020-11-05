package be.technifutur.java2020.gestionstage;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Bienvenue dans le gestionnaire de stages");
        Factory factory = new Factory();
        MenuPrincipal menu = factory.getMenu();
        factory = null;
        menu.start();
    }
}
