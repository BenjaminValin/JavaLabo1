package be.technifutur.java2020.gestionstage.menusroles;

public class Stagiaire implements Gestionnaires {

    private String name = "Stagiaire";

    @Override
    public String getName() {
        return name;
    }
}
