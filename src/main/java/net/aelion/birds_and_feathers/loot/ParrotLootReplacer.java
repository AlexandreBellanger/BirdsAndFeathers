package net.aelion.birds_and_feathers.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.aelion.birds_and_feathers.items.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

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

        // I don't know if this check is needed
        if (!context.hasParam(LootContextParams.THIS_ENTITY)) {
            return generatedLoot;
        }
        Entity entity = context.getParam(LootContextParams.THIS_ENTITY);
        // Should I just cast without checking: are the checks already done with the LootItemConditions ?
        if (!(entity instanceof Parrot parrot)) {
            return generatedLoot;
        }

        DeferredItem<Item> correct_feather = switch (parrot.getVariant()) {
            case RED_BLUE -> ModItems.RED_FEATHER;
            case BLUE -> ModItems.BLUE_FEATHER;
            case GREEN -> ModItems.LIME_FEATHER;
            case YELLOW_BLUE -> ModItems.LIGHT_BLUE_FEATHER;
            case GRAY -> ModItems.LIGHT_GRAY_FEATHER;
            // A warning says default branch is unnecessary
            // but this could maybe prevent a crash if mojang (or another mod ?) adds more parrots variants
            default -> null;
        };
        if (correct_feather == null) {
            return generatedLoot;
        }

        ItemStack coloredFeatherItemStack = new ItemStack(correct_feather.get());

        for (ItemStack vanillaLootItemStack: generatedLoot) {
            if (vanillaLootItemStack.getItem() == Items.FEATHER){
                // Changing the number of feathers to match the number of vanilla feathers that would normally drop
                coloredFeatherItemStack.setCount(vanillaLootItemStack.getCount());
                // Removing the vanilla feather from the loot
                generatedLoot.remove(vanillaLootItemStack);
                // Even if it was useful, I would not trust resuming the list iteration after removing an entry
                break;
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
