package net.aelion.birds_and_feathers.datagen;

import net.aelion.birds_and_feathers.BirdsAndFeathersMod;
import net.aelion.birds_and_feathers.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BirdsAndFeathersMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (DeferredItem<Item> feather: ModItems.COLORED_FEATHERS){
            simpleItem(feather);
        }
    }

    private ItemModelBuilder simpleItem(DeferredItem<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BirdsAndFeathersMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
