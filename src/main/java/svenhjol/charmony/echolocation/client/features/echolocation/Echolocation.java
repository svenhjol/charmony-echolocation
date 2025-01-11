package svenhjol.charmony.echolocation.client.features.echolocation;

import svenhjol.charmony.core.annotations.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.core.enums.Side;

import java.util.function.Supplier;

@FeatureDefinition(side = Side.Client)
public final class Echolocation extends SidedFeature {
    public final Supplier<Common> common;
    public final Registers registers;

    public Echolocation(Mod mod) {
        super(mod);
        common = Common::new;
        registers = new Registers(this);
    }
}
