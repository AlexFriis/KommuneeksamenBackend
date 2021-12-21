package alexfriis.eksamensprojekt.service;

import alexfriis.eksamensprojekt.entity.Candidate;
import alexfriis.eksamensprojekt.entity.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alexfriis.eksamensprojekt.repository.PartyRepository;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class PartyService {

    private PartyRepository partyRepository;

    @Autowired
    public PartyService(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    public Party findById(Long id) {
        return partyRepository.findById(id).orElseThrow(() -> new NoResultException("Party with id: " + id + " Does not exist!"));
    }



    public List<Party> findAllParties() {
        return partyRepository.findAll();
    }
}
