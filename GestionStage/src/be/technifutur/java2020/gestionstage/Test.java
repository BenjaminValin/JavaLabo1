package be.technifutur.java2020.gestionstage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

    public static int ligne = 0;
    public static int derniereligne = 28;

    public static String Texte() throws FileNotFoundException {
        File texte = new File("text.txt");
        Scanner scanner = new Scanner(texte);
        String stock = "";
        if (ligne <= derniereligne){
            int l = 0;
            while (l<=ligne){
                stock = scanner.nextLine();
                l++;
            }
        }
        ligne++;
        return stock;
    }

    /*public static void main(String[] args) throws FileNotFoundException {
        System.out.println(Texte());
        System.out.println(Texte());
        System.out.println(Texte());
        System.out.println(Texte());
        System.out.println(Texte());
        System.out.println(Texte());
    }*/
}
