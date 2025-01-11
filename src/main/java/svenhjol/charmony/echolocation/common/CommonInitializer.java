package svenhjol.charmony.echolocation.common;

import net.fabricmc.api.ModInitializer;
import svenhjol.charmony.core.enums.Side;
import svenhjol.charmony.echolocation.EcholocationMod;
import svenhjol.charmony.echolocation.common.features.echolocation.Echolocation;

public final class CommonInitializer implements ModInitializer {
    @Override
    public void onInitialize() {
        // Ensure charmony is launched first.
        svenhjol.charmony.core.common.CommonInitializer.init();

        // Prepare and run the mod.
        var mod = EcholocationMod.instance();
        mod.addSidedFeature(Echolocation.class);
        mod.run(Side.Common);
    }
}
