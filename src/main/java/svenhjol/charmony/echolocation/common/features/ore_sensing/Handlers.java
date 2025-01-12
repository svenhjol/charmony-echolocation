package svenhjol.charmony.echolocation.common.features.ore_sensing;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import svenhjol.charmony.core.base.Setup;

public final class Handlers extends Setup<OreSensing> {
    public static final int CHECK_TICKS = 20;
    public static final int BLOCK_HORIZONTAL_GLOW_RANGE = 16;
    public static final int BLOCK_VERTICAL_GLOW_RANGE = 32;

    public Handlers(OreSensing feature) {
        super(feature);
    }

    public void playerTick(Player player) {
        var level = player.level();
        if (!level.isClientSide()
            && level.getGameTime() % CHECK_TICKS == 0
            && player.hasEffect(feature().registers.oreSensingEffect.get())
        ) {
            var positions = BlockPos.withinManhattan(player.blockPosition(), BLOCK_HORIZONTAL_GLOW_RANGE, BLOCK_VERTICAL_GLOW_RANGE, BLOCK_HORIZONTAL_GLOW_RANGE);
            for (var pos : positions) {
                if (level.getBlockState(pos).is(Tags.GLOWING_ORES)) {
                    var entity = new GlowingBlockEntity(level, pos, CHECK_TICKS);
                    level.addFreshEntity(entity);
                }
            }
        }
    }
}
