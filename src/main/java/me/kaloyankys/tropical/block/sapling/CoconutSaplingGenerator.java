package me.kaloyankys.tropical.block.sapling;

import me.kaloyankys.tropical.init.ModWorldGen;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;

public class CoconutSaplingGenerator extends SaplingGenerator {
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> createTreeFeature(Random random, boolean bl) {
        return ModWorldGen.COCONUT_TREE;
    }
}
