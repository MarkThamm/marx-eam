package de.bafin.presentation.rest.api.v1.impl;

import de.bafin.EAMServiceResource;
import de.bafin.application.ProduktApplicationService;
import de.bafin.common.utils.CorrelationUtils;
import de.bafin.presentation.rest.api.v1.mapper.EAMServiceAPIMapper;
import de.bafin.presentation.rest.api.v1.model.Produkt;
import de.bafin.presentation.rest.api.v1.model.Result;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.NoCache;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Service-endpoint: http://localhost:8080/eam/api/produkte
 * Swagger: http://localhost:8080/q/swagger-ui/
 */

@RequestScoped
@Path("/produkte")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "EAMService", description = "verwaltet alle Domainenoperationen")
public class EAMServiceResourceImpl implements EAMServiceResource {

    private final ProduktApplicationService applicationService;

    private final EAMServiceAPIMapper eamServiceAPIMapper;
    @Inject
    public EAMServiceResourceImpl(ProduktApplicationService applicationService, EAMServiceAPIMapper eamServiceAPIMapper) {
        Objects.requireNonNull(applicationService, "applicationService darf nicht null sein");
        this.applicationService = applicationService;
        this.eamServiceAPIMapper = eamServiceAPIMapper;
    }


    @GET
    @NoCache
    @Operation(description = "Hole das Produkt mit dem übergebenen Namen")
    @Path("/{name}")
    @Override
    public Response getProdukt(@Parameter(required = true, description = "Produkt mit dem eindeutigen Namen", name = "name")
                               @PathParam(value = "name") String name) {

        var result = new Result(CorrelationUtils.getCorrelationID());
        List<de.bafin.domain.model.Produkt> entities = applicationService.getProdukte();
        Produkt retVal = new Produkt("SREP", "Kuske", "Christian", "christian.kuske@bafin.de", "IT3");
        List<Produkt> produkte = new ArrayList<Produkt>();
        produkte.add(retVal);
        result.setProdukte(produkte);

        return Response.ok(result).build();
    }

    @GET
    @NoCache
    @Operation(description = "Hole alle Produkte")
    @Override
    public Response getProdukte() {
        var result = new Result(CorrelationUtils.getCorrelationID());
        List<de.bafin.domain.model.Produkt> entities = applicationService.getProdukte();
        if(entities!=null){
           // List<Pqrodukt> produkte =
        } else {
// uuuu
        }
        return null;
    }


}
