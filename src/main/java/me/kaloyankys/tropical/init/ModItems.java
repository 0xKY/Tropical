package me.kaloyankys.tropical.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static Item register(String id, Item item) {
        Item Item = new Item(new Item.Settings().group(ItemGroup.DECORATIONS));
        return Registry.register(Registry.ITEM, new Identifier("biomeslesnaturels", id), item);
    }
}
