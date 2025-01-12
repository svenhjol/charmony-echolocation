package svenhjol.charmony.echolocation.common.features.ore_sensing;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import svenhjol.charmony.core.base.Setup;

public final class Handlers extends Setup<OreSensing> {
    public static final int CHECK_TICKS = 20;

    public Handlers(OreSensing feature) {
        super(feature);
    }

    public void playerTick(Player player) {
        var level = player.level();
        if (!level.isClientSide()
            && level.getGameTime() % CHECK_TICKS == 0
            && player.hasEffect(feature().registers.oreSensingEffect.get())
        ) {
            var h = feature().horizontalDistance();
            var v = feature().verticalDistance();
            var positions = BlockPos.withinManhattan(player.blockPosition(), h, v, h);
            for (var pos : positions) {
                if (level.getBlockState(pos).is(Tags.SENSED_ORES)) {
                    var entity = new GlowingBlockEntity(level, pos, CHECK_TICKS);
                    level.addFreshEntity(entity);
                }
            }
        }
    }
}
