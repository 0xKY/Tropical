package me.kaloyankys.tropical.init;

import com.sun.source.tree.Tree;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModWorldGen {

    //Trees
    public static final ConfiguredFeature<?, ?> COCONUT_TREE = Feature.TREE.configure((new TreeFeatureConfig.Builder
            (
                    new SimpleBlockStateProvider(Blocks.NETHERITE_BLOCK.getDefaultState()),
                    new StraightTrunkPlacer(8, 3, 0), // places a straight trunk
                    new SimpleBlockStateProvider(Blocks.DIAMOND_BLOCK.getDefaultState()),
                    new SimpleBlockStateProvider(Blocks.ACACIA_SAPLING.getDefaultState()),
                    new BlobFoliagePlacer(ConstantIntProvider.create(5), ConstantIntProvider.create(0), 3),
                    new TwoLayersFeatureSize(1, 0, 1)))
                    .build())
            .spreadHorizontally()
            .applyChance(3);

    //Random Patches
    public static final ConfiguredFeature<?, ?> FLOTSAM_GRASS_PATCH = Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder
            (new SimpleBlockStateProvider(ModBlocks.MARRAM_GRASS.getDefaultState()), SimpleBlockPlacer.INSTANCE)).tries(18).build());

    public ModWorldGen() {

        //Trees
        RegistryKey<ConfiguredFeature<?, ?>> coconutTree = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("tropical", "coconut_tree"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, coconutTree.getValue(),  COCONUT_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BEACH), GenerationStep.Feature.VEGETAL_DECORATION, coconutTree);
        RegistryKey<ConfiguredFeature<?, ?>> bananaTree = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("tropical", "banana_tree"));

        //Random Patches
        RegistryKey<ConfiguredFeature<?, ?>> flotsamGrassPatch = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("tropical", "flotsam__grass_patch"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, flotsamGrassPatch.getValue(),  FLOTSAM_GRASS_PATCH);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BEACH), GenerationStep.Feature.VEGETAL_DECORATION, flotsamGrassPatch);
    }
}
