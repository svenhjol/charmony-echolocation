package svenhjol.charmony.echolocation.client;

import net.fabricmc.api.ClientModInitializer;
import svenhjol.charmony.api.core.Side;
import svenhjol.charmony.echolocation.EcholocationMod;
import svenhjol.charmony.echolocation.client.features.ore_sensing.OreSensing;

public final class ClientInitializer implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Ensure charmony is launched first.
        svenhjol.charmony.core.client.ClientInitializer.init();

        // Prepare and run the mod.
        var mod = EcholocationMod.instance();
        mod.addSidedFeature(OreSensing.class);
        mod.run(Side.Client);
    }
}
