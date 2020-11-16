package be.technifutur.java2020.gestionstage.tarifs;

import be.technifutur.java2020.gestionstage.donnees.Activite;

import java.util.Set;

public class TarifStaff implements Tarif {

    @Override
    public String getName() {
        return "Tarif staff";
    }

    @Override
    public double tarif(Set<Activite> a) {
        double coutHoraireBase = (-10);
        double coutActivite;
        double heuresActivite = 0.0;

        for (Activite ac : a) {
            heuresActivite = heuresActivite + ac.getDureeActivite();
        }
        heuresActivite = heuresActivite/60;
        coutActivite = heuresActivite*coutHoraireBase;
        return coutActivite;
    }
}
