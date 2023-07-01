package no.vegvesen.vt.vu.proof.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import no.vegvesen.vt.vu.proof.domain.api.CostBenefitAlternatives;
import no.vegvesen.vt.vu.proof.domain.model.alternative.CostBenefitAlternative;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CostBenefitAlternativeRepository implements CostBenefitAlternatives {

    private static final Map<Integer, CostBenefitAlternative> repository = new HashMap<>();

    @Override
    public Optional<CostBenefitAlternative> findBy(Integer id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public List<CostBenefitAlternative> findAll() {
        return List.copyOf(repository.values());
    }

    @Override
    public void persist(CostBenefitAlternative alternative) {
        repository.put(alternative.id(), alternative);
    }
}
