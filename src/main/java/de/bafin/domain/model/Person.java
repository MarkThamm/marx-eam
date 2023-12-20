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
}
