package alexfriis.eksamensprojekt.controller;

import alexfriis.eksamensprojekt.entity.Candidate;
import alexfriis.eksamensprojekt.entity.Party;
import alexfriis.eksamensprojekt.payload.request.CandidateEdit;
import alexfriis.eksamensprojekt.service.CandidateService;
import alexfriis.eksamensprojekt.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@CrossOrigin(value = {"http://localhost:63342"})
public class CandidateController {

    private CandidateService candidateService;
    private PartyService partyService;

    @Autowired
    CandidateController(CandidateService candidateService, PartyService partyService) {
        this.candidateService = candidateService;
        this.partyService = partyService;
    }


    @GetMapping("get-candidate/{id}")
    public ResponseEntity<Candidate> getParty(@PathVariable Long id) {
        Candidate candidate = candidateService.findById(id);
        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }

    @PostMapping("/add-candidate")
    public ResponseEntity<Candidate> addCandidate(@RequestBody CandidateEdit candidateEdit) throws URISyntaxException {
        Candidate result = null;
        result = candidateService.saveCandidate(candidateEdit);
        return ResponseEntity.created(new URI("/candidate/" + result.getId())).body(result);
    }

    @PutMapping("/update-candidate/{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable Long id, @RequestBody CandidateEdit candidateEdit) {
        Candidate tempCandidate = candidateService.updateCandidate(candidateEdit, id);
        return ResponseEntity.ok().body(tempCandidate);
    }


    @DeleteMapping("/delete-candidate/{id}")
    public ResponseEntity<Candidate> deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get-candidates")
    public ResponseEntity<List<Candidate>> getAllCandidates(@RequestParam(value = "sort") boolean sort) {
        List<Candidate> allCandidates = candidateService.findAllCandidates(sort);
        return new ResponseEntity<>(allCandidates, HttpStatus.OK);
    }

    @GetMapping("/candidate-by-party")
    public ResponseEntity<List<Candidate>> getAllByParty(@RequestParam(value = "partyname") String name) {
        List<Candidate> candidateListForParty = candidateService.findAllCandidatesByParty(name);
        return new ResponseEntity<>(candidateListForParty, HttpStatus.OK);
    }
}
