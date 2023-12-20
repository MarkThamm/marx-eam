package de.bafin.presentation.rest.api.v1.impl;

import de.bafin.EAMServiceResource;
import de.bafin.application.ProduktApplicationService;
import de.bafin.presentation.rest.api.v1.model.Produkt;
import de.bafin.presentation.rest.api.v1.model.Result;
import jakarta.enterprise.context.RequestScoped;
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

/**
 * Service-endpoint: http://localhost:8080/eam/api/produkte
 * Swagger: http://localhost:8080/q/swagger-ui/
 */

@RequestScoped
@Path("/produkte")
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "EAMService", description = "verwaltet alle Domainenoperationen")
public class EAMServiceResourceImpl implements EAMServiceResource {

    private ProduktApplicationService applicationService;


    @GET
    @NoCache
    @Operation(description = "Hole das Produkt mit dem übergebenen Namen")
    @Path("/{name}")
    @Override
    public Response getProdukt(@Parameter(required = true, description = "Produkt mit dem eindeutigen Namen", name = "name")
                               @PathParam(value = "name") String name) {

        var result = new Result("4711t");
        Produkt retVal = new Produkt("SREP", "Kuske", "Christian", "christian.kuske@bafin.de", "IT3");
        List<Produkt> produkte = new ArrayList<Produkt>();
        produkte.add(retVal);
        result.setProdukte(produkte);

        return Response.ok(result).build();
    }


}
