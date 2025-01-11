package svenhjol.charmony.echolocation.common.features.echolocation;

import svenhjol.charmony.core.annotations.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.core.enums.Side;
import svenhjol.charmony.echolocation.EcholocationMod;

@FeatureDefinition(side = Side.Common)
public final class Echolocation extends SidedFeature {
    public final Registers registers;
    public final Handlers handlers;

    public Echolocation(Mod mod) {
        super(mod);
        registers = new Registers(this);
        handlers = new Handlers(this);
    }

    public static Echolocation feature() {
        return EcholocationMod.instance().sidedFeature(Echolocation.class);
    }
}
