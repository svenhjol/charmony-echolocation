package svenhjol.charmony.echolocation.common.features.echolocation;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;

public class GlowingBlockEntity extends Entity {
    public static final int TRACKING_RANGE = 16;
    private int ticks = 0;
    private int maxTicks = 100;

    public GlowingBlockEntity(EntityType<GlowingBlockEntity> entityType, Level level) {
        super(entityType, level);
        this.setGlowingTag(true);
    }

    public GlowingBlockEntity(Level level, BlockPos pos, int maxTicks) {
        super(Echolocation.feature().registers.glowingBlockEntity.get(), level);

        this.maxTicks = maxTicks;
        this.setGlowingTag(true);

        setPos(pos.getX() + 0.5d, pos.getY() - 0.15d, pos.getZ() + 0.5d);
    }

    @Override
    public int getTeamColor() {
        var state = level().getBlockState(blockPosition().above());

        if (state.is(Tags.BLACK_GLOWING_ORES)) {
            return DyeColor.BLACK.getTextureDiffuseColor();
        }
        if (state.is(Tags.BLUE_GLOWING_ORES)) {
            return DyeColor.BLUE.getTextureDiffuseColor();
        }
        if (state.is(Tags.BROWN_GLOWING_ORES)) {
            return DyeColor.BROWN.getTextureDiffuseColor();
        }
        if (state.is(Tags.CYAN_GLOWING_ORES)) {
            return DyeColor.CYAN.getTextureDiffuseColor();
        }
        if (state.is(Tags.GRAY_GLOWING_ORES)) {
            return DyeColor.GRAY.getTextureDiffuseColor();
        }
        if (state.is(Tags.GREEN_GLOWING_ORES)) {
            return DyeColor.GREEN.getTextureDiffuseColor();
        }
        if (state.is(Tags.LIGHT_BLUE_GLOWING_ORES)) {
            return DyeColor.LIGHT_BLUE.getTextureDiffuseColor();
        }
        if (state.is(Tags.LIGHT_GRAY_GLOWING_ORES)) {
            return DyeColor.LIGHT_GRAY.getTextureDiffuseColor();
        }
        if (state.is(Tags.LIME_GLOWING_ORES)) {
            return DyeColor.LIME.getTextureDiffuseColor();
        }
        if (state.is(Tags.MAGENTA_GLOWING_ORES)) {
            return DyeColor.MAGENTA.getTextureDiffuseColor();
        }
        if (state.is(Tags.ORANGE_GLOWING_ORES)) {
            return DyeColor.ORANGE.getTextureDiffuseColor();
        }
        if (state.is(Tags.PINK_GLOWING_ORES)) {
            return DyeColor.PINK.getTextureDiffuseColor();
        }
        if (state.is(Tags.PURPLE_GLOWING_ORES)) {
            return DyeColor.PURPLE.getTextureDiffuseColor();
        }
        if (state.is(Tags.RED_GLOWING_ORES)) {
            return DyeColor.RED.getTextureDiffuseColor();
        }
        if (state.is(Tags.WHITE_GLOWING_ORES)) {
            return DyeColor.WHITE.getTextureDiffuseColor();
        }
        if (state.is(Tags.YELLOW_GLOWING_ORES)) {
            return DyeColor.YELLOW.getTextureDiffuseColor();
        }

        return super.getTeamColor();
    }

    @Override
    public void tick() {
        super.tick();

        var level = level();
        if (!level.isClientSide() && ticks >= maxTicks) {
            remove(RemovalReason.DISCARDED);
        }

        ++ticks;
    }

    @Override
    public boolean isCurrentlyGlowing() {
        return true;
    }

    @Override
    public boolean hurtServer(ServerLevel serverLevel, DamageSource damageSource, float f) {
        return false;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        // no op
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        // no op
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        // no op
    }
}
