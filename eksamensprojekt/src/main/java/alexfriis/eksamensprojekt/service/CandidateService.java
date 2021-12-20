package alexfriis.eksamensprojekt.service;

import alexfriis.eksamensprojekt.entity.Candidate;
import alexfriis.eksamensprojekt.payload.request.CandidateEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import alexfriis.eksamensprojekt.repository.CandidateRepository;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class CandidateService {

    private CandidateRepository candidateRepository;
    private PartyService partyService;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository, PartyService partyService) {
        this.candidateRepository = candidateRepository;
        this.partyService = partyService;
    }




    public Candidate findById(Long id) {
        return candidateRepository.findById(id).orElseThrow(() -> new NoResultException("Candidate with id: " + id + " Does not exist!"));
    }


    public Candidate saveCandidate(CandidateEdit candidateEdit) {
        Candidate candidate = new Candidate();
        candidate.setName(candidateEdit.getName());
        candidate.setParty(partyService.findById(candidateEdit.getPartyId()));
        candidateRepository.save(candidate);
        return candidate;

    }

    public Candidate updateCandidate(CandidateEdit candidateEdit, Long id) {
        Candidate candidateData = candidateRepository.findById(id).orElseThrow(() -> new NoResultException("Candidate with id: " + id + " Does not exist!"));
        candidateData.setId(candidateEdit.getId());
        candidateData.setName(candidateEdit.getName());
        candidateData.setParty(candidateData.getParty());
        return candidateRepository.save(candidateData);
    }

    public List<Candidate> findAllCandidates(boolean sort) {
        if (sort)
            return candidateRepository.findAllCandidatesAsc();
        else
            return candidateRepository.findAllCandidatesDesc();
    }

    public List<Candidate> findAllCandidatesByParty(String name) {
        return candidateRepository.findCandidatesByParty(name);
    }
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }


}
