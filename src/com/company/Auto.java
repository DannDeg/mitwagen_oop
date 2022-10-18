package com.company;

public class Auto {

    // Attribute anlegen (Zugriffsmodifizierer, Datentyp, Name)
    private String id;
    private String hersteller;
    private int ps;
    private double preis;


    // erweiteten Konstruktor erstellen
    public Auto(String id, String hersteller, int ps, double preis) {
        this.id = id;
        this.hersteller= hersteller;
        this.ps = ps;
        this.preis = preis;
    }

    // Default-Konstruktor erstellen
    public Auto() {

    }


    // setter setzen (Zugriffsmodifizierer, Rückgabewert, Name der Funktion(Übergabeparameter)
    public void setId(String id){
        this.id = id;
    }
    public void setHersteller(String hersteller){
        this.hersteller = hersteller;
    }
    public void setPs(int ps){
        this.ps = ps;
    }
    public void setPreis(double preis){
        this.preis = preis;
    }


    // getter setzten (Zugriffsmodifizierer, Datentyp, Name der Funktion)
    public String getId(){
        return id;
    }
    public String getHersteller(){
        return hersteller;
    }
    public int getPs(){
        return ps;
    }
    public double getPreis(){
        return preis;
    }

    // Methode zur Ausgabe eines Datensatzes
    public void ausgabeData(){
        System.out.println("ID:\t\t" + getId());
        System.out.println("Hersteller:\t" + getHersteller());
        System.out.println("PS:\t\t" + getPs());
        System.out.println("Preis:\t" + getPreis());
        System.out.println("__________*___________________________________________________________________________*__________\n");
    }

    // Methode zur Sortierung nach Hersteller
    public void herstellerSortierung(){
        System.out.println("Hersteller:\t" + getHersteller());
        System.out.println("ID:\t\t" + getId());
        System.out.println("PS:\t\t" + getPs());
        System.out.println("Preis:\t" + getPreis());
        System.out.println("__________*___________________________________________________________________________*__________\n");
    }

}
