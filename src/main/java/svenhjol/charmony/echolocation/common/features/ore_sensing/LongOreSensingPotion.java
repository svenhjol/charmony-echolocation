package svenhjol.charmony.echolocation.common.features.ore_sensing;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

public class LongOreSensingPotion extends Potion {
    public LongOreSensingPotion(String id) {
        super(id, new MobEffectInstance(OreSensing.feature().registers.oreSensingEffect.get(), 300));
    }
}
