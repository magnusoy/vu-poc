package no.vegvesen.vt.vu.proof.infrastructure;

import lombok.RequiredArgsConstructor;
import no.vegvesen.vt.vu.proof.domain.api.CostBenefitAlternatives;
import no.vegvesen.vt.vu.proof.domain.model.alternative.CostBenefitAlternative;
import no.vegvesen.vt.vu.proof.domain.model.alternative.CostModule;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class CostBenefitDataLoader implements ApplicationRunner {

    private final CostBenefitAlternatives costBenefitAlternatives;

    @Override
    public void run(ApplicationArguments args) {
        CostBenefitAlternative alternative = CostBenefitAlternative.create(
                1,
                "Alternative 1",
                "Description of alternative 1",
                Set.of(
                        CostModule.of(CostModule.Type.TRANSPORTMODULE,
                                CostModule.of(CostModule.Type.TRAFFICMODULE, null)),
                        CostModule.of(CostModule.Type.SAFETYMODULE, null)
                )
        );

        costBenefitAlternatives.persist(alternative);
    }
}
