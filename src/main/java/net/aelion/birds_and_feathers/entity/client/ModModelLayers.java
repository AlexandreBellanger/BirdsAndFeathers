package net.aelion.birds_and_feathers.entity.client;

import net.aelion.birds_and_feathers.BirdsAndFeathersMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation CROW_LAYER = new ModelLayerLocation(
            new ResourceLocation(BirdsAndFeathersMod.MOD_ID, "crow_layer"), "main"
    );
}
