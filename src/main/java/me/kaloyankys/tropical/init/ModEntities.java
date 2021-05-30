package me.kaloyankys.tropical.init;

import me.kaloyankys.tropical.entity.ChimpEntity;
import me.kaloyankys.tropical.entity.CocoCrabEntity;
import me.kaloyankys.tropical.entity.ToucanEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<CocoCrabEntity> COCONUT_CRAB = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("tropical", "coconut_crab"),
            FabricEntityTypeBuilder.<CocoCrabEntity>create(SpawnGroup.CREATURE,
            (t, w) -> new CocoCrabEntity(w)).dimensions(EntityDimensions.fixed(0.8F, 0.8F)).trackRangeBlocks(12).build());
    public static final EntityType<ChimpEntity> CHIMP = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("tropical", "chimp"),
            FabricEntityTypeBuilder.<ChimpEntity>create(SpawnGroup.CREATURE,
                    (t, w) -> new ChimpEntity(w)).dimensions(EntityDimensions.fixed(1.0F, 2.2F)).trackRangeBlocks(12).build());
    public static final EntityType<ToucanEntity> TOUCAN = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("tropical", "toucan"),
            FabricEntityTypeBuilder.<ToucanEntity>create(SpawnGroup.CREATURE,
                    (t, w) -> new ToucanEntity(w)).dimensions(EntityDimensions.fixed(0.5F, 0.8F)).trackRangeBlocks(12).build());


    public ModEntities() {
        FabricDefaultAttributeRegistry.register(COCONUT_CRAB, CocoCrabEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CHIMP, ChimpEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(TOUCAN, ToucanEntity.createToucanEntityAttributes());
    }
}
