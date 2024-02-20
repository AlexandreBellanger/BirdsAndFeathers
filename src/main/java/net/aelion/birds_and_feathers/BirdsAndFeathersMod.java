package net.aelion.birds_and_feathers;

import com.mojang.logging.LogUtils;
import net.aelion.birds_and_feathers.blocks.ModBlocks;
import net.aelion.birds_and_feathers.items.ModCreativeTabs;
import net.aelion.birds_and_feathers.items.ModItems;
import net.aelion.birds_and_feathers.loot.ModLootModifiers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BirdsAndFeathersMod.MOD_ID)
public class BirdsAndFeathersMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "birds_and_feathers";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public BirdsAndFeathersMod(IEventBus modEventBus) {

        ModCreativeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            for (DeferredItem<Item> feather: ModItems.COLORED_FEATHERS)
                event.accept(feather);
        }
        else if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            for (DeferredBlock<Block> featherBlock: ModBlocks.FEATHER_BLOCKS)
                event.accept(featherBlock);
        }
        else if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            for (DeferredItem<Item> armorItem: ModItems.FEATHER_ARMOR_ITEMS)
                event.accept(armorItem);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
