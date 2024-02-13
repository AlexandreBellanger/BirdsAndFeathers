package net.aelion.birds_and_feathers.datagen;

import net.aelion.birds_and_feathers.BirdsAndFeathersMod;
import net.aelion.birds_and_feathers.blocks.ModBlocks;
import net.aelion.birds_and_feathers.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, BirdsAndFeathersMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        for (DeferredBlock<Block> featherBlock: ModBlocks.FEATHER_BLOCKS)
            this.tag(ModTags.Blocks.FEATHER_BLOCKS).add(featherBlock.get());

        this.tag(BlockTags.WOOL).addTag(ModTags.Blocks.FEATHER_BLOCKS);
    }
}
