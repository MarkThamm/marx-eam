package de.bafin.application.impl;

import de.bafin.application.ProduktApplicationService;
import de.bafin.domain.model.Person;
import de.bafin.domain.model.Produkt;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProduktApplicationServiceImpl implements ProduktApplicationService {


    public ProduktApplicationServiceImpl() {
    }

    @Override
    public List<Produkt> getProdukte() {
        return getFakeList();
    }

    @Override
    public Produkt getProdukt(String name) {
        return null;
    }

    private static List<Produkt> getFakeList() {
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
