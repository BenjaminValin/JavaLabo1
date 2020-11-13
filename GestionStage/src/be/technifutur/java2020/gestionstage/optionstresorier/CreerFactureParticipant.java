package be.technifutur.java2020.gestionstage.optionstresorier;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.donnees.*;

import java.util.Map;
import java.util.Set;

public class CreerFactureParticipant {

    private ListeStage listes;
    private FonctionsUtiles util;

    public void createBill() {

        Stage s;
        Participant p = new Participant();
        Set<Activite> actPart;
        Set<Activite> actStage;
        boolean test;

        System.out.println("Voici la liste des stages :");
        listes.getList();
        System.out.println("Dans quel stage se trouve le participant voulu ?");
        int choix = util.saisieNombre();
        s = listes.getStage(choix);

        System.out.println("Insérez le nom du participant :");
        p.setNom(util.saisieDonneeNonVide());
        System.out.println("Insérez le prénom du participant :");
        p.setPrenom(util.saisieDonneeNonVide());

        if(!s.verifMember(p)){
            System.out.println("Ce participant n'a pas été trouvé dans ce stage.");
        } else {
            p = s.getMember(p);
            actPart = p.getActivitesSuivies();
            actStage = s.getActivitesDuStage();

            for (Activite a : actPart) {
                for (Activite a2 : actStage) {
                    if(a.getNomActivite().equals(a2.getNomActivite()));{
                        Map<String, Double> tarifs = a.getAllTarifs();
                        System.out.println(a.getNomActivite());
                        System.out.println("Quel tarif appliquer au participant ?");
                        for(Map.Entry m : tarifs.entrySet()){
                            System.out.println(m);
                        }
                        System.out.println("Insérez le nom exact du tarif :");
                        String data = util.saisieDonneeNonVide();
                        test = a.verifTarif(data);
                        while (!test){
                            System.out.println("Ce tarif n'a pas été trouvé.");
                            System.out.println("Insérez le nom exact du tarif :");
                            data = util.saisieDonneeNonVide();
                            test = a.verifTarif(data);
                        }
                        double prix = tarifs.get(data);
                        data = a.getNomActivite() + " : " + data;
                        p.getFacture().put(data, prix);
                    }
                }
            }
            util.sauvegardeListeStage(listes);
        }
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

}
