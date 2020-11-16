package be.technifutur.java2020.gestionstage.optionsorganisateur;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.donnees.*;

import java.util.Set;

public class SupprimerActivite {

    private FonctionsUtiles util;
    private ListeStage listes;

    public void deleteActivity(){
        Stage stage;
        Activite a = new Activite();
        System.out.println("Voici les stages existants, avec leurs activités et participants");
        listes.getList();
        System.out.println("Quel est le numéro du stage dans lequel l'activité se trouve ?");
        int number = util.saisieNombre();
        stage = listes.getStage(number);

        System.out.println("Entrez le nom de l'activité que vous voulez supprimer :");
        String data = util.saisieDonneeNonVide();
        a.setNomActivite(data);
        if(!stage.verifActivity(a)){
            System.out.println("Cette activité n'est pas présente dans le stage choisi");
        } else {
            a = stage.getActivity(a);
            stage.removeActivity(a);
            Set<Participation> partdustage = stage.getParticipationsAuStage();
            for(Participation p : partdustage){
                Set<Activite> actduparticip = p.getActivitesSuivies();
                for(Activite act : actduparticip){
                    if(act.equals(a)){
                        actduparticip.remove(act);
                    }
                }
            }
            System.out.println("Activitée supprimée ! Cette activité a également été supprimée des participants au stage qui l'avaient sélectionnée");
            util.sauvegardeListeStage(listes);
        }
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }
}
