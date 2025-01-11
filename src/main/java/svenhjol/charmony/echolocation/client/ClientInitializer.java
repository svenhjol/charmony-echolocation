package svenhjol.charmony.echolocation.client;

import net.fabricmc.api.ClientModInitializer;
import svenhjol.charmony.core.enums.Side;
import svenhjol.charmony.echolocation.EcholocationMod;
import svenhjol.charmony.echolocation.client.features.echolocation.Echolocation;

public final class ClientInitializer implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Ensure charmony is launched first.
        svenhjol.charmony.core.client.ClientInitializer.init();

        // Prepare and run the mod.
        var mod = EcholocationMod.instance();
        mod.addSidedFeature(Echolocation.class);
        mod.run(Side.Client);
    }
}
