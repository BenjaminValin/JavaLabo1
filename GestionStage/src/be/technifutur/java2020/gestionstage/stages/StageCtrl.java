package be.technifutur.java2020.gestionstage.stages;

import be.technifutur.java2020.gestionstage.FonctionsUtiles;
import be.technifutur.java2020.gestionstage.activites.Activite;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StageCtrl {

    private ListeStage liste;
    private FonctionsUtiles util;

    public void add() {

        Stage stage = new Stage();
        boolean datesOK = false;
        LocalDateTime dateDebut = null;
        LocalDateTime dateFin = null;

        System.out.println("Insérez le nom du stage :");
        String data = new Scanner(System.in).nextLine();

        while(!datesOK){
            System.out.println("Création de la date de début du stage :");
            dateDebut = util.saisieDate();
            System.out.println("Création de la date de fin du stage :");
            dateFin = util.saisieDate();
            if (dateDebut.compareTo(dateFin) > 0) {
                System.out.println("La date de fin arrive avant la date de début. Veuillez recommencer :");
            } else if (dateDebut.compareTo(dateFin) == 0) {
                System.out.println("Les deux dates sont exactement les mêmes. Veuillez recommencer :");
            } else {
                System.out.println("Ajout validé !");
                datesOK = true;
            }
        }
        stage.setNomStage(data);
        stage.setDateDebut(dateDebut);
        stage.setDateFin(dateFin);
        Stage.StagesCreated++;
        Stage.StageKey++;
        ListeStage.listeStages.put(Stage.StagesCreated,stage);
    }

    public void consult(int key) {
        Stage consult;
        consult = ListeStage.listeStages.get(key);
        System.out.println(consult.toString());
    }

    public void remove(int key) {
        ListeStage.listeStages.remove(key);
        Stage.StagesCreated--;
    }

    public void getList() {
        int i = 1;
        for(Map.Entry map : ListeStage.listeStages.entrySet()){
            System.out.println("Stage " + i + " : " + map.getValue());
            i++;
        }
    }

    public void addLink(Activite act) {

        Activite actAdd = act;
        boolean verif = false;

        while (!verif){
            System.out.println("Voici la liste des stages :");
            getList();
            System.out.println("Insérez le numéro du stage auquel vous voulez ajouter une activité");
            int input = new Scanner(System.in).nextInt();
            Stage modif = ListeStage.listeStages.get(input);
            Set<Activite> test = modif.getActivitesDuStage();
            boolean add = true;
            String message = null;
            LocalDateTime dateFinAct = actAdd.getDateDebut();
            Long minstage = (long) actAdd.getDureeActivite();
            dateFinAct = dateFinAct.plusMinutes(minstage);

            System.out.println("Date de début du stage : " + ListeStage.listeStages.get(input).getDateDebut());
            System.out.println("Date de fin du stage : " + ListeStage.listeStages.get(input).getDateFin());
            System.out.println("Date de début de l'activité : " + act.getDateDebut());
            System.out.println("Durée de l'activité : " + minstage);
            System.out.println("Date de fin de l'activité : " + dateFinAct);

            if (actAdd.getDateDebut().isBefore(modif.getDateDebut()) || actAdd.getDateDebut().isAfter(modif.getDateFin())){
                add = false;
                message = "La date de l'activité ne correspond pas aux dates du stage";
            }

            if (dateFinAct.isAfter(modif.getDateFin())){
                add = false;
                message = "L'activité prend fin après la fin du stage";
            }

            //TODO : Corriger le foreach et le transformer en while
            for(Activite a : test){
                if (a == actAdd){
                    add = false;
                    message = "Cette activité ne peut pas être ajoutée dans le stage, car elle s'y trouve déjà";
                }
            }

            if (add){
                message = "Activité ajoutée avec succès !";
                modif.getActivitesDuStage().add(actAdd);
            }

            verif = add;
            System.out.println(message);
        }
    }

    /*public void deleteLink() {} pas encore demandé */

    public void save(){
        File fichier = new File("stagesencodes.stage");
        ListeStage liste = this.liste;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {

            oos.writeObject(liste);
            System.out.println(fichier.exists());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(){
        File fichier = new File("stagesencodes.stage");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {

            ListeStage liste = (ListeStage) ois.readObject();
            this.liste = liste;
            System.out.println(liste);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setListeStage(ListeStage listeStage) {
        this.liste = listeStage;
    }

    public void setFonctionsUtiles(FonctionsUtiles fonctionsUtiles) {
        this.util = fonctionsUtiles;
    }


}
