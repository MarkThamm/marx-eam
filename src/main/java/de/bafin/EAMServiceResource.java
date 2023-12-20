package de.bafin;

import io.smallrye.common.constraint.NotNull;
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
}
