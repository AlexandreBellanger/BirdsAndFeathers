package net.aelion.birds_and_feathers.datagen;

import net.aelion.birds_and_feathers.blocks.ModBlocks;
import net.aelion.birds_and_feathers.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput p_248933_, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(p_248933_, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_FEATHER_BLOCK.get())
                .pattern("FFF")
                .pattern("FFF")
                .pattern("FFF")
                .define('F', ModItems.BLACK_FEATHER.get())
                .unlockedBy(getHasName(ModItems.BLACK_FEATHER.get()), has(ModItems.BLACK_FEATHER.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_FEATHER.get())
                .requires(ModBlocks.BLACK_FEATHER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.BLACK_FEATHER_BLOCK.get()), has(ModBlocks.BLACK_FEATHER_BLOCK.get()))
                .save(pRecipeOutput);
    }
}
