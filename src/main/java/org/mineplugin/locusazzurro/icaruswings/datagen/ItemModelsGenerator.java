package org.mineplugin.locusazzurro.icaruswings.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * @author DustW
 **/
public class ItemModelsGenerator extends ItemModelProvider {

    public ItemModelsGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, DataGenerators.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //ForgeRegistries.ITEMS.forEach(item -> {
        //    if (item.getRegistryName().getNamespace().equals(DataGenerators.MOD_ID) && item instanceof BlockItem) {
        //        withExistingParent(item.getRegistryName().getPath(), modLoc("block/" + item.getRegistryName().getPath()));
        //    }
        //});
    }
}