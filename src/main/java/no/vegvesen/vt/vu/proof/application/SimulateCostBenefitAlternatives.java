package no.vegvesen.vt.vu.proof.application;

import lombok.RequiredArgsConstructor;
import no.vegvesen.vt.vu.proof.domain.usecases.UseCaseExecutor;
import no.vegvesen.vt.vu.proof.domain.usecases.alternative.RunAlternativeUseCase;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimulateCostBenefitAlternatives {

    private final UseCaseExecutor useCaseExecutor;
    private final RunAlternativeUseCase runAlternativeUseCase;

    private static final int REFLINKS_TO_GENERATE = 5;

    @Scheduled(fixedDelay = 10000, initialDelay = 0)
    public void generate() {
        useCaseExecutor.execute(
                runAlternativeUseCase,
                new RunAlternativeUseCase.InputValues(1, REFLINKS_TO_GENERATE),
                outputValues -> null
        );
    }
}
