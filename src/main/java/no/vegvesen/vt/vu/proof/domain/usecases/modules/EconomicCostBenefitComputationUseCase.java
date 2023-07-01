package no.vegvesen.vt.vu.proof.domain.usecases.modules;

import lombok.extern.slf4j.Slf4j;
import no.vegvesen.vt.vu.proof.domain.api.Producer;

@Slf4j
public class EconomicCostBenefitComputationUseCase extends CostBenefitComputationUseCase {

    public EconomicCostBenefitComputationUseCase(Producer producer) {
        super(producer);
    }

    @Override
    public OutputValues execute(InputValues input) {
        // Do some work
        log.info("EconomicCostBenefitComputationUseCase: Calculating alternative {} and refLink {}", input.alternative().id(), input.refLink().getMetaData().id());
        dispatchToNext(input);
        return new OutputValues();
    }

}
