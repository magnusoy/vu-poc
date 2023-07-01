package no.vegvesen.vt.vu.proof.domain.model.reflink;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.Random;

@UtilityClass
public class RefLinkFactory {

    public static RefLink random(int id) {
        return new RefLink(
                new MetaData(id, LocalDate.now(), LocalDate.now()),
                new Location(new Random().nextDouble(), new Random().nextDouble()),
                Status.ACTIVE
        );
    }
}
