package svenhjol.charmony.echolocation.common.features.mob_sensing;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import svenhjol.charmony.core.base.Registerable;
import svenhjol.charmony.core.base.Setup;
import svenhjol.charmony.core.common.CommonRegistry;
import svenhjol.charmony.api.events.PlayerTickCallback;

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

            if (feature().registerPotion()) {
                registerPotion();
            }
        };
    }

    private void registerPotion() {
        var registry = CommonRegistry.forFeature(feature());

        var potionId = "mob_sensing";
        var longPotionId = "long_mob_sensing";

        var potion = registry.potion(potionId, () -> new MobSensingPotion(potionId));
        var longPotion = registry.potion(longPotionId, () -> new LongMobSensingPotion(longPotionId));

        registry.potionRecipe(
            Potions.AWKWARD,
            () -> Items.TORCHFLOWER,
            potion.get());

        registry.potionRecipe(
            potion.get(),
            () -> Items.REDSTONE,
            longPotion.get());
    }
}
