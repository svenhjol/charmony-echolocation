package svenhjol.charmony.echolocation.common.features.mob_sensing;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

public class MobSensingPotion extends Potion {
    public MobSensingPotion(String id) {
        super(id, new MobEffectInstance(MobSensing.feature().registers.mobSensingEffect.get(), 600));
    }
}
