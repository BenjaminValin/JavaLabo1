package be.technifutur.java2020.gestionstage.optionstresorier;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.comparaisons.CompareNomsParticipations;
import be.technifutur.java2020.gestionstage.donnees.ListeStage;
import be.technifutur.java2020.gestionstage.donnees.Participation;
import be.technifutur.java2020.gestionstage.donnees.Stage;

import java.util.Set;
import java.util.TreeSet;

public class VoirRecettesStage {

    private ListeStage listes;
    private FonctionsUtiles util;

    public void getMoney() {

        Stage s;
        Set<Participation> particip;
        Participation p = new Participation();
        double couttotal = 0.0;

        System.out.println("Voici la liste des stages :");
        listes.getList();
        System.out.println("De quel stage voulez-vous voir les recettes actuelles ?");
        int choix = util.saisieNombre();
        s = listes.getStage(choix);
        particip = s.getParticipationsAuStage();

        for (Participation pa : particip){
            couttotal = couttotal + pa.getTarif().tarif(pa.getActivitesSuivies());
        }

        System.out.println("Les recettes du stage s'élèvent actuellement à " + util.affichePrix(couttotal));

        util.sauvegardeListeStage(listes);
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }
}
