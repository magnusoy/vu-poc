package no.vegvesen.vt.vu.proof.domain.model.alternative;

public record CostModule(
        Type type,
        CostModule nextModule
) {
    public enum Type {
        TRANSPORTMODULE,
        TRAFFICMODULE,
        ENVIRONMENTMODULE,
        SAFETYMODULE,
        ECONOMICMODULE
    }

    public static CostModule of(Type type, CostModule nextModule) {
        return new CostModule(type, nextModule);
    }

    public boolean hasNext() {
        return this.nextModule != null;
    }

    public CostModule next() {
        return this.nextModule;
    }
}
