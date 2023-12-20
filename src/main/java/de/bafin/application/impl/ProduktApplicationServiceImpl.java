package de.bafin.application.impl;

import de.bafin.application.ProduktApplicationService;
import de.bafin.domain.model.Person;
import de.bafin.domain.model.Produkt;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProduktApplicationServiceImpl implements ProduktApplicationService {


    public ProduktApplicationServiceImpl() {

    }

    @Override
    public List<Produkt> getProdukte() {
        return fakeRepository();
    }

    @Override
    public Optional<Produkt> getProdukt(String name) {
        for (Produkt p : fakeRepository()) {
            if (p.getName().equals(name))
                return Optional.of(p);
        }
        return Optional.empty();
    }

    private static List<Produkt> fakeRepository() {
        // Personen
        List<Produkt> retVal = new ArrayList<Produkt>();
        Person christian = new Person("Kuske", "Christian", "christian.kuske@bafin.de", "IT3");
        Person michael = new Person("Kuske", "Christian", "christian.kuske@bafin.de", "IT3");

        //Produkte
        List<Produkt> produkte = new ArrayList<Produkt>();
        produkte.add(new Produkt("SREP", "5.3", christian));
        produkte.add(new Produkt("BAKIS", "10.3", michael));
        produkte.add(new Produkt("EME", "3.3", christian));
        return produkte;
    }
}
