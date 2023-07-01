package no.vegvesen.vt.vu.proof.presentation.configuration;

import no.vegvesen.vt.vu.proof.domain.api.CostBenefitAlternatives;
import no.vegvesen.vt.vu.proof.domain.api.Producer;
import no.vegvesen.vt.vu.proof.domain.api.RefLinks;
import no.vegvesen.vt.vu.proof.domain.usecases.alternative.FindAlternativeUseCase;
import no.vegvesen.vt.vu.proof.domain.usecases.alternative.RunAlternativeUseCase;
import no.vegvesen.vt.vu.proof.domain.usecases.modules.*;
import no.vegvesen.vt.vu.proof.domain.usecases.reflink.GenerateRefLinksUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public GenerateRefLinksUseCase generateRefLinksUseCase(RefLinks refLinks) {
        return new GenerateRefLinksUseCase(refLinks);
    }

    @Bean
    public FindAlternativeUseCase findAlternativeUseCase(CostBenefitAlternatives alternatives) {
        return new FindAlternativeUseCase(alternatives);
    }

    @Bean
    public RunAlternativeUseCase runAlternativeUseCase(Producer producer,
                                                       FindAlternativeUseCase findAlternativeUseCase,
                                                       GenerateRefLinksUseCase generateRefLinksUseCase) {
        return new RunAlternativeUseCase(producer, findAlternativeUseCase, generateRefLinksUseCase);
    }

    @Bean
    public EconomicCostBenefitComputationUseCase economicCostBenefitComputationUseCase(Producer producer) {
        return new EconomicCostBenefitComputationUseCase(producer);
    }

    @Bean
    public EnvironmentCostBenefitComputationUseCase environmentCostBenefitComputationUseCase(Producer producer) {
        return new EnvironmentCostBenefitComputationUseCase(producer);
    }

    @Bean
    public SafetyCostBenefitComputationUseCase safetyCostBenefitComputationUseCase(Producer producer) {
        return new SafetyCostBenefitComputationUseCase(producer);
    }

    @Bean
    public TrafficCostBenefitComputationUseCase trafficCostBenefitComputationUseCase(Producer producer) {
        return new TrafficCostBenefitComputationUseCase(producer);
    }

    @Bean
    public TransportCostBenefitComputationUseCase transportCostBenefitComputationUseCase(Producer producer) {
        return new TransportCostBenefitComputationUseCase(producer);
    }
}
