package svenhjol.charmony.echolocation.common.features.mob_sensing;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

public class LongMobSensingPotion extends Potion {
    public LongMobSensingPotion(String id) {
        super(id, new MobEffectInstance(MobSensing.feature().registers.mobSensingEffect.get(), 1200));
    }
}
