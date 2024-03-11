package net.aelion.birds_and_feathers.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.aelion.birds_and_feathers.BirdsAndFeathers;
import net.aelion.birds_and_feathers.entity.custom.Crow;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrowRenderer extends MobRenderer<Crow, CrowModel<Crow>> {
    public CrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CrowModel<>(pContext.bakeLayer(ModModelLayers.CROW_LAYER)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(Crow pEntity) {
        return new ResourceLocation(BirdsAndFeathers.MOD_ID, "textures/entity/crow.png");
    }

    @Override
    public void render(Crow pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }
        else {
            // TODO: tweak size ?
            pPoseStack.scale(1.2f, 1.2f, 1.2f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
