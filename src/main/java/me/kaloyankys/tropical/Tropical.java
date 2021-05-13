package me.kaloyankys.tropical;

import me.kaloyankys.tropical.init.ModBlocks;
import me.kaloyankys.tropical.init.ModEntities;
import me.kaloyankys.tropical.init.ModItems;
import me.kaloyankys.tropical.init.ModWorldGen;
import net.fabricmc.api.ModInitializer;

public class Tropical implements ModInitializer {

    @Override
    public void onInitialize() {
        new ModItems();
        new ModBlocks();
        new ModEntities();
        new ModWorldGen();
    }
}
