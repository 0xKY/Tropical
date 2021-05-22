package me.kaloyankys.tropical.init;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;

import java.util.OptionalInt;

public class ModWorldGen {

    //Trees
    public static final ConfiguredFeature<TreeFeatureConfig, ?> COCONUT_TREE = Feature.TREE.configure((new TreeFeatureConfig.Builder
            (new SimpleBlockStateProvider(ModBlocks.TROPICAL_LOG.getDefaultState()), new SimpleBlockStateProvider(ModBlocks.COCONUT_LEAVES.getDefaultState()),
                    new LargeOakFoliagePlacer(UniformIntDistribution.of(1), UniformIntDistribution.of(2), 4),
                    new LargeOakTrunkPlacer(5, 10, 1),
                    new TwoLayersFeatureSize(2, 0, 0, OptionalInt.of(3))).build()));

    //Random Patches
    public static final ConfiguredFeature<?, ?> FLOTSAM_GRASS_PATCH = Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder
            (new SimpleBlockStateProvider(ModBlocks.FLOTSAM_GRASS.getDefaultState()), SimpleBlockPlacer.INSTANCE)).tries(18).build());

    public ModWorldGen() {

        //Trees
        RegistryKey<ConfiguredFeature<?, ?>> coconutTree = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("tropical", "coconut_tree"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, coconutTree.getValue(),  COCONUT_TREE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BEACH), GenerationStep.Feature.VEGETAL_DECORATION, coconutTree);

        //Random Patches
        RegistryKey<ConfiguredFeature<?, ?>> flotsamGrassPatch = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("tropical", "flotsam__grass_patch"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, flotsamGrassPatch.getValue(),  FLOTSAM_GRASS_PATCH);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.BEACH), GenerationStep.Feature.VEGETAL_DECORATION, flotsamGrassPatch);
    }
}
