package me.kaloyankys.tropical.client;

import me.kaloyankys.tropical.entity.CocoCrabRenderer;
import me.kaloyankys.tropical.init.ModBlocks;
import me.kaloyankys.tropical.init.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class TropicalClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.FLOTSAM_GRASS, ModBlocks.COCONUT_OPEN, ModBlocks.COCONUT_LEAVES);
        EntityRendererRegistry.INSTANCE.register(ModEntities.COCONUT_CRAB, (dispatcher, context) -> {
            return new CocoCrabRenderer(dispatcher);
        });
    }
}

