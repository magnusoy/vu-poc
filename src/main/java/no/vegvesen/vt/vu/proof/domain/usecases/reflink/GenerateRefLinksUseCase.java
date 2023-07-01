package no.vegvesen.vt.vu.proof.domain.usecases.reflink;

import lombok.RequiredArgsConstructor;
import no.vegvesen.vt.vu.proof.domain.api.RefLinks;
import no.vegvesen.vt.vu.proof.domain.model.reflink.RefLink;
import no.vegvesen.vt.vu.proof.domain.usecases.UseCase;

import java.util.List;

@RequiredArgsConstructor
public class GenerateRefLinksUseCase extends UseCase<GenerateRefLinksUseCase.InputValues, GenerateRefLinksUseCase.OutputValues> {

    private final RefLinks refLinks;

    @Override
    public OutputValues execute(InputValues input) {
        return new OutputValues(refLinks.generate(input.numbersToGenerate));
    }

    public record InputValues(int numbersToGenerate) implements UseCase.InputValues {
    }

    public record OutputValues(List<RefLink> refLinks) implements UseCase.OutputValues {
    }
}
