package net.aelion.birds_and_feathers.event;

import net.aelion.birds_and_feathers.BirdsAndFeathers;
import net.aelion.birds_and_feathers.entity.client.CrowModel;
import net.aelion.birds_and_feathers.entity.client.ModModelLayers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Mod.EventBusSubscriber(modid = BirdsAndFeathers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.CROW_LAYER, CrowModel::createBodyLayer);
    }

}
