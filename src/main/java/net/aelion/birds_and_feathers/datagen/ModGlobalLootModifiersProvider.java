package net.aelion.birds_and_feathers.datagen;

import net.aelion.birds_and_feathers.BirdsAndFeathers;
import net.aelion.birds_and_feathers.loot.ParrotLootReplacer;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, BirdsAndFeathers.MOD_ID);
    }

    @Override
    protected void start() {

        // I feel like this is where I should have the conditions about the parrot type
        // But I do not know how to do it
        add("colored_feather_from_parrot", new ParrotLootReplacer(
                new LootItemCondition[] {
                        new LootTableIdCondition.Builder(new ResourceLocation("entities/parrot")).build()
                }));

    }
}
