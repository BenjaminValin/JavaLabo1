package be.technifutur.java2020.gestionstage.tarifs;

import be.technifutur.java2020.gestionstage.donnees.Activite;

public interface Tarif {

    String getName();

    double tarif(Activite a);

}
