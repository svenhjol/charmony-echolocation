package svenhjol.charmony.echolocation.integration;

import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.integration.BaseModMenuPlugin;
import svenhjol.charmony.echolocation.EcholocationMod;

public class ModMenuPlugin extends BaseModMenuPlugin {
    @Override
    public Mod mod() {
        return EcholocationMod.instance();
    }
}
