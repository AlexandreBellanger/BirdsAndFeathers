package net.aelion.birds_and_feathers.datagen;

import net.aelion.birds_and_feathers.blocks.ModBlocks;
import net.aelion.birds_and_feathers.items.ModItems;
import net.aelion.birds_and_feathers.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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
        List<Item> feathers = listFeathers();
        List<Item> featherBlocks = listFeatherBlockAsItems();
        List<Item> dyes = listDyes();
        List<Block> beds = listBeds();

        colorFeatherWithDye(pRecipeOutput, dyes, feathers);
        colorBlockWithDye(pRecipeOutput, dyes, featherBlocks, "feather_block");

        for (int i = 0; i<16; ++i){
            Item feather = feathers.get(i);
            Item featherBlock = featherBlocks.get(i);

            nineBlockStorageRecipes(pRecipeOutput,
                    RecipeCategory.MISC, feather,
                    RecipeCategory.BUILDING_BLOCKS, featherBlock);

            bedFromPlanksAndWool(pRecipeOutput, beds.get(i), featherBlock);
        }

        brush(pRecipeOutput);
        bookAndQuill(pRecipeOutput);
    }

    protected static void colorFeatherWithDye(RecipeOutput pRecipeOutput, List<Item> pDyes, List<Item> pFeathers) {
        for(int i = 0; i < pDyes.size(); ++i) {
            Item dye = pDyes.get(i);
            Item feather = pFeathers.get(i);
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, feather)
                    .requires(dye)
                    .requires(Ingredient.of(pFeathers.stream().filter(p_288265_ -> !p_288265_.equals(feather)).map(ItemStack::new)))
                    .group("feathers")
                    .unlockedBy("has_needed_dye", has(dye))
                    .save(pRecipeOutput, "dye_" + getItemName(feather));
        }
    }

    protected static void bookAndQuill(RecipeOutput pRecipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WRITABLE_BOOK)
                .requires(Items.BOOK)
                .requires(Items.INK_SAC)
                .requires(ModTags.Items.FEATHER)
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(pRecipeOutput);
    }

    protected static void brush(RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.BRUSH)
                .define('W', ModTags.Items.FEATHER)
                .define('#', Items.COPPER_INGOT)
                .define('I', Items.STICK)
                .pattern("W")
                .pattern("#")
                .pattern("I")
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pRecipeOutput);
    }

    private static List<Item> listFeathers() {
        List<Item> feathers = new ArrayList<>();
        feathers.add(Items.FEATHER);
        for (DeferredItem<Item> feather: ModItems.COLORED_FEATHERS) feathers.add(feather.get());
        return feathers;
    }

    private static List<Item> listFeatherBlockAsItems() {
        List<Item> featherBlockAsItems = new ArrayList<>();
        for (DeferredBlock<Block> featherBlock: ModBlocks.FEATHER_BLOCKS)
            featherBlockAsItems.add(featherBlock.get().asItem());
        return featherBlockAsItems;
    }

    private static List<Item> listDyes() {
        return Arrays.asList(
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
    }

    private static List<Block> listBeds() {
        return Arrays.asList(
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
    }
}
