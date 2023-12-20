package de.bafin.domain.model;

public class Produkt {
    private String name;
    private String version;
    private Person verantwortlicher;

    public Produkt() {
    }

    public Produkt(String projektName, String version, Person verantwortlicher) {
        this.name = projektName;
        this.version = version;
        this.verantwortlicher = verantwortlicher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Person getVerantwortlicher() {
        return verantwortlicher;
    }

    public void setVerantwortlicher(Person verantwortlicher) {
        this.verantwortlicher = verantwortlicher;
    }
}
