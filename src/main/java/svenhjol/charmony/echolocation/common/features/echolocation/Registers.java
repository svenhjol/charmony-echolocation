package svenhjol.charmony.echolocation.common.features.echolocation;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import svenhjol.charmony.core.base.Registerable;
import svenhjol.charmony.core.base.Setup;
import svenhjol.charmony.core.common.CommonRegistry;
import svenhjol.charmony.core.events.PlayerTickCallback;

import java.util.function.Supplier;

public final class Registers extends Setup<Echolocation> {
    public final Supplier<Holder<MobEffect>> echolocationEffect;
    public final Supplier<EntityType<GlowingBlockEntity>> glowingBlockEntity;

    public Registers(Echolocation feature) {
        super(feature);
        var registry = CommonRegistry.forFeature(feature);

        glowingBlockEntity = registry.entity("glowing_block", () -> EntityType.Builder
            .<GlowingBlockEntity>of(GlowingBlockEntity::new, MobCategory.MISC)
            .sized(1.0f, 1.0f)
            .clientTrackingRange(GlowingBlockEntity.TRACKING_RANGE)
            .updateInterval(1));

        echolocationEffect = new Registerable<>(feature,
            () -> Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT,
                feature.id("echolocation"), new EcholocationEffect()));
    }

    @Override
    public Runnable boot() {
        return () -> {
            PlayerTickCallback.EVENT.register(feature().handlers::playerTick);
        };
    }
}
