package be.technifutur.java2020.gestionstage;

import be.technifutur.java2020.gestionstage.donnees.ListeParticipants;
import be.technifutur.java2020.gestionstage.donnees.ListeStage;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FonctionsUtiles {

    public void afficheMenu(Object[] menu){
        System.out.println("Entrez le nombre correspondant au choix souhaité : ");
        System.out.println();
        for (int i = 0; i < menu.length; i++) {
            System.out.printf(" - %d : %s%n", i + 1, menu[i].getClass().getName());             //Régler le souci d'affichage
        }
        System.out.printf(" - %s : %s%n", "0", "Quitter");
        System.out.println();
        System.out.print("Faites votre choix : ");
    }

    public LocalDateTime saisieDate(){

        String affichageDate = "d/MM/yyyy HH:mm";
        DateTimeFormatter format = DateTimeFormatter.ofPattern(affichageDate);

        System.out.println("Insérez une date (format JJ/MM/AAAA HH:MM)");
        String data = new Scanner(System.in).nextLine();
        Pattern p = Pattern.compile("(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/([0-9][0-9][0-9][0-9]) ([0-1][0-9]|2[0-3]):([0-5][0-9])");
        Matcher m = p.matcher(data);
        boolean ok = m.matches();
        boolean valide = dateValide(data);
        while(!ok || !valide){
            System.out.println("Erreur dans la date entrée. Merci de recommencer :");
            data = new Scanner(System.in).nextLine();
            m = p.matcher(data);
            ok = m.matches();
            valide = dateValide(data);
        }
        LocalDateTime date = LocalDateTime.parse(data,format);
        return date;
    }

    public boolean dateValide(String c){
        String formatString = "dd/MM/yyyy";
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            format.setLenient(false);
            format.parse(c);
        } catch (ParseException | IllegalArgumentException e) {
            return false;
        }
        return true;
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

    public String saisieMail(){
        String data = new Scanner(System.in).nextLine();
        Pattern p = Pattern.compile("^([A-Za-z0-9+-.-]+)[@]([A-Za-z0-9+-.-]+)$");
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

    public boolean vide(String s){
        Pattern p = Pattern.compile("[ ]*");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public int saisieNombre(){
        Scanner scan = new Scanner(System.in);
        String choix = scan.nextLine();
        while (!estUnNombre(choix)){
            System.out.println("Ceci n'est pas un nombre. Recommencez :");
            choix = scan.nextLine();
        }
        int input = Integer.parseInt(choix);
        return input;
    }

    public String saisieNombreViaString(){
        Scanner scan = new Scanner(System.in);
        String choix = scan.nextLine();
        while (!estUnNombre(choix)){
            System.out.println("Ceci n'est pas un nombre. Recommencez :");
            choix = scan.nextLine();
        }
        return choix;
    }

    public boolean estUnNombre(String s){
        boolean test = true;
        try {
            int i = Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException pasbon) {
            test = false;
        }
        return test;
    }

    public String saisieDonneeNonVide(){
        FonctionsUtiles util = new FonctionsUtiles();
        String data = new Scanner(System.in).nextLine().trim();
        while (util.vide(data)){
            System.out.println("Ce champ ne peut être vide. Recommencez :");
            data = new Scanner(System.in).nextLine();
        }
        return data;
    }

    public boolean veutQuitter(String s){
        boolean test = false;
        char c = Character.toUpperCase(s.charAt(0));
        if (c == 'Q'){
            test = true;
        }
        return test;
    }

    public void affichePrix(double d){
        DecimalFormat euro = new DecimalFormat("0.00");
        System.out.println(euro.format(d) + " €");
    }

    public void sauvegardeListeStage(ListeStage liste){
        File fichier = new File("stagesencodes.stage");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(liste);
            //System.out.println(fichier.exists());
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

    public void sauvegardeListeParticipants(ListeParticipants liste){
        File fichier = new File("participantsencodes.stage");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(liste);
            System.out.println(fichier.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ListeParticipants chargementListeParticipants(){
        File fichier = new File("participantsencodes.stage");
        ListeParticipants liste = new ListeParticipants();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            liste = (ListeParticipants) ois.readObject();
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
