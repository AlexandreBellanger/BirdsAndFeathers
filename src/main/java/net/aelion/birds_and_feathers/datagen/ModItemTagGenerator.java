package net.aelion.birds_and_feathers.datagen;

import net.aelion.birds_and_feathers.BirdsAndFeathersMod;
import net.aelion.birds_and_feathers.items.ModItems;
import net.aelion.birds_and_feathers.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, BirdsAndFeathersMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(ModTags.Items.FEATHER).add(Items.FEATHER);
        for (DeferredItem<Item> feather: ModItems.COLORED_FEATHERS)
            this.tag(ModTags.Items.FEATHER).add(feather.get());

        for (DeferredItem<Item> featherArmor: ModItems.FEATHER_ARMOR_ITEMS){
            if (featherArmor.getId().getPath().contains("helmet"))
                continue;
            this.tag(ItemTags.TRIMMABLE_ARMOR).add(featherArmor.get());
        }
    }
}
