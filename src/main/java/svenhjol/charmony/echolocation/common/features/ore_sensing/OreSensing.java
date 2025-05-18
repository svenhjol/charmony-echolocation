package svenhjol.charmony.echolocation.common.features.ore_sensing;

import net.minecraft.util.Mth;
import svenhjol.charmony.api.core.Configurable;
import svenhjol.charmony.api.core.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.api.core.Side;

@FeatureDefinition(side = Side.Common, description = """
    Allows the player to see the outline of ores in the world when the Ore Sensing effect is applied.""")
@SuppressWarnings({"FieldMayBeFinal", "FieldCanBeLocal"})
public final class OreSensing extends SidedFeature {
    public final Registers registers;
    public final Handlers handlers;

    @Configurable(
        name = "Register potion",
        description = """
            If true, potion recipes will be added for ore sensing.
            This should be added if you intend the use this as a standalone feature.
            Brew an ore sensing potion using an echo shard with an awkward potion base."""
    )
    private static boolean registerPotion = false;

    @Configurable(
        name = "Colored outlines",
        description = "If true, the outline of the ore corresponds to the ore type.",
        requireRestart = false
    )
    private static boolean coloredOutlines = true;

    @Configurable(
        name = "Horizontal sensing distance",
        description = "Distance in blocks horizontally around the player in which ores will be highlighted.",
        requireRestart = false
    )
    private static int horizontalDistance = 16;

    @Configurable(
        name = "Vertical sensing distance",
        description = "Distance in blocks vertically around the player in which ores will be highlighted.",
        requireRestart = false
    )
    private static int verticalDistance = 32;

    public OreSensing(Mod mod) {
        super(mod);
        registers = new Registers(this);
        handlers = new Handlers(this);
    }

    public static OreSensing feature() {
        return Mod.getSidedFeature(OreSensing.class);
    }

    public boolean registerPotion() {
        return registerPotion;
    }

    public boolean coloredOutlines() {
        return coloredOutlines;
    }

    public int horizontalDistance() {
        return Mth.clamp(horizontalDistance, 1, 256);
    }

    public int verticalDistance() {
        return Mth.clamp(verticalDistance, 1, 256);
    }
}
