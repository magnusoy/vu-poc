package no.vegvesen.vt.vu.proof.domain.model.reflink;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.MODULE)
public class RefLink {

    private MetaData metaData;
    private Location location;
    private Status status;

}
