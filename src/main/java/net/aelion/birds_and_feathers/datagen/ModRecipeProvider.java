package net.aelion.birds_and_feathers.datagen;

import net.aelion.birds_and_feathers.blocks.ModBlocks;
import net.aelion.birds_and_feathers.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput p_248933_, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(p_248933_, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        List<Item> feathers = new ArrayList<>();
        feathers.add(Items.FEATHER);
        for (DeferredItem<Item> feather: ModItems.COLORED_FEATHERS) feathers.add(feather.get());

        List<Block> featherBlocks = new ArrayList<>();
        List<Item> featherBlockItems = new ArrayList<>();
        for (DeferredBlock<Block> featherBlock: ModBlocks.FEATHER_BLOCKS) {
            featherBlocks.add(featherBlock.get());
            featherBlockItems.add(featherBlock.get().asItem());
        }

        List<Item> dyes = Arrays.asList(
                Items.WHITE_DYE,
                Items.LIGHT_GRAY_DYE,
                Items.GRAY_DYE,
                Items.BLACK_DYE,
                Items.BROWN_DYE,
                Items.RED_DYE,
                Items.ORANGE_DYE,
                Items.YELLOW_DYE,
                Items.LIME_DYE,
                Items.GREEN_DYE,
                Items.CYAN_DYE,
                Items.LIGHT_BLUE_DYE,
                Items.BLUE_DYE,
                Items.PURPLE_DYE,
                Items.MAGENTA_DYE,
                Items.PINK_DYE
        );

        List<Block> beds = Arrays.asList(
                Blocks.WHITE_BED,
                Blocks.LIGHT_GRAY_BED,
                Blocks.GRAY_BED,
                Blocks.BLACK_BED,
                Blocks.BROWN_BED,
                Blocks.RED_BED,
                Blocks.ORANGE_BED,
                Blocks.YELLOW_BED,
                Blocks.LIME_BED,
                Blocks.GREEN_BED,
                Blocks.CYAN_BED,
                Blocks.LIGHT_BLUE_BED,
                Blocks.BLUE_BED,
                Blocks.PURPLE_BED,
                Blocks.MAGENTA_BED,
                Blocks.PINK_BED
        );

        colorBlockWithDye(pRecipeOutput, dyes, featherBlockItems, "feather_block");

        for (int i = 0; i<16; ++i){
            Item feather = feathers.get(i);
            Block featherBlock = featherBlocks.get(i);

            nineBlockStorageRecipes(pRecipeOutput,
                    RecipeCategory.MISC, feather,
                    RecipeCategory.BUILDING_BLOCKS, featherBlock);

            bedFromPlanksAndWool(pRecipeOutput, beds.get(i), featherBlock);
        }
    }
}