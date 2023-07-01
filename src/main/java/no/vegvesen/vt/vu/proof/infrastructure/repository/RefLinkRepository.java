package no.vegvesen.vt.vu.proof.infrastructure.repository;

import no.vegvesen.vt.vu.proof.domain.api.RefLinks;
import no.vegvesen.vt.vu.proof.domain.model.reflink.RefLink;
import no.vegvesen.vt.vu.proof.domain.model.reflink.RefLinkFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.IntStream;

@Repository
public class RefLinkRepository implements RefLinks {

    @Override
    public List<RefLink> generate(int numberOfRefLinks) {
        return IntStream.rangeClosed(1, numberOfRefLinks)
                .mapToObj(RefLinkFactory::random)
                .toList();
    }
}
