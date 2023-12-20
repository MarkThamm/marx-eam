package de.bafin.presentation.rest.api.v1.model;

import java.util.ArrayList;
import java.util.List;
import de.bafin.common.EAMServiceApiCode;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Schema(name = "Result")
public class Result {

    @Valid
    @Schema(description = "Nachrichtenliste")
    private List<Produkt> produkte = new ArrayList<Produkt>();

    @Schema(required = true, description = "Code des Results")
    @NotNull(message = "Der Resultcode darf nicht leer sein")
    private EAMServiceApiCode code;

    @Schema(description = "Description ID")
    private String correlationId;

    public Result() {
    }

    public Result(List<Produkt> produkte, EAMServiceApiCode code, String correlationId) {
        super();
        this.produkte = produkte;
        this.code = code;
        this.correlationId = correlationId;
    }

    public Result(String correlationId) {
        this.correlationId = correlationId;
    }

    public Result(EAMServiceApiCode code) {
        this.code = code;
    }

    public Result(EAMServiceApiCode code, String correlationId) {
        this.code = code;
        this.correlationId = correlationId;
    }

    public Result(EAMServiceApiCode code, List<Produkt> produkte) {
        this.code = code;
        this.produkte = produkte;
    }

    public EAMServiceApiCode getCode() {
        return code;
    }

    public void setCode(EAMServiceApiCode code) {
        this.code = code;
    }

    public List<Produkt> getProdukte() {
        return this.produkte;
    }

    public void setProdukte(List<Produkt> produkte) {
        this.produkte = produkte;
    }

    public void addProdukt(Produkt produkt) {
        this.produkte.add(produkt);
    }

    public void removeProdukt(Produkt produkt) {
        if (this.produkte.contains(produkt)) {
            this.produkte.remove(produkte.indexOf(produkt));
        }
    }


    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    @Override
    public String toString() {
        return "Result [message=" + produkte.toString() + ", code=" + code + ", correlationId=" + correlationId + "]";
    }
}