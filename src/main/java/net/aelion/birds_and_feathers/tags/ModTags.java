package net.aelion.birds_and_feathers.tags;

import net.aelion.birds_and_feathers.BirdsAndFeathers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> FEATHER_BLOCKS = tag("feather_blocks");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(BirdsAndFeathers.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> FEATHER = tag("feather");
        public static final TagKey<Item> TOLERATED_BY_PHANTOMS = tag("tolerated_by_phantoms");
        public static final TagKey<Item> CROW_LOVED = tag("crow_loved");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(BirdsAndFeathers.MOD_ID, name));
        }
    }
}
