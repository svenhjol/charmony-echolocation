package svenhjol.charmony.echolocation.common.features.ore_sensing;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class OreSensingEffect extends MobEffect {
    protected OreSensingEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x889988);
    }
}
