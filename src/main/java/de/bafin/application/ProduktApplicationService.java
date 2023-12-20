package de.bafin.application;

import de.bafin.domain.model.Produkt;

import java.util.List;

public interface ProduktApplicationService {
    List<Produkt> getProdukte();
}
