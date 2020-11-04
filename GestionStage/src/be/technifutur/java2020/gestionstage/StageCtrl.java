package be.technifutur.java2020.gestionstage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StageCtrl {

    static Map<Integer, Stage> listeStages = new HashMap<>();
    Stage stage = new Stage();


    public void addStage() {
        String data;
        boolean datesOK = false;
        LocalDateTime dateDebut = null;
        LocalDateTime dateFin = null;
        String affichageDate = "d/MM/yyyy HH:mm";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(affichageDate);

        System.out.println("Insérez le nom du stage :");
        data = new Scanner(System.in).nextLine();
        stage.setNomStage(data);

        while(!datesOK){
            System.out.println("Création de la date de début du stage :");
            System.out.println("Insérez la date (format JJ/MM/AAAA HH:MM)");
            data = new Scanner(System.in).nextLine();
            Pattern p = Pattern.compile("(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9][0-9][0-9][0-9]) ([0-1][0-9]|2[0-3]):([0-5][0-9])");
            Matcher m = p.matcher(data);
            boolean ok = m.matches();
            while(!ok){
                System.out.println("Erreur dans la date entrée. Merci de recommencer :");
                data = new Scanner(System.in).nextLine();
                m = p.matcher(data);
                ok = m.matches();
            }
            dateDebut = LocalDateTime.parse(data,format);
            System.out.println("Création de la date de fin du stage :");
            System.out.println("Insérez la date (format JJ/MM/AAAA HH:MM)");
            data = new Scanner(System.in).nextLine();
            m = p.matcher(data);
            ok = m.matches();
            while(!ok){
                System.out.println("Erreur dans la date entrée. Merci de recommencer :");
                data = new Scanner(System.in).nextLine();
                m = p.matcher(data);
                ok = m.matches();
            }
            dateFin = LocalDateTime.parse(data,format);
            if (dateDebut.compareTo(dateFin) > 0) {
                System.out.println("La date de fin arrive avant la date de début. Veuillez recommencer :");
            } else if (dateDebut.compareTo(dateFin) == 0) {
                System.out.println("Les deux dates sont exactement les mêmes. Veuillez recommencer :");
            } else {
                System.out.println("Ajout validé !");
                datesOK = true;
            }
            stage.setDateDebut(dateDebut);
            stage.setDateFin(dateFin);
            Stage.stagesCrees++;
            listeStages.put(Stage.stagesCrees,stage);
        }
    }

}
