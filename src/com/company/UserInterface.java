package com.company;

import java.util.Scanner;

public class UserInterface {

    // Datenbank anlegen
    static Datenbank db = new Datenbank();

    public static void main(String[] args) {

        // Test-Dummy nutzen
        db.dummy();

        String eingabe;
        int zaehler = 0;

        // Eingabefeld erstellen
        Scanner sc = new Scanner(System.in).useDelimiter("(\\s*,\\s*)|(\r\n)|(\n)");

        // Überschrift Programm
        System.out.println("Mietwagen-Projekt");
        System.out.println("*****************");

        do {

            // Bedienmenue erstellen

            System.out.println("Bedienmenue");
            System.out.println("-----------");
            System.out.println("Wählen Sie 1 für die Ausgabe aller Datensätze!!!");
            System.out.println("Wählen Sie 2 für das Hinzufügen eines neuen Fahrzeugssatzes!!!");
            System.out.println("Wählen Sie 3 für die Suche eines Datensatzes nach Eingabe einer Eigenschaft und Ausgabe des/der gefundenen Datensatzes / Datensätze!!!");
            System.out.println("Wählen Sie 4 für das Löschen eines Datensatzes nach Eingabe der ID!!!");
            System.out.println("Wählen Sie 5 für das Sortieren der Reihung alphabetisch nach Hersteller!!!");
            System.out.println("Wählen Sie 6 für das Beenden des Menues!!!");

            // Variable des Eingabefeldes deklarieren
            eingabe = sc.next();

            // Zuweisungen aus dem Bedienmenue
            if (eingabe.equals("1")) {
                db.ausgabeAlleDatensaetze();
            }
            if (eingabe.equals("2")) {
                System.out.println("Eingabe neue ID: ");
                String idEingabe = sc.next();
                System.out.println("Eingabe neuer Hersteller: ");
                String herstellerEingabe = sc.next();
                System.out.println("Eingabe neuer Leistung in PS: ");
                int psEingabe = sc.nextInt();
                System.out.println("Eingabe neuer Preis: ");
                double preisEingabe = sc.nextDouble();
                db.autoHinzu(idEingabe, herstellerEingabe, psEingabe, preisEingabe);
            }
            if (eingabe.equals("3")) {
                db.autoSuche();
            }
            if (eingabe.equals("4")) {
                System.out.println("Bitte geben Sie eine ID ein zum Löschen des Datensatz!!!");
                String idloesch = sc.next();
                db.loescheDatensatzNachId(idloesch);
            }
            if (eingabe.equals("5")) {
                db.sortieren();
            }
            if(eingabe.equals("1") == false && eingabe.equals("2") == false && eingabe.equals("3") == false && eingabe.equals("4") == false && eingabe.equals("5") == false && eingabe.equals("6") == false){
                System.out.println("???????????????????????????????????????????????????????????");
                System.out.println("Bitte geben Sie exakt wie angegeben eine Menüauswahl ein!!!");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
            }

        } while (!(eingabe.equals("6")));
        System.out.println("Sie haben das Programm beendet!!!");
        System.out.println("Vielen Dank für die Benutzung.");

    }
}

