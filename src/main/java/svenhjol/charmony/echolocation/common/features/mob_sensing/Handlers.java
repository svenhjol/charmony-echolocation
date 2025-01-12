package svenhjol.charmony.echolocation.common.features.mob_sensing;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import svenhjol.charmony.core.base.Setup;

public final class Handlers extends Setup<MobSensing> {
    public static final int CHECK_TICKS = 20;
    public static final int ENTITY_GLOW_RANGE = 24;

    public Handlers(MobSensing feature) {
        super(feature);
    }

    public void playerTick(Player player) {
        if (!player.level().isClientSide()
            && player.level().getGameTime() % CHECK_TICKS == 0
            && player.hasEffect(feature().registers.mobSensingEffect.get())
        ) {
            var box = player.getBoundingBox().inflate(ENTITY_GLOW_RANGE, ENTITY_GLOW_RANGE / 2.0, ENTITY_GLOW_RANGE);
            var effect = new MobEffectInstance(MobEffects.GLOWING, CHECK_TICKS);
            var entities = player.level().getEntitiesOfClass(LivingEntity.class, box);

            for (LivingEntity entity : entities) {
                if (entity.getUUID().equals(player.getUUID())) continue;
                if (entity.canBeAffected(effect)) {
                    entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, CHECK_TICKS + 5, 0, false, true), player);
                }
            }
        }
    }
}
