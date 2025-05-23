package svenhjol.charmony.echolocation.common.features.mob_sensing;

import svenhjol.charmony.api.core.Configurable;
import svenhjol.charmony.api.core.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.api.core.Side;

@FeatureDefinition(side = Side.Common, description = """
    Allows the player to see the outline of mobs in the world when the Mob Sensing effect is applied.""")
@SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
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
        return Mod.getSidedFeature(MobSensing.class);
    }

    public boolean registerPotion() {
        return registerPotion;
    }
}
