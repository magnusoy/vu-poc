package no.vegvesen.vt.vu.proof.domain.usecases.alternative;

import lombok.RequiredArgsConstructor;
import no.vegvesen.vt.vu.proof.domain.api.CostBenefitAlternatives;
import no.vegvesen.vt.vu.proof.domain.exceptions.NotFoundException;
import no.vegvesen.vt.vu.proof.domain.model.alternative.CostBenefitAlternative;
import no.vegvesen.vt.vu.proof.domain.usecases.UseCase;

@RequiredArgsConstructor
public class FindAlternativeUseCase extends UseCase<FindAlternativeUseCase.InputValues, FindAlternativeUseCase.OutputValues> {

    private final CostBenefitAlternatives alternatives;

    @Override
    public OutputValues execute(InputValues input) {
        return alternatives.findBy(input.id)
                .map(OutputValues::new)
                .orElseThrow(() -> new NotFoundException("Can not find alternative with id ", input.id));
    }

    public record InputValues(Integer id) implements UseCase.InputValues {
    }

    public record OutputValues(CostBenefitAlternative alternative) implements UseCase.OutputValues {
    }
}
