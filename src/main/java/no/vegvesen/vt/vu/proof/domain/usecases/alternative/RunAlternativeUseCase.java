package no.vegvesen.vt.vu.proof.domain.usecases.alternative;

import lombok.RequiredArgsConstructor;
import no.vegvesen.vt.vu.proof.domain.api.Producer;
import no.vegvesen.vt.vu.proof.domain.model.alternative.CostBenefitAlternative;
import no.vegvesen.vt.vu.proof.domain.model.commands.CalculateCostBenefit;
import no.vegvesen.vt.vu.proof.domain.model.reflink.RefLink;
import no.vegvesen.vt.vu.proof.domain.usecases.UseCase;
import no.vegvesen.vt.vu.proof.domain.usecases.reflink.GenerateRefLinksUseCase;

import java.util.List;

@RequiredArgsConstructor
public class RunAlternativeUseCase extends UseCase<RunAlternativeUseCase.InputValues, RunAlternativeUseCase.OutputValues> {

    private final Producer producer;
    private final FindAlternativeUseCase findAlternativeUseCase;
    private final GenerateRefLinksUseCase generateRefLinksUseCase;

    @Override
    public OutputValues execute(InputValues input) {
        CostBenefitAlternative alternative = findAlternative(input.id);
        List<RefLink> refLinks = generateRefLinks(input.numberOfRefLinks);
        refLinks.forEach(refLink -> producer.dispatch(new CalculateCostBenefit(alternative, refLink)));
        return new OutputValues();
    }

    private CostBenefitAlternative findAlternative(Integer id) {
        return findAlternativeUseCase.execute(new FindAlternativeUseCase.InputValues(id)).alternative();
    }

    private List<RefLink> generateRefLinks(int numberToGenerate) {
        return generateRefLinksUseCase.execute(new GenerateRefLinksUseCase.InputValues(numberToGenerate)).refLinks();
    }

    public record InputValues(Integer id, int numberOfRefLinks) implements UseCase.InputValues {
    }

    public record OutputValues() implements UseCase.OutputValues {
    }
}
