package svenhjol.charmony.echolocation.client.features.ore_sensing;

import svenhjol.charmony.echolocation.common.features.ore_sensing.OreSensing;
import svenhjol.charmony.echolocation.common.features.ore_sensing.Registers;

public final class Common {
    public final Registers registers;

    public Common() {
        var feature = OreSensing.feature();
        registers = feature.registers;
    }
}
