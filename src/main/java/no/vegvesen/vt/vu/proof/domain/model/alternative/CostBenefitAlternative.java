package no.vegvesen.vt.vu.proof.domain.model.alternative;

import java.util.Set;
import java.util.stream.Collectors;

public record CostBenefitAlternative(
        Integer id,
        String name,
        String description,
        Set<CostModule> modules
) {
    public static CostBenefitAlternative create(Integer id, String name, String description, Set<CostModule> modules) {
        return new CostBenefitAlternative(id, name, description, modules);
    }

    public CostBenefitAlternative prepareForNext() {
        return new CostBenefitAlternative(this.id, this.name, this.description, this.modules.stream()
                .filter(CostModule::hasNext)
                .map(CostModule::next)
                .collect(Collectors.toSet()));
    }
}
