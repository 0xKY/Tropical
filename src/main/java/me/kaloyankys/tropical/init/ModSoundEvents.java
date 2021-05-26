package me.kaloyankys.tropical.init;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSoundEvents {

    public static final SoundEvent CRAB_AMBIENT = coconutCrab("crab_ambient");
    public static final SoundEvent CRAB_DEATH = coconutCrab("crab_death");
    public static final SoundEvent CRAB_HURT = coconutCrab("crab_hurt");
    public static final SoundEvent CRAB_WALK = coconutCrab("crab_walk");
    private static SoundEvent coconutCrab(String type) {
        return entity("coconut_crab", type);
    }

    private static SoundEvent block(String block, String type) {
        return register("block." + block + "." + type);
    }
    private static SoundEvent entity(String entity, String type) {
        return register("entity." + entity + "." + type);
    }

    private static SoundEvent register(String sound) {
        Identifier id = new Identifier("tropical", sound);
        SoundEvent event = new SoundEvent(id);
        Registry.register(Registry.SOUND_EVENT, id, event);
        return event;
    }
}
