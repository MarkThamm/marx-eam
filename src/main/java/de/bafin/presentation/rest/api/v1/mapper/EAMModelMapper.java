package de.bafin.presentation.rest.api.v1.mapper;

import de.bafin.presentation.rest.api.v1.model.Person;
import de.bafin.presentation.rest.api.v1.model.Produkt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EAMModelMapper {
    public List<Produkt> viewModelList_From_EntityList(List<de.bafin.domain.model.Produkt> entities) {
        List<Produkt> retVal = new ArrayList<Produkt>();

        for (de.bafin.domain.model.Produkt p : entities) {
            Produkt newPerson = new Produkt(p.getName(), p.getVersion(), vieModel_From_Entity(p.getVerantwortlicher()));
            retVal.add(newPerson);
        }
        
        return retVal;
    }

    private Person vieModel_From_Entity(de.bafin.domain.model.Person person){
        return new Person(person.getVorname(), person.getNachname(), person.getEmail(), person.getOrgEinheit());
    }
}
