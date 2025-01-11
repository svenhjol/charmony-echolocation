package svenhjol.charmony.echolocation.common.features.echolocation;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class EcholocationEffect extends MobEffect {
    protected EcholocationEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x667766);
    }
}
