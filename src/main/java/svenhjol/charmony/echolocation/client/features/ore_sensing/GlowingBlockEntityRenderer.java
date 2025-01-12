package svenhjol.charmony.echolocation.client.features.ore_sensing;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.ItemEntityRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import svenhjol.charmony.echolocation.common.features.ore_sensing.GlowingBlockEntity;

class GlowingBlockEntityRenderer extends EntityRenderer<GlowingBlockEntity, ItemEntityRenderState> {
    private final ItemModelResolver itemModelResolver;

    public GlowingBlockEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemModelResolver = context.getItemModelResolver();
    }

    @Override
    public ItemEntityRenderState createRenderState() {
        return new ItemEntityRenderState();
    }

    @Override
    public void extractRenderState(GlowingBlockEntity entity, ItemEntityRenderState renderState, float f) {
        super.extractRenderState(entity, renderState, f);
        var itemEntity = new ItemEntity(entity.level(), entity.getX(), entity.getY(), entity.getZ(), new ItemStack(Blocks.BLACK_CONCRETE));
        renderState.extractItemGroupRenderState(itemEntity, itemEntity.getItem(), itemModelResolver);
    }

    @Override
    public void render(ItemEntityRenderState renderState, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        if (!renderState.item.isEmpty()) {
            var stackRenderState = renderState.item;
            poseStack.pushPose();
            var scaleFactor = 3.5f;
            poseStack.scale(scaleFactor, scaleFactor, scaleFactor);
            stackRenderState.render(poseStack, multiBufferSource, i, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
            super.render(renderState, poseStack, multiBufferSource, i);
        }
    }

    @Override
    protected boolean affectedByCulling(GlowingBlockEntity entity) {
        return true;
    }
}
