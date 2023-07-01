package no.vegvesen.vt.vu.proof.domain.usecases.modules;

import lombok.RequiredArgsConstructor;
import no.vegvesen.vt.vu.proof.domain.api.Producer;
import no.vegvesen.vt.vu.proof.domain.model.alternative.CostBenefitAlternative;
import no.vegvesen.vt.vu.proof.domain.model.commands.CalculateCostBenefit;
import no.vegvesen.vt.vu.proof.domain.model.reflink.RefLink;
import no.vegvesen.vt.vu.proof.domain.usecases.UseCase;

@RequiredArgsConstructor
public abstract class CostBenefitComputationUseCase extends UseCase<CostBenefitComputationUseCase.InputValues, CostBenefitComputationUseCase.OutputValues> {

    protected final Producer producer;

    @Override
    public abstract OutputValues execute(InputValues input);

    protected void dispatchToNext(InputValues input) {
        producer.dispatch(new CalculateCostBenefit(input.alternative().prepareForNext(), input.refLink()));
    }

    public record InputValues(CostBenefitAlternative alternative, RefLink refLink) implements UseCase.InputValues {
    }

    public record OutputValues() implements UseCase.OutputValues {
    }
}
