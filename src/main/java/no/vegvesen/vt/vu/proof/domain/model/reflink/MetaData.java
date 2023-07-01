package no.vegvesen.vt.vu.proof.domain.model.reflink;

import java.time.LocalDate;

public record MetaData(
        Integer id,
        LocalDate createdAt,
        LocalDate lastModifiedAt
) {
}
