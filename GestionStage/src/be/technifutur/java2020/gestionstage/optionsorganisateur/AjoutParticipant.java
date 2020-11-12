package be.technifutur.java2020.gestionstage.optionsorganisateur;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.participants.ListeParticipants;
import be.technifutur.java2020.gestionstage.participants.Participant;
import be.technifutur.java2020.gestionstage.stages.ListeStage;
import be.technifutur.java2020.gestionstage.stages.Stage;

import java.util.Scanner;

public class AjoutParticipant {

    private FonctionsUtiles util;
    private ConsulterStage consultstg;
    private ListeStage listes;
    private ListeParticipants listep;

    public void newMember() {
        Participant p = new Participant();
        Stage s;
        char r = ' ';
        boolean ok = true;
        boolean stop;
        String data;
        Scanner scan = new Scanner(System.in);

        System.out.println("Le participant existe t'il déjà dans la liste des participants ?");
        System.out.println("Tapez O pour oui, N (ou autre caractère) pour non, q/Q pour quitter et revenir au menu des stages");
        data = scan.nextLine();
        stop = util.veutQuitter(data);
        if (!stop){
            r = Character.toUpperCase(data.charAt(0));
            if(r == 'O'){
                System.out.println("Voici la liste des participants :");
                System.out.println(listep.getListeParticipants());
                System.out.println("Insérez le nom du participant que vous voulez récupérer :");
                data = scan.nextLine().trim();
                while (util.vide(data)){
                    System.out.println("Le nom ne peut être vide. Recommencez :");
                    data = scan.nextLine();
                }
                p.setNom(data);
                System.out.println("Insérez le prénom du participant que vous voulez récupérer :");
                data = scan.nextLine().trim();
                while (util.vide(data)){
                    System.out.println("Le prénom ne peut être vide. Recommencez :");
                    data = scan.nextLine();
                }
                p.setPrenom(data);
                p = listep.getMember(p);
                if (p == null){
                    System.out.println("Le participant n'a pas été trouvé. Avez-vous fait une erreur dans le nom ou le prénom ?");
                    ok = false;
                }
            } else {
                System.out.println("Création d'un nouveau participant");
                System.out.println("Insérez le nom du participant :");
                data = scan.nextLine().trim();
                while (util.vide(data)){
                    System.out.println("Le nom ne peut être vide. Recommencez :");
                    data = scan.nextLine();
                }
                p.setNom(data);
                System.out.println("Insérez le prénom du participant :");
                data = scan.nextLine().trim();
                while (util.vide(data)){
                    System.out.println("Le prénom ne peut être vide. Recommencez :");
                    data = scan.nextLine();
                }
                p.setPrenom(data);
            }
            if (ok){
                System.out.println("Voici la liste des stages :");
                consultstg.getList();
                System.out.println("Insérez le numéro du stage auquel vous voulez ajouter ce participant");
                int key = scan.nextInt();
                s = listes.getStage(key);
                ok = listep.verifMember(s,p);
                listep.addMember(ok, s, p);
                util.sauvegardeListeStage(listes);
                util.sauvegardeListeParticipants(listep);
            }
        } else {
            System.out.println("Retour au menu des stages");
        }
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }

    public void setConsulterStage(ConsulterStage consulterStage) {
        this.consultstg = consulterStage;
    }

    public void setListeStage(ListeStage listeStage) {
        this.listes = listeStage;
    }

    public void setListeParticipants(ListeParticipants listeParticipants) {
        this.listep = listeParticipants;
    }
}
