package be.technifutur.java2020.gestionstage.tarifs;

import be.technifutur.java2020.gestionstage.donnees.Activite;

import java.util.Set;

public interface Tarif {

    String getName();

    double tarif(Set<Activite> a);

}
