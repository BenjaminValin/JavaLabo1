package be.technifutur.java2020.gestionstage;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stage {

    private String nomStage;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    public String getNomStage() {
        return nomStage;
    }

    public void setNomStage(String nomStage) {
        this.nomStage = nomStage;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public void add() {
        String data;
        boolean datesOK = false;
        LocalDateTime date;

        System.out.println("Insérez le nom du stage :");
        data = new Scanner(System.in).nextLine();
        setNomStage(data);

        while(!datesOK){
            System.out.println("Création de la date de début du stage :");
            System.out.println("Insérez la date (format YYYY-MM-DDTHH:MM)");
            data = new Scanner(System.in).nextLine();
            Pattern p = Pattern.compile("(20[2-9][0-9])-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])T([0-1][0-9]|2[0-3]):([0-5][0-9])");
            Matcher m = p.matcher(data);
            boolean ok = m.matches();
            while(!ok){
                System.out.println("Erreur dans la date entrée. Merci de recommencer :");
                data = new Scanner(System.in).nextLine();
                m = p.matcher(data);
                ok = m.matches();
            }
            dateDebut.parse(data);
            //this.setDateDebut(creaDate());
            System.out.println("Création de la date de fin du stage :");
            System.out.println("Insérez la date (format YYYY-MM-DDTHH:MM)");
            data = new Scanner(System.in).nextLine();
            m = p.matcher(data);
            ok = m.matches();
            while(!ok){
                System.out.println("Erreur dans la date entrée. Merci de recommencer :");
                data = new Scanner(System.in).nextLine();
                m = p.matcher(data);
                ok = m.matches();
            }
            dateFin.parse(data);
            //this.setDateFin(creaDate());
            if (dateDebut.compareTo(dateFin) > 0) {
                System.out.println("La date de fin arrive avant la date de début");
            } else {
                datesOK = true;
            }
        }




    }

    /*public LocalDateTime creaDate(){
        LocalDateTime date = null;
        int annee,mois,jour,heure,minute;
        Scanner scan = new Scanner(System.in);

        System.out.println("Insérez l'année :");
        annee = scan.nextInt();
        while (annee < 2020){
            System.out.println("L'année ne peut pas être inférieure à 2020. Recommencez");
            annee = scan.nextInt();
        }
        System.out.println("Insérez le mois :");
        mois = scan.nextInt();
        while (mois < 1 && mois > 12){
            System.out.println("Le mois doit être compris entre 1 et 12. Recommencez");
            mois = scan.nextInt();
        }
        System.out.println("Insérez le jour :");
        jour = scan.nextInt();
        while (jour < 1 && jour > 31){
            System.out.println("Le jour doit être compris entre 1 et 31. Recommencez");
            jour = scan.nextInt();
        }
        System.out.println("Insérez l'heure :");
        heure = scan.nextInt();
        while (jour < 0 && jour > 23){
            System.out.println("L'heure doit être comprise entre 0 et 23. Recommencez");
            heure = scan.nextInt();
        }
        System.out.println("Insérez la minute :");
        minute = scan.nextInt();
        while (jour < 0 && jour > 59){
            System.out.println("La minute doit être comprise entre 0 et 59. Recommencez");
            minute = scan.nextInt();
        }
        date.of(annee,mois,jour,heure,minute);
        return date;
    }*/
}
