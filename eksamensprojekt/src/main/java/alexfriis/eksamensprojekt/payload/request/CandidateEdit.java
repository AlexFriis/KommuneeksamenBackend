package alexfriis.eksamensprojekt.payload.request;

import alexfriis.eksamensprojekt.entity.Party;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Data
@RequiredArgsConstructor
public class CandidateEdit {

    private Long id;
    private String name;
    private Long partyId;

    public CandidateEdit(Long id, String name, Long partyId) {
        this.id = id;
        this.name = name;
        this.partyId = partyId;
    }
}
