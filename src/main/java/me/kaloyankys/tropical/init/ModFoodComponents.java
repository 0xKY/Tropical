package me.kaloyankys.tropical.init;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    /*
    Bananas / Plantains
     */
    public static final FoodComponent BANANA = new FoodComponent.Builder()
            .alwaysEdible()
            .hunger(3)
            .saturationModifier(0.1f)
            .build();
    public static final FoodComponent GILDED_BANANA = new FoodComponent.Builder()
            .alwaysEdible()
            .hunger(6)
            .saturationModifier(0.4f)
            .build();
    public static final FoodComponent PLANTAIN = new FoodComponent.Builder()
            .alwaysEdible()
            .hunger(3)
            .saturationModifier(0.1f)
            .build();
    public static final FoodComponent COOKED_PLANTAIN = new FoodComponent.Builder()
            .alwaysEdible()
            .hunger(6)
            .saturationModifier(0.4f)
            .build();
}
