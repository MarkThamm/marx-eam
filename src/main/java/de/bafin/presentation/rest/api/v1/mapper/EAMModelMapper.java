package de.bafin.presentation.rest.api.v1.mapper;

import de.bafin.presentation.rest.api.v1.model.Person;
import de.bafin.presentation.rest.api.v1.model.Produkt;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EAMModelMapper {
    public List<Produkt> viewModelList_From_EntityList_Produkt(List<de.bafin.domain.model.Produkt> entities) {
        List<Produkt> retVal = new ArrayList<Produkt>();

        for (de.bafin.domain.model.Produkt p : entities) {
            Produkt newPerson = new Produkt(p.getName(), p.getVersion(), viewModel_From_Entity_Person(p.getVerantwortlicher()));
            retVal.add(newPerson);
        }

        return retVal;
    }

    public Person viewModel_From_Entity_Person(de.bafin.domain.model.Person person) {
        return new Person(person.getVorname(), person.getNachname(), person.getEmail(), person.getOrgEinheit());
    }

    public de.bafin.domain.model.Person entity_From_viewModel_Person(Person person) {
        return new de.bafin.domain.model.Person(person.getVorname(), person.getNachname(), person.getEmail(), person.getOrgEinheit());
    }

    public Produkt viewModel_From_Entity_Produkt(de.bafin.domain.model.Produkt produkt) {
        return new Produkt(produkt.getName(), produkt.getVersion(), viewModel_From_Entity_Person(produkt.getVerantwortlicher()));
    }

    public de.bafin.domain.model.Produkt entity_FROM_viewModel(Produkt produkt) {
        de.bafin.domain.model.Produkt retVal = new de.bafin.domain.model.Produkt();
        retVal.setName(produkt.getName());
        retVal.setVersion(produkt.getVersion());
        retVal.setVerantwortlicher(entity_From_viewModel_Person(produkt.getVerantwortlicher()));
        return retVal;
    }
}
