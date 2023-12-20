package de.bafin.presentation.rest.api.v1.model;

import jakarta.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Person")
public class Person {
    @NotNull(message = "Der Vorname darf nicht leer sein")
    @Schema(description = "Vorname der Person")
    private String vorname;

    @NotNull(message = "Der Nachname darf nicht leer sein")
    @Schema(description = "Nachname der Person")
    private String nachname;

    @NotNull(message = "Die Email darf nicht leer sein")
    @Schema(description = "Emailadresse der Person")
    private String email;

    @NotNull(message = "Die OrgEinheit darf nicht leer sein")
    @Schema(description = "Organisationseinheit, in der die Person arbeitet")
    private String orgEinheit;

    public Person() {
    }

    public Person(String vorname, String nachname, String emailAdresse, String orgEinheit) {
        this.vorname=vorname;
        this.nachname=nachname;
        this.email=emailAdresse;
        this.orgEinheit=orgEinheit;
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", email='" + email + '\'' +
                ", orgEinheit='" + orgEinheit + '\'' +
                '}';
    }
}
