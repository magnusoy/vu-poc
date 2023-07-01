package no.vegvesen.vt.vu.proof.domain.api;

import no.vegvesen.vt.vu.proof.domain.model.alternative.CostBenefitAlternative;

import java.util.List;
import java.util.Optional;

public interface CostBenefitAlternatives {

    Optional<CostBenefitAlternative> findBy(Integer id);

    List<CostBenefitAlternative> findAll();

    void persist(CostBenefitAlternative alternative);
}
