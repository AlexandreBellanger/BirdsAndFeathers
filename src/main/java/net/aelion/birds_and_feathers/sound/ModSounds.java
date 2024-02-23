package net.aelion.birds_and_feathers.sound;

import net.aelion.birds_and_feathers.BirdsAndFeathersMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(Registries.SOUND_EVENT, BirdsAndFeathersMod.MOD_ID);

    public static final Supplier<SoundEvent> CROW_CALL = registerSoundEvent("crow_call");

    // TODO: remove the sound test as soon as we have them on a true mob
    public static final DeferredSoundType FEATHER_BLOCK_SOUND_TYPE = new DeferredSoundType(1,1,
            ModSounds.CROW_CALL, ModSounds.CROW_CALL, ModSounds.CROW_CALL,
            ModSounds.CROW_CALL, ModSounds.CROW_CALL);

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(
                new ResourceLocation(BirdsAndFeathersMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
