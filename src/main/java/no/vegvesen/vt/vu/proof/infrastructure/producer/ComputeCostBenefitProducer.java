package no.vegvesen.vt.vu.proof.infrastructure.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.vegvesen.vt.vu.proof.domain.api.Producer;
import no.vegvesen.vt.vu.proof.domain.model.commands.CalculateCostBenefit;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ComputeCostBenefitProducer implements Producer {

    private final StreamBridge streamBridge;

    @Override
    public void dispatch(CalculateCostBenefit command) {
        command.alternative().modules().forEach(costModule -> {
            switch (costModule.type()) {
                case TRANSPORTMODULE -> streamBridge.send("calculate-transport-cost-benefit", command);
                case ENVIRONMENTMODULE -> streamBridge.send("calculate-environment-cost-benefit", command);
                case SAFETYMODULE -> streamBridge.send("calculate-safety-cost-benefit", command);
                case ECONOMICMODULE -> streamBridge.send("calculate-economic-cost-benefit", command);
                case TRAFFICMODULE -> streamBridge.send("calculate-traffic-cost-benefit", command);
                default -> log.error("Unknown cost module type: {}", costModule.type());
            }
        });
    }
}
