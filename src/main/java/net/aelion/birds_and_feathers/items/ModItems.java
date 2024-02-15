package net.aelion.birds_and_feathers.items;

import net.aelion.birds_and_feathers.BirdsAndFeathersMod;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(BirdsAndFeathersMod.MOD_ID);

    public static final DeferredItem<Item> LIGHT_GRAY_FEATHER =
            ITEMS.register("light_gray_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GRAY_FEATHER =
            ITEMS.register("gray_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLACK_FEATHER =
            ITEMS.register("black_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BROWN_FEATHER =
            ITEMS.register("brown_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RED_FEATHER =
            ITEMS.register("red_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_FEATHER =
            ITEMS.register("orange_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_FEATHER =
            ITEMS.register("yellow_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIME_FEATHER =
            ITEMS.register("lime_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GREEN_FEATHER =
            ITEMS.register("green_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CYAN_FEATHER =
            ITEMS.register("cyan_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_FEATHER =
            ITEMS.register("light_blue_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLUE_FEATHER =
            ITEMS.register("blue_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_FEATHER =
            ITEMS.register("purple_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_FEATHER =
            ITEMS.register("magenta_feather", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PINK_FEATHER =
            ITEMS.register("pink_feather", () -> new Item(new Item.Properties()));

    public static final List<DeferredItem<Item>> COLORED_FEATHERS = Arrays.asList(
            LIGHT_GRAY_FEATHER,
            GRAY_FEATHER,
            BLACK_FEATHER,
            BROWN_FEATHER,
            RED_FEATHER,
            ORANGE_FEATHER,
            YELLOW_FEATHER,
            LIME_FEATHER,
            GREEN_FEATHER,
            CYAN_FEATHER,
            LIGHT_BLUE_FEATHER,
            BLUE_FEATHER,
            PURPLE_FEATHER,
            MAGENTA_FEATHER,
            PINK_FEATHER
    );

    public static final DeferredItem<Item> FEATHER_CREST = ITEMS.register("feather_crest",
            () -> new ArmorItem(ModArmorMaterials.FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> FEATHER_TUNIC = ITEMS.register("feather_tunic",
            () -> new ArmorItem(ModArmorMaterials.FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> FEATHER_PANTS = ITEMS.register("feather_pants",
            () -> new ArmorItem(ModArmorMaterials.FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> FEATHER_BOOTS = ITEMS.register("feather_boots",
            () -> new ArmorItem(ModArmorMaterials.FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
