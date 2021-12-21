package alexfriis.eksamensprojekt.controller;

import alexfriis.eksamensprojekt.entity.Party;
import alexfriis.eksamensprojekt.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "http://Localhost:8080")
public class PartyController {

    private PartyService partyservice;

    @Autowired
    public PartyController(PartyService partyService) {this.partyservice = partyService;}

    @GetMapping("/getParty/{id}")
    public ResponseEntity<Party> getParty(@PathVariable Long id) {
        Party party = partyservice.findById(id);
        return new ResponseEntity<>(party, HttpStatus.OK);
    }



}
