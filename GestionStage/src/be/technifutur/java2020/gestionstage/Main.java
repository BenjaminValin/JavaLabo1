package be.technifutur.java2020.gestionstage;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bienvenue dans le gestionnaire de stages");
        Factory factory = new Factory();
        MenuPrincipal menu = factory.getMenu();
        factory = null;
        menu.start();
    }
}
