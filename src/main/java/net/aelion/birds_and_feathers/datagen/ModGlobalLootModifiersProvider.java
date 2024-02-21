package net.aelion.birds_and_feathers.datagen;

import net.aelion.birds_and_feathers.BirdsAndFeathersMod;
import net.aelion.birds_and_feathers.items.ModItems;
import net.aelion.birds_and_feathers.loot.ParrotLootReplacer;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, BirdsAndFeathersMod.MOD_ID);
    }

    @Override
    protected void start() {

        add("light_blue_feather_from_parrot", new ParrotLootReplacer(
                new LootItemCondition[] {
                        new LootTableIdCondition.Builder(new ResourceLocation("entities/parrot")).build()
                }));

    }
}
