package svenhjol.charmony.echolocation.client.features.echolocation;

import svenhjol.charmony.echolocation.common.features.echolocation.Echolocation;
import svenhjol.charmony.echolocation.common.features.echolocation.Registers;

public final class Common {
    public final Registers registers;

    public Common() {
        var feature = Echolocation.feature();
        registers = feature.registers;
    }
}
