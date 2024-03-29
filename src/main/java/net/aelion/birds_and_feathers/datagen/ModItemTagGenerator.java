package net.aelion.birds_and_feathers.datagen;

import net.aelion.birds_and_feathers.BirdsAndFeathers;
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
        super(p_275343_, p_275729_, p_275322_, BirdsAndFeathers.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(ModTags.Items.FEATHER).add(Items.FEATHER);
        for (DeferredItem<Item> feather: ModItems.COLORED_FEATHERS)
            tag(ModTags.Items.FEATHER).add(feather.get());

        for (DeferredItem<Item> featherArmor: ModItems.FEATHER_ARMOR_ITEMS){
            tag(ModTags.Items.TOLERATED_BY_PHANTOMS).add(featherArmor.get());
            if (!featherArmor.getId().getPath().contains("helmet"))
                tag(ItemTags.TRIMMABLE_ARMOR).add(featherArmor.get());
        }

        tag(ModTags.Items.CROW_LOVED).add(Items.GOLD_NUGGET, Items.GOLD_INGOT, Items.DIAMOND, Items.EMERALD,
                Items.QUARTZ, Items.AMETHYST_SHARD, Items.ECHO_SHARD, Items.CLOCK);
    }
}
