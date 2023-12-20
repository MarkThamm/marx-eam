package de.bafin;

import io.smallrye.common.constraint.NotNull;
import jakarta.ws.rs.core.Response;


public interface EAMServiceResource {
    Response getProdukt(@NotNull String name);

}
