package no.vegvesen.vt.vu.proof.infrastructure.consumer;

import lombok.RequiredArgsConstructor;
import no.vegvesen.vt.vu.proof.domain.model.commands.CalculateCostBenefit;
import no.vegvesen.vt.vu.proof.domain.usecases.UseCaseExecutor;
import no.vegvesen.vt.vu.proof.domain.usecases.modules.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class CostBenefitCalculationConsumer {

    private final UseCaseExecutor useCaseExecutor;

    @Bean
    public Consumer<CalculateCostBenefit> economicCostBenefitConsumer(EconomicCostBenefitComputationUseCase useCase) {
        return command -> useCaseExecutor.execute(
                useCase,
                new EconomicCostBenefitComputationUseCase.InputValues(command.alternative(), command.refLink()),
                outputValues -> null);
    }

    @Bean
    public Consumer<CalculateCostBenefit> environmentCostBenefitConsumer(EnvironmentCostBenefitComputationUseCase useCase) {
        return command -> useCaseExecutor.execute(
                useCase,
                new EnvironmentCostBenefitComputationUseCase.InputValues(command.alternative(), command.refLink()),
                outputValues -> null);
    }

    @Bean
    public Consumer<CalculateCostBenefit> safetyCostBenefitConsumer(SafetyCostBenefitComputationUseCase useCase) {
        return command -> useCaseExecutor.execute(
                useCase,
                new SafetyCostBenefitComputationUseCase.InputValues(command.alternative(), command.refLink()),
                outputValues -> null);
    }

    @Bean
    public Consumer<CalculateCostBenefit> trafficCostBenefitConsumer(TrafficCostBenefitComputationUseCase useCase) {
        return command -> useCaseExecutor.execute(
                useCase,
                new TrafficCostBenefitComputationUseCase.InputValues(command.alternative(), command.refLink()),
                outputValues -> null);
    }

    @Bean
    public Consumer<CalculateCostBenefit> transportCostBenefitConsumer(TransportCostBenefitComputationUseCase useCase) {
        return command -> useCaseExecutor.execute(
                useCase,
                new TransportCostBenefitComputationUseCase.InputValues(command.alternative(), command.refLink()),
                outputValues -> null);
    }
}
