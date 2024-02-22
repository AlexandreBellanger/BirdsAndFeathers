package net.aelion.birds_and_feathers.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.aelion.birds_and_feathers.items.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.commands.data.DataAccessor;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Supplier;

public class ParrotLootReplacer extends LootModifier {

    public static final Supplier<Codec<ParrotLootReplacer>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, ParrotLootReplacer::new)));


    public ParrotLootReplacer(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {

        for (LootItemCondition condition: this.conditions) {
            if (!condition.test(context)) {
                return generatedLoot;
            }
        }

        // I don't know if this is needed
        if (!context.hasParam(LootContextParams.THIS_ENTITY)) {
            return generatedLoot;
        }

        Entity entity = context.getParam(LootContextParams.THIS_ENTITY);
        SynchedEntityData entityData = entity.getEntityData();

        // Default parrot variant has red feathers
        Item correct_feather = ModItems.RED_FEATHER.get();

        // I feel like this is not at all how it should be done
        for ( SynchedEntityData.DataValue<?> dataValue: Objects.requireNonNull(entityData.getNonDefaultValues())){
            if (dataValue.id() == 19) {
                int parrotVariantId = (int) dataValue.value();

                if (parrotVariantId == Parrot.Variant.RED_BLUE.getId()) {
                    // Note: this is actually never reached, as RED_BLUE is the default variant
                    correct_feather = ModItems.RED_FEATHER.get();
                } else if (parrotVariantId == Parrot.Variant.BLUE.getId()) {
                    correct_feather = ModItems.BLUE_FEATHER.get();
                } else if (parrotVariantId == Parrot.Variant.GRAY.getId()) {
                    correct_feather = ModItems.LIGHT_GRAY_FEATHER.get();
                } else if (parrotVariantId == Parrot.Variant.YELLOW_BLUE.getId()) {
                    // I may change this to cyan later
                    correct_feather = ModItems.LIGHT_BLUE_FEATHER.get();
                } else if (parrotVariantId == Parrot.Variant.GREEN.getId()) {
                    correct_feather = ModItems.LIME_FEATHER.get();
                } else {
                    // Unknown parrot variant, should not mess with it
                    return generatedLoot;
                }

                break;
            }
        }

        ItemStack coloredFeatherItemStack = new ItemStack(correct_feather);

        for (ItemStack itemStack: generatedLoot) {
            if (itemStack.getItem() == Items.FEATHER){
                // Changing the number of feathers to match the number of vanilla feathers that would normally drop
                coloredFeatherItemStack.setCount(itemStack.getCount());
                // Removing the vanilla feather from the loot
                generatedLoot.remove(itemStack);
            }
        }

        generatedLoot.add(coloredFeatherItemStack);

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
