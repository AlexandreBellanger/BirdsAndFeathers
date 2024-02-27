package net.aelion.birds_and_feathers.sound;

import net.aelion.birds_and_feathers.BirdsAndFeathers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, BirdsAndFeathers.MOD_ID);

    public static final Supplier<SoundEvent> CROW_AMBIENT = registerSoundEvent("crow_ambient");
    public static final Supplier<SoundEvent> CROW_FlY = registerSoundEvent("crow_fly");
    public static final Supplier<SoundEvent> CROW_HURT = registerSoundEvent("crow_hurt");
    public static final Supplier<SoundEvent> CROW_DEATH = registerSoundEvent("crow_death");

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(
                new ResourceLocation(BirdsAndFeathers.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
