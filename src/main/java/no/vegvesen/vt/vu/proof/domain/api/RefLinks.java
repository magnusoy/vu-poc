package no.vegvesen.vt.vu.proof.domain.api;

import no.vegvesen.vt.vu.proof.domain.model.reflink.RefLink;

import java.util.List;

public interface RefLinks {

    List<RefLink> generate(int numberOfRefLinks);
}
