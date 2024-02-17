package net.aelion.birds_and_feathers;

import com.mojang.logging.LogUtils;
import net.aelion.birds_and_feathers.blocks.ModBlocks;
import net.aelion.birds_and_feathers.items.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
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
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.LIGHT_GRAY_FEATHER);
            event.accept(ModItems.GRAY_FEATHER);
            event.accept(ModItems.BLACK_FEATHER);
            event.accept(ModItems.BROWN_FEATHER);
            event.accept(ModItems.RED_FEATHER);
            event.accept(ModItems.ORANGE_FEATHER);
            event.accept(ModItems.YELLOW_FEATHER);
            event.accept(ModItems.LIME_FEATHER);
            event.accept(ModItems.GREEN_FEATHER);
            event.accept(ModItems.CYAN_FEATHER);
            event.accept(ModItems.LIGHT_BLUE_FEATHER);
            event.accept(ModItems.BLUE_FEATHER);
            event.accept(ModItems.PURPLE_FEATHER);
            event.accept(ModItems.MAGENTA_FEATHER);
            event.accept(ModItems.PINK_FEATHER);
        }
        else if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            event.accept(ModBlocks.WHITE_FEATHER_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_FEATHER_BLOCK);
            event.accept(ModBlocks.GRAY_FEATHER_BLOCK);
            event.accept(ModBlocks.BLACK_FEATHER_BLOCK);
            event.accept(ModBlocks.BROWN_FEATHER_BLOCK);
            event.accept(ModBlocks.RED_FEATHER_BLOCK);
            event.accept(ModBlocks.ORANGE_FEATHER_BLOCK);
            event.accept(ModBlocks.YELLOW_FEATHER_BLOCK);
            event.accept(ModBlocks.LIME_FEATHER_BLOCK);
            event.accept(ModBlocks.GREEN_FEATHER_BLOCK);
            event.accept(ModBlocks.CYAN_FEATHER_BLOCK);
            event.accept(ModBlocks.LIGHT_BLUE_FEATHER_BLOCK);
            event.accept(ModBlocks.BLUE_FEATHER_BLOCK);
            event.accept(ModBlocks.PURPLE_FEATHER_BLOCK);
            event.accept(ModBlocks.MAGENTA_FEATHER_BLOCK);
            event.accept(ModBlocks.PINK_FEATHER_BLOCK);
        }
        else if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.FEATHER_HELMET);
            event.accept(ModItems.FEATHER_CHESTPLATE);
            event.accept(ModItems.FEATHER_LEGGINGS);
            event.accept(ModItems.FEATHER_BOOTS);
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
