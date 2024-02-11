package net.aelion.birds_and_feathers.items;

import net.aelion.birds_and_feathers.BirdsAndFeathersMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(BirdsAndFeathersMod.MOD_ID);

    public static final DeferredItem<Item> RED_FEATHER =
            ITEMS.register("red_feather", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
