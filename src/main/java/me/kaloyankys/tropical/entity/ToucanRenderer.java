package me.kaloyankys.tropical.entity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ToucanRenderer extends MobEntityRenderer<ToucanEntity, ToucanModel> {

    public ToucanRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new ToucanModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(ToucanEntity entity) {
        return new Identifier("tropical", "textures/entity/toucan/toucan.png");
    }
    @Override
    public void render(ToucanEntity toucan, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i)
    {
        shadowRadius = 0.8F;
        matrixStack.push();
        if(toucan.isBaby())
        {
            matrixStack.scale(0.7F, 0.7F, 0.7F);
            shadowRadius = 0.4F;
        }

        super.render(toucan, f, g, matrixStack, vertexConsumerProvider, i);

        matrixStack.pop();
    }
}