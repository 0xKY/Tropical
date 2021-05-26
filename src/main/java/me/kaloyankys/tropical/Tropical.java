package me.kaloyankys.tropical;

import me.kaloyankys.tropical.init.*;
import net.fabricmc.api.ModInitializer;

public class Tropical implements ModInitializer {

    @Override
    public void onInitialize() {
        new ModItems();
        new ModBlocks();
        new ModEntities();
        new ModWorldGen();
        new ModSoundEvents();
    }
}
