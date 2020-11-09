package be.technifutur.java2020.gestionstage.stages;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.activites.Activite;
import be.technifutur.java2020.gestionstage.participants.Participant;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class ListeStage implements Serializable {

    private Map<Integer, Stage> listeStages = new HashMap<>();
    public int StagesCreated = 0;


    public void add(String data, LocalDateTime dateDebut, LocalDateTime dateFin) {

        Stage stage = new Stage();
        stage.setNomStage(data);
        stage.setDateDebut(dateDebut);
        stage.setDateFin(dateFin);
        this.StagesCreated++;
        listeStages.put(this.StagesCreated,stage);

    }

    public void consult(int key){
        Stage consult;
        consult = listeStages.get(key);
        System.out.println(consult.toString());
    }

    public void remove(int key){
        listeStages.remove(key);
    }

    public void getList(){
        int i = 1;
        for(Map.Entry map : listeStages.entrySet()){
            System.out.println("Stage " + i + " : " + map.getValue());
            i++;
        }
    }

    public Stage getStage(int i){
        Stage stage = listeStages.get(i);
        return stage;
    }

    public int getStagesCreated() {
        return StagesCreated;
    }

    public boolean addLink(int input1, Activite act) {

        Activite verif = act;
        Stage modif = listeStages.get(input1);
        Set<Activite> test = modif.getActivitesDuStage();
        boolean add = true;
        String message = null;
        LocalDateTime dateFinAct = act.getDateDebut();
        Long minstage = (long) act.getDureeActivite();
        dateFinAct = dateFinAct.plusMinutes(minstage);

        if (verif.getDateDebut().isBefore(modif.getDateDebut()) || verif.getDateDebut().isAfter(modif.getDateFin())){
            add = false;
            message = "La date de l'activité ne correspond pas aux dates du stage";
        }

        if (dateFinAct.isAfter(modif.getDateFin())){
            add = false;
            message = "L'activité prend fin après la fin du stage";
        }

        //TODO : Corriger le foreach et le transformer en while
        for(Activite a : test){
            if (a.equals(verif)){
                add = false;
                message = "Cette activité ne peut pas être ajoutée dans le stage, car elle s'y trouve déjà";
            }
        }

        if (add){
            message = "Activité ajoutée avec succès !";
            modif.getActivitesDuStage().add(verif);
        }

        System.out.println(message);
        return add;
    }

    public void addMember(Boolean add, Stage s, Participant part) {

        FonctionsUtiles util = new FonctionsUtiles();
        char r = ' ';

        if (add){
            System.out.println("Le participant a t'il un club ? Tapez O pour oui, N (ou un autre caractère) pour non :");
            r = new Scanner(System.in).nextLine().charAt(0);
            if (r == 'O' || r == 'o'){
                System.out.println("Insérez le nom du club du participant :");
                String club = new Scanner(System.in).nextLine();
                part.setNomClub(club);
            }
            System.out.println("Le participant a t'il une adresse mail ? Tapez O pour oui, N (ou un autre caractère) pour non :");
            r = new Scanner(System.in).nextLine().charAt(0);
            if (r == 'O' || r == 'o'){
                System.out.println("Insérez l'adresse mail du participant :");
                String club = new Scanner(System.in).nextLine();
                part.setMail(club);
            }
            System.out.println("Participant ajoutée avec succès !");
            s.getParticipantsAuStage().add(part);
        } else {
            Participant doublon = getMember(s, part);
            System.out.println("Voulez-vous néanmoins modifier son club/son mail ? Tapez O pour oui, N (ou un autre caractère) pour non :");
            r = new Scanner(System.in).nextLine().charAt(0);
            if (r == 'O' || r == 'o') {
                System.out.println("Voulez-vous modifier son club ? Tapez O pour oui, N (ou un autre caractère) pour non :");
                r = new Scanner(System.in).nextLine().charAt(0);
                if (r == 'O' || r == 'o') {
                    System.out.println("Insérez le nom du club du participant :");
                    String club = new Scanner(System.in).nextLine();
                    part.setNomClub(club);
                } else {
                    part.setNomClub(doublon.getNomClub());
                }
                System.out.println("Voulez-vous modifier son adresse mail ? Tapez O pour oui, N (ou un autre caractère) pour non :");
                r = new Scanner(System.in).nextLine().charAt(0);
                if (r == 'O' || r == 'o') {
                    System.out.println("Insérez l'adresse mail du participant :");
                    String mail = util.saisieMail();
                    part.setMail(mail);
                } else {
                    part.setMail(doublon.getMail());
                }
                s.getParticipantsAuStage().remove(doublon);
                s.getParticipantsAuStage().add(part);
            }
        }
    }

    public boolean verifMember(Stage s, Participant participant) {
        Participant part = participant;
        Stage modif = s;
        Set<Participant> test = modif.getParticipantsAuStage();
        boolean verif = true;

        for (Participant p : test) {
            if (p.equals(part)) {
                verif = false;
                System.out.println("Ce participant ne peut pas être inclus dans le stage, car il s'y trouve déjà");
            }
        }

        return verif;
    }

    public Participant getMember(Stage s, Participant participant) {
        Participant part = participant;
        Participant pDoublon = null;
        Stage modif = s;
        Set<Participant> test = modif.getParticipantsAuStage();
        boolean verif = true;

        for (Participant p : test) {
            if (p.equals(part)) {
                verif = false;
                pDoublon = p;
            }
        }

        return pDoublon;
    }
}
