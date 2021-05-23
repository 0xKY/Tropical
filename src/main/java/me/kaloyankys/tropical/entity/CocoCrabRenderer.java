package me.kaloyankys.tropical.entity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CocoCrabRenderer extends MobEntityRenderer<CocoCrabEntity, CocoCrabModel> {

    public CocoCrabRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new CocoCrabModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(CocoCrabEntity entity) {
        return new Identifier("tropical", "textures/entity/coconut_crab/coconut_crab.png");
    }
    @Override
    public void render(CocoCrabEntity cocoCrab, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i)
    {
        shadowRadius = 0.25F;
        matrixStack.push();
        if(cocoCrab.isBaby())
        {
            matrixStack.scale(0.5F, 0.5F, 0.5F);
            shadowRadius = 0.1F;
        }

        super.render(cocoCrab, f, g, matrixStack, vertexConsumerProvider, i);

        matrixStack.pop();
    }

}