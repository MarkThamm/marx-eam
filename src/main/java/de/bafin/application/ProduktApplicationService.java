package de.bafin.application;

import de.bafin.domain.model.Produkt;

import java.util.List;
import java.util.Optional;

public interface ProduktApplicationService {
    List<Produkt> getProdukte();

    Optional<Produkt> getProdukt(String name);

    Optional<Produkt> addProdukt(Produkt produkt);
    void deleteProdukt(String name);
}
