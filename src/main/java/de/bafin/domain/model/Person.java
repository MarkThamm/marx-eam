package de.bafin.domain.model;

import jakarta.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class Person {
    public Person() {
    }

    public Person(String vorname, String nachname, String email, String orgEinheit) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.orgEinheit = orgEinheit;
    }

    private String vorname;

    private String nachname;

    private String email;

    private String orgEinheit;

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrgEinheit() {
        return orgEinheit;
    }

    public void setOrgEinheit(String orgEinheit) {
        this.orgEinheit = orgEinheit;
    }
}
