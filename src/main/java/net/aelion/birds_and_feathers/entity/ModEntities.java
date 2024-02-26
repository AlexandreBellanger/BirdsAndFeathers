package net.aelion.birds_and_feathers.entity;

import net.aelion.birds_and_feathers.BirdsAndFeathers;
import net.aelion.birds_and_feathers.entity.custom.Crow;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, BirdsAndFeathers.MOD_ID);

    public static final Supplier<EntityType<Crow>> CROW =
            ENTITY_TYPES.register("crow", () -> EntityType.Builder.of(Crow::new, MobCategory.CREATURE)
                    .sized(0.4f, 0.4f).build("crow"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
