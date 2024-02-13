package net.aelion.birds_and_feathers.datagen.loot;

import net.aelion.birds_and_feathers.blocks.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        List<Block> blocks = new ArrayList<>();

        for (DeferredBlock<Block> deferredFeatherBlock: ModBlocks.FEATHER_BLOCKS) {
            blocks.add(deferredFeatherBlock.get());
        }

        return blocks;

        // This recommended method was not working as there are no RegistryObject
        /*/
        return ModBlocks.BLOCKS.getEntries() // Get all registered entries
                .stream() // Stream the wrapped objects
                .map(RegistryObject::get) // Get the object if available
                ::iterator; // Create the iterable
                
         */
    }
}
