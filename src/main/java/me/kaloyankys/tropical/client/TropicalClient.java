package me.kaloyankys.tropical.client;

import me.kaloyankys.tropical.entity.CocoCrabModel;
import me.kaloyankys.tropical.entity.CocoCrabRenderer;
import me.kaloyankys.tropical.init.ModBlocks;
import me.kaloyankys.tropical.init.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class TropicalClient implements ClientModInitializer {

    public static final EntityModelLayer CRAB_LAYER = new EntityModelLayer(new Identifier("tropical", "coconut_crab"), "main");

    @Override
    public void onInitializeClient() {


        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.MARRAM_GRASS, ModBlocks.COCONUT_OPEN, ModBlocks.COCONUT_PALM_CROWN);


        EntityRendererRegistry.INSTANCE.register(ModEntities.COCONUT_CRAB, (context) -> {
            return new CocoCrabRenderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(CRAB_LAYER, CocoCrabModel::getTexturedModelData);
    }
}

