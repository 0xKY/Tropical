package me.kaloyankys.tropical.init;

import me.kaloyankys.tropical.block.CoconutBlock;
import me.kaloyankys.tropical.block.CoconutFruitBlock;
import me.kaloyankys.tropical.block.FlotsamGrassBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    //Coconut
    public static final Block COCONUT_FRUIT = register("coconut_fruit", new CoconutFruitBlock(FabricBlockSettings.of(Material.GOURD).strength(1.0f).ticksRandomly()));
    public static final Block COCONUT_FRUIT_GRAVITY = register("coconut_fruit_gravity", new CoconutBlock(FabricBlockSettings.of(Material.GOURD).strength(1.0f)));
    public static final Block COCONUT = register("coconut", new FallingBlock(FabricBlockSettings.of(Material.GOURD).strength(1.0f)));
    public static final Block COCONUT_OPEN = register("coconut_open", new CoconutBlock(FabricBlockSettings.of(Material.GOURD).strength(0.8f)));
    public static final Block COCONUT_OPEN_EMPTY = register("coconut_open_empty", new CoconutBlock(FabricBlockSettings.of(Material.GOURD).strength(0.8f)));

    //Tropical Trees
    public static final Block TROPICAL_LOG = register("tropical_log", new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(0.8f)));
    public static final Block COCONUT_LEAVES = register("coconut_leaves", new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2f)));

    //Flotsam
    public static final Block FLOTSAM_GRASS = register("flotsam_grass", new FlotsamGrassBlock(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.1f)));
    public static final Block DRIFTWOOD = register("driftwood", new Block(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(0.4f)));

    public static Block register(String id, Block block) {
        Item blockItem = new BlockItem(block, new Item.Settings().group(ItemGroup.DECORATIONS));
        Registry.register(Registry.ITEM, new Identifier("tropical", id), blockItem);
        return Registry.register(Registry.BLOCK, new Identifier("tropical", id), block);
    }
}
