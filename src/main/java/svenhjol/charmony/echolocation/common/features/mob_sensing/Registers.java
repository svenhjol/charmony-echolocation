package svenhjol.charmony.echolocation.common.features.mob_sensing;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import svenhjol.charmony.core.base.Registerable;
import svenhjol.charmony.core.base.Setup;
import svenhjol.charmony.core.common.CommonRegistry;
import svenhjol.charmony.core.events.PlayerTickCallback;

import java.util.function.Supplier;

public final class Registers extends Setup<MobSensing> {
    public final Supplier<Holder<MobEffect>> mobSensingEffect;

    public Registers(MobSensing feature) {
        super(feature);
        var registry = CommonRegistry.forFeature(feature);

        mobSensingEffect = new Registerable<>(feature,
            () -> Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT,
                feature.id("mob_sensing"), new MobSensingEffect()));
    }

    @Override
    public Runnable boot() {
        return () -> {
            PlayerTickCallback.EVENT.register(feature().handlers::playerTick);
        };
    }
}
