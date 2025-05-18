package svenhjol.charmony.echolocation.client.features.ore_sensing;

import svenhjol.charmony.api.core.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.api.core.Side;

import java.util.function.Supplier;

@FeatureDefinition(side = Side.Client, canBeDisabledInConfig = false)
public final class OreSensing extends SidedFeature {
    public final Supplier<Common> common;
    public final Registers registers;

    public OreSensing(Mod mod) {
        super(mod);
        common = Common::new;
        registers = new Registers(this);
    }
}
