package no.vegvesen.vt.vu.proof.domain.api;

import no.vegvesen.vt.vu.proof.domain.model.commands.CalculateCostBenefit;

public interface Producer {

    void dispatch(CalculateCostBenefit command);
}
