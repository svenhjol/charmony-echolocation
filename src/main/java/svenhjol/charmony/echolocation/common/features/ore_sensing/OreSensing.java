package svenhjol.charmony.echolocation.common.features.ore_sensing;

import svenhjol.charmony.core.annotations.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.core.enums.Side;
import svenhjol.charmony.echolocation.EcholocationMod;

@FeatureDefinition(side = Side.Common)
public final class OreSensing extends SidedFeature {
    public final Registers registers;
    public final Handlers handlers;

    public OreSensing(Mod mod) {
        super(mod);
        registers = new Registers(this);
        handlers = new Handlers(this);
    }

    public static OreSensing feature() {
        return EcholocationMod.instance().sidedFeature(OreSensing.class);
    }
}
