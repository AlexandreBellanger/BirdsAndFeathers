package net.aelion.birds_and_feathers.datagen;

import net.aelion.birds_and_feathers.BirdsAndFeathers;
import net.aelion.birds_and_feathers.sound.ModSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {
    public ModSoundDefinitionsProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, BirdsAndFeathers.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {
        this.add(ModSounds.CROW_AMBIENT, definition()
                .subtitle("sounds.birds_and_feathers.crow_ambient")
                .with(modSound( "crow_short_1"), modSound("crow_short_2"),
                        modSound( "crow_short_3"), modSound("crow_short_4"))
        );

        this.add(ModSounds.CROW_FlY, definition()
                .subtitle("sounds.birds_and_feathers.crow_fly")
                .with(sound(SoundEvents.PARROT_FLY.getLocation(), SoundDefinition.SoundType.EVENT))
        );

        this.add(ModSounds.CROW_HURT, definition()
                .subtitle("sounds.birds_and_feathers.crow_hurt")
                .with(sound(ModSounds.CROW_AMBIENT.get().getLocation(), SoundDefinition.SoundType.EVENT).pitch(1.5))
        );

        this.add(ModSounds.CROW_DEATH, definition()
                .subtitle("sounds.birds_and_feathers.crow_death")
                .with(sound(ModSounds.CROW_AMBIENT.get().getLocation(), SoundDefinition.SoundType.EVENT).pitch(0.5))
        );
    }

    public SoundDefinition.Sound modSound(String path) {
        return SoundDefinitionsProvider.sound(new ResourceLocation(BirdsAndFeathers.MOD_ID, path));
    }
}
