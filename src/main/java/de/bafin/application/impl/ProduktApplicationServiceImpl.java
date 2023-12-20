package de.bafin.application.impl;

import de.bafin.application.ProduktApplicationService;
import de.bafin.domain.model.Produkt;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProduktApplicationServiceImpl implements ProduktApplicationService {


    public ProduktApplicationServiceImpl() {
    }

    @Override
    public List<Produkt> getProdukte() {
        return null;
    }
}
