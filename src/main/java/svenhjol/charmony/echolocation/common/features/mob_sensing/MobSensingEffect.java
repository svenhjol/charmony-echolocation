package svenhjol.charmony.echolocation.common.features.mob_sensing;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class MobSensingEffect extends MobEffect {
    protected MobSensingEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x667766);
    }
}
