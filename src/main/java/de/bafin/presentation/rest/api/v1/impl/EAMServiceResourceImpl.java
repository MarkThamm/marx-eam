package de.bafin.presentation.rest.api.v1.impl;

import de.bafin.EAMServiceResource;
import de.bafin.application.ProduktApplicationService;
import de.bafin.common.EAMServiceApiCode;
import de.bafin.common.utils.CorrelationUtils;
import de.bafin.presentation.rest.api.v1.mapper.EAMModelMapper;
import de.bafin.presentation.rest.api.v1.model.Produkt;
import de.bafin.presentation.rest.api.v1.model.Result;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.NoCache;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    private final EAMModelMapper eamModelMapper;

    @Inject
    public EAMServiceResourceImpl(ProduktApplicationService applicationService, EAMModelMapper eamServiceAPIMapper) {
        Objects.requireNonNull(applicationService, "applicationService darf nicht null sein");
        this.applicationService = applicationService;
        this.eamModelMapper = eamServiceAPIMapper;
    }


    @GET
    @NoCache
    @Operation(description = "Hole das Produkt mit dem übergebenen Namen")
    @Path("/{name}")
    @Override
    public Response getProdukt(@Parameter(required = true, description = "Produkt mit dem eindeutigen Namen", name = "name")
                               @PathParam(value = "name") String name) {

        var result = new Result(CorrelationUtils.getCorrelationID());
        Optional<de.bafin.domain.model.Produkt> entity = applicationService.getProdukt(name);

        if (entity.isPresent()) {
            Produkt produkt = eamModelMapper.viewModel_From_Entity_Produkt(entity.get());
            result.addProdukt(produkt);
            result.setCode(EAMServiceApiCode.OK.name());
        } else {
            result.setCode(EAMServiceApiCode.PRODUKTE_NOT_FOUND.name());
        }

        return Response.ok(result).build();
    }

    @GET
    @NoCache
    @Operation(description = "Hole alle Produkte")
    @Override
    public Response getProdukte() {
        var result = new Result(CorrelationUtils.getCorrelationID());

        List<de.bafin.domain.model.Produkt> entities = applicationService.getProdukte();
        if (entities != null) {
            List<Produkt> produkte = eamModelMapper.viewModelList_From_EntityList_Produkt(entities);
            result.setProdukte(produkte);
            result.setCode(EAMServiceApiCode.OK.name());
        } else {
            result.setCode(EAMServiceApiCode.PRODUKTE_NOT_FOUND.name());
        }
        return Response.ok(result).build();
    }

    @POST
    @NoCache
    @Counted(name = "Gespeichertes Produkt", description = "Zaehlt die gespeicherten Produkte")
    @Operation(description = "Speichert ein Produkt.")
    @Path("addProdukt")
    @APIResponse(responseCode = "200", description = "Response mit gespeichertem Result zum uebergegebenen Produkt-Objekt", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Result.class)))
    @APIResponse(responseCode = "504", description = "Service Zeit ist ueberschritten")
    @APIResponse(responseCode = "401", description = "Benutzer ist nicht autorisiert")
    @Override
    public Response addProdukt(
            @Valid @RequestBody(description = "Nachricht",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = Produkt.class))) Produkt produkt) {

        var result = new Result(CorrelationUtils.getCorrelationID());
        Produkt newProdukt = null;
        de.bafin.domain.model.Produkt produktEntity = eamModelMapper.entity_FROM_viewModel(produkt);
        Optional<de.bafin.domain.model.Produkt> optionalEntity = applicationService.addProdukt(produktEntity);
        //.saveInstitut(institutsserviceApiMapper.destinationToSource(produkt));

        if (optionalEntity.isPresent()) {
            newProdukt = eamModelMapper.viewModel_From_Entity_Produkt(optionalEntity.get());
            result.addProdukt(newProdukt);
            result.setCode(EAMServiceApiCode.OK.name());
        } else {
            result.setCode(EAMServiceApiCode.NOK.name());
        }
        return Response.ok(result).build();
    }


}
