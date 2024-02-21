package net.aelion.birds_and_feathers.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class LootReplacer extends LootModifier {

    public static final Supplier<Codec<LootReplacer>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.create(inst -> codecStart(inst).and(BuiltInRegistries.ITEM.byNameCodec()
                    .fieldOf("item").forGetter(n -> n.item)).apply(inst, LootReplacer::new)));

    private final Item item;

    public LootReplacer(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {

        for (LootItemCondition condition: this.conditions) {
            if (!condition.test(context)) {
                return generatedLoot;
            }
        }

        ItemStack coloredFeatherItemStack = new ItemStack(this.item);

        for (ItemStack itemStack: generatedLoot) {
            if (itemStack.getItem() == Items.FEATHER){
                coloredFeatherItemStack.setCount(itemStack.getCount());
                generatedLoot.remove(itemStack);
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
