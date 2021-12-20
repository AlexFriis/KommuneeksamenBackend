package alexfriis.eksamensprojekt.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor

@Entity
@Table(name = "parties")
public class Party implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Long partyId;

    @Column(name = "party_name")
    private String partyName;

    @OneToMany(mappedBy = "party", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "party")
    @JsonBackReference
    private Set<Candidate> candidateSet = new HashSet<>();



}
