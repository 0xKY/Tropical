package me.kaloyankys.tropical.entity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ChimpRenderer extends MobEntityRenderer<ChimpEntity, ChimpModel> {

    public ChimpRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new ChimpModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(ChimpEntity entity) {
        return new Identifier("tropical", "textures/entity/chimp/chimp.png");
    }
    @Override
    public void render(ChimpEntity chimp, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i)
    {
        shadowRadius = 0.25F;
        matrixStack.push();
        if(chimp.isBaby())
        {
            matrixStack.scale(0.5F, 0.5F, 0.5F);
            shadowRadius = 0.1F;
        }

        super.render(chimp, f, g, matrixStack, vertexConsumerProvider, i);

        matrixStack.pop();
    }

}