package alexfriis.eksamensprojekt.repository;

import alexfriis.eksamensprojekt.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    @Query("SELECT p FROM Candidate p ORDER BY p.party.partyName ASC")
    List<Candidate> findAllCandidatesAsc();

    @Query("SELECT p FROM Candidate p ORDER BY p.party.partyName DESC")
    List<Candidate> findAllCandidatesDesc();

    @Query("SELECT c FROM Candidate c WHERE c.party.partyName = :partyName")
    List<Candidate> findCandidatesByParty(@Param("partyName")String partyName);
}
