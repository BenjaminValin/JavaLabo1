package be.technifutur.java2020.gestionstage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FonctionsUtiles {

    public LocalDateTime saisieDate (){

        String affichageDate = "d/MM/yyyy HH:mm";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(affichageDate);

        System.out.println("Insérez une date (format JJ/MM/AAAA HH:MM)");
        String data = new Scanner(System.in).nextLine();
        Pattern p = Pattern.compile("(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9][0-9][0-9][0-9]) ([0-1][0-9]|2[0-3]):([0-5][0-9])");
        Matcher m = p.matcher(data);
        boolean ok = m.matches();
        while(!ok){
            System.out.println("Erreur dans la date entrée. Merci de recommencer :");
            data = new Scanner(System.in).nextLine();
            m = p.matcher(data);
            ok = m.matches();
        }
        LocalDateTime date = LocalDateTime.parse(data,format);
        return date;
    }

    public String afficheDate(LocalDateTime unedate){
        LocalDateTime dt = unedate;
        System.out.println("date de base : " + dt);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String date = dt.format(formatter);
        return date;
    }

    /*public static void main(String[] args) {
        FonctionsUtiles fctut = new FonctionsUtiles();

        System.out.println(fctut.afficheDate(fctut.saisieDate()));
    }*/
}
