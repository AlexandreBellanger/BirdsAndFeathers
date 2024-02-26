package net.aelion.birds_and_feathers.blocks;

import net.aelion.birds_and_feathers.BirdsAndFeathers;
import net.aelion.birds_and_feathers.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(BirdsAndFeathers.MOD_ID);

    // TODO: remove the sound test remains as soon as we have them on a true mob
    public static final DeferredBlock<Block> WHITE_FEATHER_BLOCK = registerBlock("white_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                    //.sound(ModSounds.FEATHER_BLOCK_SOUND_TYPE)
            ));
    public static final DeferredBlock<Block> LIGHT_GRAY_FEATHER_BLOCK = registerBlock("light_gray_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final DeferredBlock<Block> GRAY_FEATHER_BLOCK = registerBlock("gray_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final DeferredBlock<Block> BLACK_FEATHER_BLOCK = registerBlock("black_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final DeferredBlock<Block> BROWN_FEATHER_BLOCK = registerBlock("brown_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final DeferredBlock<Block> RED_FEATHER_BLOCK = registerBlock("red_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final DeferredBlock<Block> ORANGE_FEATHER_BLOCK = registerBlock("orange_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final DeferredBlock<Block> YELLOW_FEATHER_BLOCK = registerBlock("yellow_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> LIME_FEATHER_BLOCK = registerBlock("lime_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final DeferredBlock<Block> GREEN_FEATHER_BLOCK = registerBlock("green_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final DeferredBlock<Block> CYAN_FEATHER_BLOCK = registerBlock("cyan_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final DeferredBlock<Block> LIGHT_BLUE_FEATHER_BLOCK = registerBlock("light_blue_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final DeferredBlock<Block> BLUE_FEATHER_BLOCK = registerBlock("blue_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final DeferredBlock<Block> PURPLE_FEATHER_BLOCK = registerBlock("purple_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final DeferredBlock<Block> MAGENTA_FEATHER_BLOCK = registerBlock("magenta_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final DeferredBlock<Block> PINK_FEATHER_BLOCK = registerBlock("pink_feather_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));

    public static final List<DeferredBlock<Block>> FEATHER_BLOCKS = Arrays.asList(
            WHITE_FEATHER_BLOCK,
            LIGHT_GRAY_FEATHER_BLOCK,
            GRAY_FEATHER_BLOCK,
            BLACK_FEATHER_BLOCK,
            BROWN_FEATHER_BLOCK,
            RED_FEATHER_BLOCK,
            ORANGE_FEATHER_BLOCK,
            YELLOW_FEATHER_BLOCK,
            LIME_FEATHER_BLOCK,
            GREEN_FEATHER_BLOCK,
            CYAN_FEATHER_BLOCK,
            LIGHT_BLUE_FEATHER_BLOCK,
            BLUE_FEATHER_BLOCK,
            PURPLE_FEATHER_BLOCK,
            MAGENTA_FEATHER_BLOCK,
            PINK_FEATHER_BLOCK
            );

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem<BlockItem> registerBlockItem(String name, DeferredBlock<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
