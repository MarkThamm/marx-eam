package de.bafin.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import java.util.UUID;

/**
 * The Class ContextUtils.
 */
public final class CorrelationUtils {

    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CorrelationUtils.class);

    /**
     * The Constant CORRELATION_ID.
     */
    public static final String CORRELATION_ID = "CORRELATION_ID";

    public CorrelationUtils() {
    }

    /**
     * Erzeugt correlationID und liefert sie zurueck.
     *
     * @return correlationID
     */
    private static String createCorrelation(String correlationID) {
        String foundCorrelationId = correlationID;
        if (StringUtils.isEmpty(foundCorrelationId)) {
            foundCorrelationId = UUID.randomUUID()
                    .toString();
        }
        MDC.put(CORRELATION_ID, foundCorrelationId);
        return foundCorrelationId;
    }

    /**
     * Erzeugt correlationId, falls sie nicht existiert und liefert sie zurueck.
     *
     * @return correlationID
     */
    public static String createCorrelationIfNotPresent(String correlationID) {
        final String foundCorrelationId = MDC.get(CORRELATION_ID);
        if (foundCorrelationId == null) {
            return createCorrelation(correlationID);
        }

        return foundCorrelationId;
    }

    /**
     * Liefert die CorrelationID zurueck.
     *
     * @return CorrelationID
     */
    public static String getCorrelationID() {
        return MDC.get(CORRELATION_ID);
    }

    /**
     * Loescht correlationId.
     */
    public static void removeCorrelation() {
        MDC.remove(CORRELATION_ID);
        if (getCorrelationID() != null) {
            LOGGER.error("CorrelationID could not be removed");
        }
    }
}
