package net.aelion.birds_and_feathers.items;

import net.aelion.birds_and_feathers.BirdsAndFeathersMod;
import net.aelion.birds_and_feathers.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BirdsAndFeathersMod.MOD_ID);

    public static final Supplier<CreativeModeTab> FEATHER_TAB = CREATIVE_MODE_TABS.register("feather_tab",
                () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.FEATHER))
                        .title(Component.translatable("itemGroup.featherTab"))
                        .displayItems((pParameters, pOutput) -> {
                            pOutput.accept(Items.FEATHER);
                            for (DeferredItem<Item> feather: ModItems.COLORED_FEATHERS)
                                pOutput.accept(feather);
                            for (DeferredBlock<Block> featherBlock: ModBlocks.FEATHER_BLOCKS)
                                pOutput.accept(featherBlock);
                            for (DeferredItem<Item> armorItem: ModItems.FEATHER_ARMOR_ITEMS)
                                pOutput.accept(armorItem);
                        })
                        .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
