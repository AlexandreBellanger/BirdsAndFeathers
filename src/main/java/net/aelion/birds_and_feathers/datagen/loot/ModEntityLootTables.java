package net.aelion.birds_and_feathers.datagen.loot;

import net.aelion.birds_and_feathers.entity.ModEntities;
import net.aelion.birds_and_feathers.items.ModItems;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ModEntityLootTables extends EntityLootSubProvider {

    public ModEntityLootTables() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        this.add(ModEntities.CROW.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModItems.BLACK_FEATHER))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,2)))
                        .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0,1)))
                ));
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        List<EntityType<?>> entityTypes = new ArrayList<>();

        entityTypes.add(ModEntities.CROW.get());

        return entityTypes.stream();
    }
}
