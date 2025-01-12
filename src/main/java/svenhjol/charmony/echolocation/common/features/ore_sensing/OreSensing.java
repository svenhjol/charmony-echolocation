package svenhjol.charmony.echolocation.common.features.ore_sensing;

import net.minecraft.util.Mth;
import svenhjol.charmony.core.annotations.Configurable;
import svenhjol.charmony.core.annotations.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.core.enums.Side;
import svenhjol.charmony.echolocation.EcholocationMod;

@FeatureDefinition(side = Side.Common, description = """
    Allows the player to see the outline of ores in the world when the Ore Sensing mob effect is applied.""")
public final class OreSensing extends SidedFeature {
    public final Registers registers;
    public final Handlers handlers;

    @Configurable(
        name = "Colored outlines",
        description = "If true, the outline of the ore corresponds to the ore type.",
        requireRestart = false
    )
    private static final boolean coloredOutlines = true;

    @Configurable(
        name = "Horizontal sensing distance",
        description = "Distance in blocks horizontally around the player in which ores will be highlighted.",
        requireRestart = false
    )
    private static final int horizontalDistance = 16;

    @Configurable(
        name = "Vertical sensing distance",
        description = "Distance in blocks vertically around the player in which ores will be highlighted.",
        requireRestart = false
    )
    private static final int verticalDistance = 32;

    public OreSensing(Mod mod) {
        super(mod);
        registers = new Registers(this);
        handlers = new Handlers(this);
    }

    public static OreSensing feature() {
        return EcholocationMod.instance().sidedFeature(OreSensing.class);
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
