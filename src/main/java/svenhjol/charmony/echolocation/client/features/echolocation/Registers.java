package svenhjol.charmony.echolocation.client.features.echolocation;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import svenhjol.charmony.core.base.Setup;

public final class Registers extends Setup<Echolocation> {
    public Registers(Echolocation feature) {
        super(feature);
        var common = feature.common.get();

        EntityRendererRegistry.register(common.registers.glowingBlockEntity.get(), GlowingBlockEntityRenderer::new);
    }
}
