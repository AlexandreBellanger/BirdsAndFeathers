package net.aelion.birds_and_feathers.datagen;

import net.aelion.birds_and_feathers.blocks.ModBlocks;
import net.aelion.birds_and_feathers.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput p_248933_, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(p_248933_, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        for (int i = 0; i<16; ++i){
            Block featherBlock = ModBlocks.FEATHER_BLOCKS.get(i).get();
            Item feather = i==0 ? Items.FEATHER : ModItems.COLORED_FEATHERS.get(i-1).get();

            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, featherBlock)
                    .pattern("FFF")
                    .pattern("FFF")
                    .pattern("FFF")
                    .define('F', feather)
                    .unlockedBy(getHasName(feather), has(feather))
                    .save(pRecipeOutput);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, feather, 9)
                    .requires(featherBlock)
                    .unlockedBy(getHasName(featherBlock), has(featherBlock))
                    .save(pRecipeOutput);
        }
    }
}
