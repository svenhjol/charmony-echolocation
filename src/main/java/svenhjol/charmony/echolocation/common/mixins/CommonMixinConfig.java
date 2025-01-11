package svenhjol.charmony.echolocation.common.mixins;

import svenhjol.charmony.core.base.MixinConfig;
import svenhjol.charmony.core.enums.Side;
import svenhjol.charmony.echolocation.EcholocationMod;

public class CommonMixinConfig extends MixinConfig {
    @Override
    protected String modId() {
        return EcholocationMod.ID;
    }

    @Override
    protected String modRoot() {
        return "svenhjol.charmony.echolocation";
    }

    @Override
    protected Side side() {
        return Side.Common;
    }
}
