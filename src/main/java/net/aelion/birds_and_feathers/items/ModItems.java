package net.aelion.birds_and_feathers.items;

import net.aelion.birds_and_feathers.BirdsAndFeathers;
import net.aelion.birds_and_feathers.entity.ModEntities;
import net.aelion.birds_and_feathers.items.custom.FeatherArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Arrays;
import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(BirdsAndFeathers.MOD_ID);

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


    public static final DeferredItem<Item> WHITE_FEATHER_HELMET = ITEMS.register("white_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.WHITE_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> WHITE_FEATHER_CHESTPLATE = ITEMS.register("white_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.WHITE_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> WHITE_FEATHER_LEGGINGS = ITEMS.register("white_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.WHITE_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> WHITE_FEATHER_BOOTS = ITEMS.register("white_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.WHITE_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> WHITE_WINGED_FEATHER_BOOTS = ITEMS.register("white_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.WHITE_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> LIGHT_GRAY_FEATHER_HELMET = ITEMS.register("light_gray_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.LIGHT_GRAY_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_FEATHER_CHESTPLATE = ITEMS.register("light_gray_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.LIGHT_GRAY_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_FEATHER_LEGGINGS = ITEMS.register("light_gray_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.LIGHT_GRAY_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_FEATHER_BOOTS = ITEMS.register("light_gray_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.LIGHT_GRAY_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_WINGED_FEATHER_BOOTS = ITEMS.register("light_gray_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.LIGHT_GRAY_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> GRAY_FEATHER_HELMET = ITEMS.register("gray_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.GRAY_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> GRAY_FEATHER_CHESTPLATE = ITEMS.register("gray_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.GRAY_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> GRAY_FEATHER_LEGGINGS = ITEMS.register("gray_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.GRAY_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> GRAY_FEATHER_BOOTS = ITEMS.register("gray_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.GRAY_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> GRAY_WINGED_FEATHER_BOOTS = ITEMS.register("gray_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.GRAY_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> BLACK_FEATHER_HELMET = ITEMS.register("black_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.BLACK_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> BLACK_FEATHER_CHESTPLATE = ITEMS.register("black_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.BLACK_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final DeferredItem<Item> BLACK_FEATHER_LEGGINGS = ITEMS.register("black_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.BLACK_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> BLACK_FEATHER_BOOTS = ITEMS.register("black_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.BLACK_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> BLACK_WINGED_FEATHER_BOOTS = ITEMS.register("black_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.BLACK_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> BROWN_FEATHER_HELMET = ITEMS.register("brown_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.BROWN_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> BROWN_FEATHER_CHESTPLATE = ITEMS.register("brown_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.BROWN_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> BROWN_FEATHER_LEGGINGS = ITEMS.register("brown_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.BROWN_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> BROWN_FEATHER_BOOTS = ITEMS.register("brown_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.BROWN_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> BROWN_WINGED_FEATHER_BOOTS = ITEMS.register("brown_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.BROWN_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> RED_FEATHER_HELMET = ITEMS.register("red_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.RED_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> RED_FEATHER_CHESTPLATE = ITEMS.register("red_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.RED_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> RED_FEATHER_LEGGINGS = ITEMS.register("red_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.RED_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> RED_FEATHER_BOOTS = ITEMS.register("red_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.RED_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> RED_WINGED_FEATHER_BOOTS = ITEMS.register("red_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.RED_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> ORANGE_FEATHER_HELMET = ITEMS.register("orange_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.ORANGE_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_FEATHER_CHESTPLATE = ITEMS.register("orange_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.ORANGE_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_FEATHER_LEGGINGS = ITEMS.register("orange_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.ORANGE_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_FEATHER_BOOTS = ITEMS.register("orange_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.ORANGE_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_WINGED_FEATHER_BOOTS = ITEMS.register("orange_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.ORANGE_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> YELLOW_FEATHER_HELMET = ITEMS.register("yellow_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.YELLOW_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_FEATHER_CHESTPLATE = ITEMS.register("yellow_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.YELLOW_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_FEATHER_LEGGINGS = ITEMS.register("yellow_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.YELLOW_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_FEATHER_BOOTS = ITEMS.register("yellow_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.YELLOW_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_WINGED_FEATHER_BOOTS = ITEMS.register("yellow_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.YELLOW_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> LIME_FEATHER_HELMET = ITEMS.register("lime_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.LIME_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> LIME_FEATHER_CHESTPLATE = ITEMS.register("lime_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.LIME_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> LIME_FEATHER_LEGGINGS = ITEMS.register("lime_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.LIME_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> LIME_FEATHER_BOOTS = ITEMS.register("lime_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.LIME_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> LIME_WINGED_FEATHER_BOOTS = ITEMS.register("lime_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.LIME_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> GREEN_FEATHER_HELMET = ITEMS.register("green_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.GREEN_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> GREEN_FEATHER_CHESTPLATE = ITEMS.register("green_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.GREEN_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> GREEN_FEATHER_LEGGINGS = ITEMS.register("green_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.GREEN_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> GREEN_FEATHER_BOOTS = ITEMS.register("green_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.GREEN_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> GREEN_WINGED_FEATHER_BOOTS = ITEMS.register("green_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.GREEN_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> CYAN_FEATHER_HELMET = ITEMS.register("cyan_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.CYAN_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> CYAN_FEATHER_CHESTPLATE = ITEMS.register("cyan_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.CYAN_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> CYAN_FEATHER_LEGGINGS = ITEMS.register("cyan_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.CYAN_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> CYAN_FEATHER_BOOTS = ITEMS.register("cyan_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.CYAN_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> CYAN_WINGED_FEATHER_BOOTS = ITEMS.register("cyan_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.CYAN_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> LIGHT_BLUE_FEATHER_HELMET = ITEMS.register("light_blue_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.LIGHT_BLUE_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_FEATHER_CHESTPLATE = ITEMS.register("light_blue_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.LIGHT_BLUE_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_FEATHER_LEGGINGS = ITEMS.register("light_blue_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.LIGHT_BLUE_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_FEATHER_BOOTS = ITEMS.register("light_blue_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.LIGHT_BLUE_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_WINGED_FEATHER_BOOTS = ITEMS.register("light_blue_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.LIGHT_BLUE_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> BLUE_FEATHER_HELMET = ITEMS.register("blue_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.BLUE_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> BLUE_FEATHER_CHESTPLATE = ITEMS.register("blue_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.BLUE_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> BLUE_FEATHER_LEGGINGS = ITEMS.register("blue_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.BLUE_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> BLUE_FEATHER_BOOTS = ITEMS.register("blue_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.BLUE_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> BLUE_WINGED_FEATHER_BOOTS = ITEMS.register("blue_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.BLUE_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> PURPLE_FEATHER_HELMET = ITEMS.register("purple_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.PURPLE_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_FEATHER_CHESTPLATE = ITEMS.register("purple_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.PURPLE_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_FEATHER_LEGGINGS = ITEMS.register("purple_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.PURPLE_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_FEATHER_BOOTS = ITEMS.register("purple_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.PURPLE_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> PURPLE_WINGED_FEATHER_BOOTS = ITEMS.register("purple_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.PURPLE_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> MAGENTA_FEATHER_HELMET = ITEMS.register("magenta_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.MAGENTA_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_FEATHER_CHESTPLATE = ITEMS.register("magenta_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.MAGENTA_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_FEATHER_LEGGINGS = ITEMS.register("magenta_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.MAGENTA_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_FEATHER_BOOTS = ITEMS.register("magenta_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.MAGENTA_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_WINGED_FEATHER_BOOTS = ITEMS.register("magenta_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.MAGENTA_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> PINK_FEATHER_HELMET = ITEMS.register("pink_feather_helmet",
            () -> new FeatherArmorItem(ModArmorMaterials.PINK_FEATHER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> PINK_FEATHER_CHESTPLATE = ITEMS.register("pink_feather_chestplate",
            () -> new FeatherArmorItem(ModArmorMaterials.PINK_FEATHER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> PINK_FEATHER_LEGGINGS = ITEMS.register("pink_feather_leggings",
            () -> new FeatherArmorItem(ModArmorMaterials.PINK_FEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> PINK_FEATHER_BOOTS = ITEMS.register("pink_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.PINK_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<Item> PINK_WINGED_FEATHER_BOOTS = ITEMS.register("pink_winged_feather_boots",
            () -> new FeatherArmorItem(ModArmorMaterials.PINK_FEATHER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final List<DeferredItem<Item>> FEATHER_ARMOR_ITEMS = Arrays.asList(
            WHITE_FEATHER_HELMET,
            WHITE_FEATHER_CHESTPLATE,
            WHITE_FEATHER_LEGGINGS,
            WHITE_FEATHER_BOOTS,
            WHITE_WINGED_FEATHER_BOOTS,

            LIGHT_GRAY_FEATHER_HELMET,
            LIGHT_GRAY_FEATHER_CHESTPLATE,
            LIGHT_GRAY_FEATHER_LEGGINGS,
            LIGHT_GRAY_FEATHER_BOOTS,
            LIGHT_GRAY_WINGED_FEATHER_BOOTS,

            GRAY_FEATHER_HELMET,
            GRAY_FEATHER_CHESTPLATE,
            GRAY_FEATHER_LEGGINGS,
            GRAY_FEATHER_BOOTS,
            GRAY_WINGED_FEATHER_BOOTS,

            BLACK_FEATHER_HELMET,
            BLACK_FEATHER_CHESTPLATE,

            BLACK_FEATHER_LEGGINGS,
            BLACK_FEATHER_BOOTS,
            BLACK_WINGED_FEATHER_BOOTS,

            BROWN_FEATHER_HELMET,
            BROWN_FEATHER_CHESTPLATE,
            BROWN_FEATHER_LEGGINGS,
            BROWN_FEATHER_BOOTS,
            BROWN_WINGED_FEATHER_BOOTS,

            RED_FEATHER_HELMET,
            RED_FEATHER_CHESTPLATE,
            RED_FEATHER_LEGGINGS,
            RED_FEATHER_BOOTS,
            RED_WINGED_FEATHER_BOOTS,

            ORANGE_FEATHER_HELMET,
            ORANGE_FEATHER_CHESTPLATE,
            ORANGE_FEATHER_LEGGINGS,
            ORANGE_FEATHER_BOOTS,
            ORANGE_WINGED_FEATHER_BOOTS,

            YELLOW_FEATHER_HELMET,
            YELLOW_FEATHER_CHESTPLATE,
            YELLOW_FEATHER_LEGGINGS,
            YELLOW_FEATHER_BOOTS,
            YELLOW_WINGED_FEATHER_BOOTS,

            LIME_FEATHER_HELMET,
            LIME_FEATHER_CHESTPLATE,
            LIME_FEATHER_LEGGINGS,
            LIME_FEATHER_BOOTS,
            LIME_WINGED_FEATHER_BOOTS,

            GREEN_FEATHER_HELMET,
            GREEN_FEATHER_CHESTPLATE,
            GREEN_FEATHER_LEGGINGS,
            GREEN_FEATHER_BOOTS,
            GREEN_WINGED_FEATHER_BOOTS,

            CYAN_FEATHER_HELMET,
            CYAN_FEATHER_CHESTPLATE,
            CYAN_FEATHER_LEGGINGS,
            CYAN_FEATHER_BOOTS,
            CYAN_WINGED_FEATHER_BOOTS,

            LIGHT_BLUE_FEATHER_HELMET,
            LIGHT_BLUE_FEATHER_CHESTPLATE,
            LIGHT_BLUE_FEATHER_LEGGINGS,
            LIGHT_BLUE_FEATHER_BOOTS,
            LIGHT_BLUE_WINGED_FEATHER_BOOTS,

            BLUE_FEATHER_HELMET,
            BLUE_FEATHER_CHESTPLATE,
            BLUE_FEATHER_LEGGINGS,
            BLUE_FEATHER_BOOTS,
            BLUE_WINGED_FEATHER_BOOTS,

            PURPLE_FEATHER_HELMET,
            PURPLE_FEATHER_CHESTPLATE,
            PURPLE_FEATHER_LEGGINGS,
            PURPLE_FEATHER_BOOTS,
            PURPLE_WINGED_FEATHER_BOOTS,

            MAGENTA_FEATHER_HELMET,
            MAGENTA_FEATHER_CHESTPLATE,
            MAGENTA_FEATHER_LEGGINGS,
            MAGENTA_FEATHER_BOOTS,
            MAGENTA_WINGED_FEATHER_BOOTS,

            PINK_FEATHER_HELMET,
            PINK_FEATHER_CHESTPLATE,
            PINK_FEATHER_LEGGINGS,
            PINK_FEATHER_BOOTS,
            PINK_WINGED_FEATHER_BOOTS
    );

    public static final DeferredItem<Item> CROW_SPAWN_EGG =
            ITEMS.register("crow_spawn_egg", () -> new DeferredSpawnEggItem(
                    ModEntities.CROW, 0x7e9680, 0xc5d1cb, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
