package net.aelion.birds_and_feathers.items;

import net.aelion.birds_and_feathers.BirdsAndFeathersMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    WHITE_FEATHER("white_feather", 3, new int[]{0, 1, 1, 0}, 5,
            SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(Items.FEATHER)),
    LIGHT_GRAY_FEATHER("light_gray_feather", 3, new int[]{0, 1, 1, 0}, 5,
            SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.LIGHT_GRAY_FEATHER)),
    GRAY_FEATHER("gray_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.GRAY_FEATHER)),
    BLACK_FEATHER("black_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.BLACK_FEATHER)),
    BROWN_FEATHER("brown_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.BROWN_FEATHER)),
    RED_FEATHER("red_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.RED_FEATHER)),
    ORANGE_FEATHER("orange_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.ORANGE_FEATHER)),
    YELLOW_FEATHER("yellow_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.YELLOW_FEATHER)),
    LIME_FEATHER("lime_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.LIME_FEATHER)),
    GREEN_FEATHER("green_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.GREEN_FEATHER)),
    CYAN_FEATHER("cyan_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.CYAN_FEATHER)),
    LIGHT_BLUE_FEATHER("light_blue_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.LIGHT_BLUE_FEATHER)),
    BLUE_FEATHER("blue_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.BLUE_FEATHER)),
    PURPLE_FEATHER("purple_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.PURPLE_FEATHER)),
    MAGENTA_FEATHER("magenta_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.MAGENTA_FEATHER)),
    PINK_FEATHER("pink_feather", 3, new int[]{0, 1, 1, 0}, 5,
    SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(ModItems.PINK_FEATHER));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue,
                      SoundEvent equipSound, float toughness, float knockbackResistance,
                      Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public @NotNull String getName() {
        return BirdsAndFeathersMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}