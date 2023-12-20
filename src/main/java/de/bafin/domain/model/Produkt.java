package de.bafin.domain.model;

public class Produkt {
    private final String name;
    private final String version;
    private final Person verantwortlicher;

    public Produkt(String projektName, String version, Person verantwortlicher) {
        this.name = projektName;
        this.version = version;
        this.verantwortlicher = verantwortlicher;
    }


}
