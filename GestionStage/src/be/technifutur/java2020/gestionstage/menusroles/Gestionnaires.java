package be.technifutur.java2020.gestionstage.menusroles;

import java.io.FileNotFoundException;

public interface Gestionnaires {

    public String getName();

    public abstract void menu() throws FileNotFoundException;
}
