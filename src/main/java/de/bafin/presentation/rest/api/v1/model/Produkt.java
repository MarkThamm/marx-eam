package de.bafin.presentation.rest.api.v1.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(name = "Produkt")
public class Produkt {


    @Schema(description = "Verantwortlicher für das Produkt")
    private Person verantwortlicher;


    private String version;

    @Schema(description = "Produktname")
    @NotNull(message = "Der Produktname darf nicht leer sein")
    @Size(max = 100, message = "Der Produktname darf nicht mehr als 100 Zeichen betragen")
    private String name;

    public Produkt() {

    }

    public Produkt(String name, String version) {
        super();
        this.version = version;
        this.name = name;
    }

    public Produkt(String name) {
        this.name = name;
    }

    public Produkt(String name,  String vorname, String nachname, String emailAdresse, String orgEinheit) {
        super();
        this.name = name;
        this.verantwortlicher = new Person(vorname,nachname,emailAdresse,orgEinheit);
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

    @Override
    public String toString() {
        return "Message [name=" + name + ", version=" + version + ", name=" + name + ", toString()=" + super.toString()
                + "]";
    }
}