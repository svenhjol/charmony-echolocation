package svenhjol.charmony.echolocation.client.features.ore_sensing;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import svenhjol.charmony.core.base.Setup;

public final class Registers extends Setup<OreSensing> {
    public Registers(OreSensing feature) {
        super(feature);
        var common = feature.common.get();

        EntityRendererRegistry.register(common.registers.glowingBlockEntity.get(), GlowingBlockEntityRenderer::new);
    }
}
