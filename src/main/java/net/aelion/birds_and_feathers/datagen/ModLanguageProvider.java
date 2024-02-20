package net.aelion.birds_and_feathers.datagen;

import net.aelion.birds_and_feathers.BirdsAndFeathersMod;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Arrays;
import java.util.Locale;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, BirdsAndFeathersMod.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.featherTab", "Birds and Feathers");

        for (String color: Arrays.asList("White", "Light gray", "Gray", "Black", "Brown", "Red", "Orange", "Yellow",
                "Lime", "Green", "Cyan", "Light blue", "Blue", "Purple", "Magenta", "Pink")){

            String colorId = color.toLowerCase(Locale.ROOT).replace(' ', '_');

            if (!color.equals("White"))
                this.add("item.birds_and_feathers." + colorId + "_feather", color + " feather");

            this.add("block.birds_and_feathers." + colorId + "_feather_block", color + " feather block");

            this.add("item.birds_and_feathers." + colorId + "_feather_helmet", color + " feather crest");
            this.add("item.birds_and_feathers." + colorId + "_feather_chestplate", color + " feather tunic");
            this.add("item.birds_and_feathers." + colorId + "_feather_leggings", color + " feather pants");
            this.add("item.birds_and_feathers." + colorId + "_feather_boots", color + " feather boots");
            this.add("item.birds_and_feathers." + colorId + "_winged_feather_boots", color + " winged feather boots");
        }
    }
}
