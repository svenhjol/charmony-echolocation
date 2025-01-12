package svenhjol.charmony.echolocation.common.features.mob_sensing;

import svenhjol.charmony.core.annotations.Configurable;
import svenhjol.charmony.core.annotations.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.core.enums.Side;
import svenhjol.charmony.echolocation.EcholocationMod;

@FeatureDefinition(side = Side.Common, description = """
    Allows the player to see the outline of mobs in the world when the Mob Sensing effect is applied.""")
public final class MobSensing extends SidedFeature {
    public final Registers registers;
    public final Handlers handlers;

    @Configurable(
        name = "Register potion",
        description = """
            If true, potion recipes will be added for mob sensing.
            This should be added if you intend the use this as a standalone feature.
            Brew a mob sensing potion using a torch flower with an awkward potion base."""
    )
    private static boolean registerPotion = false;

    public MobSensing(Mod mod) {
        super(mod);
        registers = new Registers(this);
        handlers = new Handlers(this);
    }

    public static MobSensing feature() {
        return EcholocationMod.instance().sidedFeature(MobSensing.class);
    }

    public boolean registerPotion() {
        return registerPotion;
    }
}
