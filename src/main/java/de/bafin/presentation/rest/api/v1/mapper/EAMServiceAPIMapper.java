package de.bafin.presentation.rest.api.v1.mapper;

import de.bafin.presentation.rest.api.v1.model.Produkt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "cdi", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EAMServiceAPIMapper {

    Produkt sourceToDestination(de.bafin.domain.model.Produkt source);
    List<Produkt> sourceEntitiesListToProduktDestination(List<de.bafin.domain.model.Produkt> produktEntities);

    de.bafin.domain.model.Produkt destinationToSource(Produkt source);

}
