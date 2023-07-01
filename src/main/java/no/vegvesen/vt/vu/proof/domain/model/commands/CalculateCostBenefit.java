package no.vegvesen.vt.vu.proof.domain.model.commands;

import no.vegvesen.vt.vu.proof.domain.model.alternative.CostBenefitAlternative;
import no.vegvesen.vt.vu.proof.domain.model.reflink.RefLink;

public record CalculateCostBenefit(
        CostBenefitAlternative alternative,
        RefLink refLink
) {

    public CalculateCostBenefit next() {
        return new CalculateCostBenefit(alternative.prepareForNext(), refLink);
    }
}
