package net.aelion.birds_and_feathers.event;

import net.aelion.birds_and_feathers.BirdsAndFeathers;
import net.aelion.birds_and_feathers.entity.ModEntities;
import net.aelion.birds_and_feathers.entity.custom.Crow;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@Mod.EventBusSubscriber(modid = BirdsAndFeathers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CROW.get(), Crow.createAttributes().build());
    }
}
