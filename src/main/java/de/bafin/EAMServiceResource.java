package de.bafin;

import de.bafin.presentation.rest.api.v1.model.Produkt;
import io.smallrye.common.constraint.NotNull;
import jakarta.validation.Valid;
import jakarta.ws.rs.core.Response;


public interface EAMServiceResource {
    /**
     * Liefert ein bestimmtes Prodcukt mit dem angegebenen Namen
     * @param name name des Produktes
     * @return
     */
    Response getProdukt(@NotNull String name);

    /**
     * Liefert alle Produkte
     * @return
     */
    Response getProdukte();

    Response addProdukt(@Valid Produkt produkt);

    Response deleteProdukt(@NotNull String name);
}
