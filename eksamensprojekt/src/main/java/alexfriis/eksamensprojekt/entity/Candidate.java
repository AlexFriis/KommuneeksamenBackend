package alexfriis.eksamensprojekt.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor

@Entity
@Table(name = "candidates")
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_seq_gen")
    @SequenceGenerator(name = "candidate_seq_gen", sequenceName = "candidate_seq_gen", allocationSize = 1, initialValue = 31)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "party")
    private Party party;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(id, candidate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //For testing purposes
    public Candidate(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //For testing purposes
    public Candidate(Long id, String name, Party party) {
        this.id = id;
        this.name = name;
        this.party = party;
    }


}
