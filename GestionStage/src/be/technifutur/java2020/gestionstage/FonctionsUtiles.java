package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.stages.ListeStage;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FonctionsUtiles {

    public LocalDateTime saisieDate(){

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

    public String saisieMail(){
        String data = new Scanner(System.in).nextLine();
        Pattern p = Pattern.compile("^[A-Za-z0-9+-.-]*@[A-Za-z0-9+-.-]*$");
        Matcher m = p.matcher(data);
        boolean ok = m.matches();
        while(!ok){
            System.out.println("Erreur dans le mail entré. Merci de recommencer :");
            data = new Scanner(System.in).nextLine();
            m = p.matcher(data);
            ok = m.matches();
        }
        return data;
    }

    public String afficheDate(LocalDateTime unedate){
        LocalDateTime dt = unedate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy à HH:mm");
        String date = dt.format(formatter);
        return date;
    }

    public String afficheDate(LocalDate unedate){
        LocalDate dt = unedate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = dt.format(formatter);
        return date;
    }

    public String afficheDateFR(LocalDateTime unedate){
        LocalDateTime dt = unedate;
        String date = dt.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRENCH) +
                " " + dt.getDayOfMonth() +
                " " + dt.getMonth().getDisplayName(TextStyle.FULL,Locale.FRENCH) +
                " " + dt.getYear();
        return date;
    }

    public String afficheDateFR(LocalDate unedate){
        LocalDate dt = unedate;
        String date = dt.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRENCH) +
                " " + dt.getDayOfMonth() +
                " " + dt.getMonth().getDisplayName(TextStyle.FULL,Locale.FRENCH) +
                " " + dt.getYear();
        return date;
    }

    public void sauvegardeListeStage(ListeStage liste){
        File fichier = new File("stagesencodes.stage");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(liste);
            System.out.println(fichier.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ListeStage chargementListeStage(){
        File fichier = new File("stagesencodes.stage");
        ListeStage liste = new ListeStage();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            liste = (ListeStage) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return liste;
    }

    /*public static void main(String[] args) {
        FonctionsUtiles fctut = new FonctionsUtiles();

        System.out.println(fctut.afficheDate(fctut.saisieDate()));
    }*/
}
