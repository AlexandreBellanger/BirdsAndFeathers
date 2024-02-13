package net.aelion.birds_and_feathers.datagen.loot;

import net.aelion.birds_and_feathers.blocks.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        for (DeferredBlock<Block> featherBlock: ModBlocks.FEATHER_BLOCKS) {
            this.dropSelf(featherBlock.get());
        }
    }
}
