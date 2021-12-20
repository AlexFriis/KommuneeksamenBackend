package alexfriis.eksamensprojekt.service;

import alexfriis.eksamensprojekt.entity.Candidate;
import alexfriis.eksamensprojekt.entity.Party;
import alexfriis.eksamensprojekt.repository.CandidateRepository;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.persistence.NoResultException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CandidateServiceTest {

    private AutoCloseable autoCloseable;
    @InjectMocks
    private CandidateService candidateService;
    @Mock
    private CandidateRepository candidateRepository;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }


    @Test
    void findById() {
        Mockito.when(candidateRepository.findById(1L)).thenReturn(Optional.of(new Candidate(1L, "thisName")));
        Candidate candidate = this.candidateRepository.findById(1L).orElseThrow(() -> new NoResultException("Unable to find id."));
        Assertions.assertEquals("thisName", candidate.getName());
    }

    @Test
    void testSaveCandidate() {
        Candidate candidate = new Candidate(1L, "testName", new Party());
        candidateRepository.save(candidate);
        Mockito.verify(this.candidateRepository, Mockito.times(1));
        Assertions.assertEquals(candidate.getName(), "testName");
        System.out.println(candidate.getName());
    }
}
