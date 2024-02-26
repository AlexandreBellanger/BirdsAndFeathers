package net.aelion.birds_and_feathers.loot;

import com.mojang.serialization.Codec;
import net.aelion.birds_and_feathers.BirdsAndFeathers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZER =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,
                    BirdsAndFeathers.MOD_ID);

    public static final DeferredHolder<Codec<? extends IGlobalLootModifier>, Codec<ParrotLootReplacer>> REPLACE_PARROT_FEATHER =
            LOOT_MODIFIER_SERIALIZER.register("replace_parrot_feather", ParrotLootReplacer.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZER.register(eventBus);
    }
}
