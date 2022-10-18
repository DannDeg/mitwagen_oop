package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Datenbank {
    // Eingabefeld erstellen
    Scanner sc = new Scanner(System.in);

    // erstellen des Arrays
    Auto[] datenArray = new Auto[50];

    // Datendummy erstellen
    public void dummy(){
        Auto a1 = new Auto("1","VW Passat",170,34999);
        Auto a2 = new Auto("2","Audi A5",222,55000);
        Auto a3 = new Auto("3","Porsche 911",345,89000);
        Auto a4 = new Auto("4","Honda Civic",110,23000);
        Auto a5 = new Auto("5","Mercedes E-Klasse",230,65780);
        datenArray[0] = a1; datenArray[1] = a2; datenArray[2] = a3; datenArray[3] = a4; datenArray[4] = a5;
    }

    // Methode zur Ausgabe aller Datensätze
    public void ausgabeAlleDatensaetze() {
        int zaehler = 0;
        for (int i = 0; i < datenArray.length; i++) {
            if(datenArray[i] != null){
                datenArray[i].ausgabeData();
            }
            if(datenArray[i] == null){
                zaehler++;
                if(zaehler == datenArray.length){
                    System.out.println("Kein Datensatz verfügbar!!!");
                    System.out.println("__________*___________________________________________________________________________*__________\n");
                }
            }
        }
    }

    // Methode zum Hinzufügen eines Fahrzeugdatensatzes
    public void autoHinzu(String id,String hersteller,int ps,double preis){
        Auto a = new Auto(id, hersteller, ps, preis);
        for(int i = 0; i < datenArray.length; i++){
            if(datenArray[i] == null){
                datenArray[i] = a;
                break;
            }
        }
    }

    // Methode zum Anzeigen eines Datensatzes nach Suche durch eine Eigenschaft
    public void autoSuche(){
        String idAuswahl = null;
        String herstellerAuswahl = null;
        int psAuswahl = 0;
        double preisAuswahl = 0;
        System.out.println("Bitte geben Sie eine Eigenschaft nach der Sie suchen möchten, ein!!!");
        System.out.println("?S?U?C?H?E???S?U?C?H?E???S?U?C?H?E???S?U?C?H?E???S?U?C?H?E???S?U?C?H?E?");
        System.out.println("Die 1 für die Suche nach der ID!!!");
        System.out.println("Die 2 für die Suche nach dem Hersteller!!!");
        System.out.println("Die 3 für die Suche nach der Leistung in Ps!!!");
        System.out.println("Die 4 für die Suche nach dem Preis!!!");
        String auswahl = sc.next();
        if(auswahl.equals("1")){
            System.out.println("Bitte geben Sie die ID ein!!!");
            idAuswahl = sc.next();
        }
        if(auswahl.equals("2")){
            System.out.println("Bitte geben Sie den Hersteller ein!!!");
            herstellerAuswahl = sc.next();
        }
        if(auswahl.equals("3")){
            System.out.println("Bitte geben Sie die Leistung in Ps ein!!!");
            psAuswahl = sc.nextInt();
        }
        if(auswahl.equals("4")){
            System.out.println("Bitte geben Sie den Preis ein!!!");
            preisAuswahl = sc.nextDouble();
        }

        for (int i = 0; i < datenArray.length; i++){
            if (datenArray[i].getId().equals(idAuswahl)){
                System.out.println("gewünschter Datensatz: ");
                datenArray[i].ausgabeData();
                System.out.println("__________*___________________________________________________________________________*__________\n");
                break;
            }
            if (datenArray[i].getHersteller().equals(herstellerAuswahl)){
                System.out.println("gewünschter Datensatz: ");
                datenArray[i].ausgabeData();
                System.out.println("__________*___________________________________________________________________________*__________\n");
                break;
            }
            if (datenArray[i].getPs()==(psAuswahl)){
                System.out.println("gewünschter Datensatz: ");
                datenArray[i].ausgabeData();
                System.out.println("__________*___________________________________________________________________________*__________\n");
                break;
            }
            if (datenArray[i].getPreis()==(preisAuswahl)){
                System.out.println("gewünschter Datensatz: ");
                datenArray[i].ausgabeData();
                System.out.println("__________*___________________________________________________________________________*__________\n");
                break;
            }
        }
    }


    // Methode zum Löschen eines Datensatzes nach ID
    public void loescheDatensatzNachId(String id) {
        int letzteBelegteTasche = -1;
        int idzaehler = 0;

        // letzte belegte Arraytasche finden
        for (int i = 0; i < datenArray.length; i++){
            if(datenArray[i] == null){
                letzteBelegteTasche++;
            }
        }

        // Datensatz löschen und gelöschte Arraytasche ,mit letzter belegter Arraytasche befüllen
        for (int i = 0; i < datenArray.length; i++) {
            if (datenArray[i] != null && datenArray[i].getId().equals(id)) {
                System.out.println("Der Datensatz mit der ID: " + datenArray[i].getId() + " wurde erfolgreich aus der Datenbank entfernt ");
                System.out.println("__________*___________________________________________________________________________*__________\n");
                datenArray[i] = null;
                datenArray[i] = datenArray[letzteBelegteTasche];
                datenArray[letzteBelegteTasche] = null;
                break;
            }
            if(datenArray[i] == null || !Objects.equals(datenArray[i].getId(), id)){
                idzaehler++;
            }
        }
        if(idzaehler == datenArray.length){
            System.out.println("Die eingegebene ID existiert nicht!!!");
            System.out.println("__________*___________________________________________________________________________*__________\n");
        }
    }
    // Methode zum Sortieren der Datensätze nach Herstellername
    public void sortieren(){
        Auto temporaer;
        for(int i=0; i<datenArray.length; i++){
            for(int j=i+1; j<datenArray.length; j++){
                 if(datenArray[i] != null && datenArray[j] != null && datenArray[j].getHersteller().compareTo(datenArray[i].getHersteller()) < 0){
                     // swap elements
                     temporaer = datenArray[i];
                     datenArray[i] = datenArray[j];
                     datenArray[j] = temporaer;
                 }
            }
            if(datenArray[i] != null){
                datenArray[i].herstellerSortierung();
                System.out.println("__________*___________________________________________________________________________*__________\n");
            }
        }
    }
}


