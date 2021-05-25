package me.kaloyankys.tropical.init;

import me.kaloyankys.tropical.block.*;
import me.kaloyankys.tropical.block.coconut.CoconutEmptyBlock;
import me.kaloyankys.tropical.block.coconut.CoconutFruitBlock;
import me.kaloyankys.tropical.block.coconut.CoconutFruitHarvestableBlock;
import me.kaloyankys.tropical.block.coconut.CoconutOpenBlock;
import me.kaloyankys.tropical.block.sapling.CoconutSapling;
import me.kaloyankys.tropical.block.sapling.CoconutSaplingGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    /*
    Coconut
     */
    public static final Block COCONUT_FRUIT = register("coconut_fruit", new CoconutFruitBlock(FabricBlockSettings.of(Material.GOURD).strength(1.0f).ticksRandomly().sounds(BlockSoundGroup.BONE)));
    public static final Block COCONUT = register("coconut", new CoconutFruitHarvestableBlock(FabricBlockSettings.of(Material.GOURD).strength(1.0f).sounds(BlockSoundGroup.BONE)));
    public static final Block COCONUT_OPEN = register("coconut_open", new CoconutOpenBlock(FabricBlockSettings.of(Material.GOURD).strength(0.8f).sounds(BlockSoundGroup.BONE)));
    public static final Block COCONUT_OPEN_EMPTY = register("coconut_open_empty", new CoconutEmptyBlock(FabricBlockSettings.of(Material.GOURD).strength(0.8f).sounds(BlockSoundGroup.BONE)));

    /*
    Coconut Trees
     */
    public static final Block TROPICAL_LOG = register("tropical_log", new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(0.8f)));
    public static final Block COCONUT_LEAVES = register("coconut_leaves", new CoconutLeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2f).nonOpaque().ticksRandomly()));
    public static final SaplingBlock COCONUT_SAPLING = (SaplingBlock) register("coconut_sapling", new CoconutSapling(new CoconutSaplingGenerator(), AbstractBlock.Settings.of(Material.PLANT).strength(0f).nonOpaque().ticksRandomly()));

    /*
    Flotsam
     */
    public static final Block FLOTSAM_GRASS = register("flotsam_grass", new FlotsamGrassBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.1f).nonOpaque()));
    public static final Block DRIFTWOOD = register("driftwood", new Block(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.4f)));

    /*
    Bananas
     */
    public static final Block BANANA_BUNCH = register("banana_bunch", new Block(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.3f)));
    public static final Block PLANTAIN_BUNCH = register("plantain_bunch", new Block(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.3f)));

    /*
    Banana Trees
     */
    public static final Block BANANA_LEAVES = register("banana_leaves", new BananaLeavesBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.3f)));
    public static final Block BANANA_VINE = register("banana_vine", new HangingVineBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.3f).collidable(false)));

    public static Block register(String id, Block block) {
        Item blockItem = new BlockItem(block, new Item.Settings().group(ItemGroup.DECORATIONS));
        Registry.register(Registry.ITEM, new Identifier("tropical", id), blockItem);
        return Registry.register(Registry.BLOCK, new Identifier("tropical", id), block);
    }
}
