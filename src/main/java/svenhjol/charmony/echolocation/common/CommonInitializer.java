package svenhjol.charmony.echolocation.common;

import net.fabricmc.api.ModInitializer;
import svenhjol.charmony.api.core.Side;
import svenhjol.charmony.echolocation.EcholocationMod;
import svenhjol.charmony.echolocation.common.features.mob_sensing.MobSensing;
import svenhjol.charmony.echolocation.common.features.ore_sensing.OreSensing;

public final class CommonInitializer implements ModInitializer {
    @Override
    public void onInitialize() {
        // Ensure charmony is launched first.
        svenhjol.charmony.core.common.CommonInitializer.init();

        // Prepare and run the mod.
        var mod = EcholocationMod.instance();
        mod.addSidedFeature(MobSensing.class);
        mod.addSidedFeature(OreSensing.class);
        mod.run(Side.Common);
    }
}
