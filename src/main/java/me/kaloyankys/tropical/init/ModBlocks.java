package me.kaloyankys.tropical.init;

import me.kaloyankys.tropical.block.*;
import me.kaloyankys.tropical.block.coconut.CoconutFruitBlock;
import me.kaloyankys.tropical.block.coconut.CoconutBlock;
import me.kaloyankys.tropical.block.coconut.CoconutOpenBlock;
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
    public static final Block COCONUT = register("coconut", new CoconutBlock(FabricBlockSettings.of(Material.GOURD).strength(1.0f).sounds(BlockSoundGroup.BONE)));
    public static final Block COCONUT_OPEN = register("coconut_open", new CoconutOpenBlock(FabricBlockSettings.of(Material.GOURD).strength(0.8f).sounds(BlockSoundGroup.BONE)));
    public static final Block COCONUT_OPEN_EMPTY = register("coconut_open_empty", new FallingBlock(FabricBlockSettings.of(Material.GOURD).strength(0.8f).sounds(BlockSoundGroup.BONE)));

    /*
    Coconut Trees
     */
    public static final Block COCONUT_PALM_WOOD = register("coconut_palm_wood", new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(0.8f)));
    public static final Block COCONUT_PALM_CROWN = register("coconut_palm_crown", new PalmCrownBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2f).nonOpaque().ticksRandomly()));
    public static final Block COCONUT_PALM_FROND = register("coconut_palm_frond", new FrondBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2f).nonOpaque().ticksRandomly()));
    /*
    Flotsam
     */
    public static final Block MARRAM_GRASS = register("marram_grass", new MarramGrassBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.1f).nonOpaque()));
    public static final Block DRIFTWOOD = register("driftwood", new Block(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.4f)));


    public static Block register(String id, Block block) {
        Item blockItem = new BlockItem(block, new Item.Settings().group(ItemGroup.DECORATIONS));
        Registry.register(Registry.ITEM, new Identifier("tropical", id), blockItem);
        return Registry.register(Registry.BLOCK, new Identifier("tropical", id), block);
    }
}
