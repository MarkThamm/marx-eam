package de.bafin.domain.model;

public class Produkt {
    private final String name;
    private final String vorname;
    private final String nachname;

    public Produkt(String projektName, String vorname, String nachname) {
        this.name = projektName;
        this.vorname = vorname;
        this.nachname = nachname;
    }


}
