package com.transkae.kaes_armour_and_tools.datagen;

import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import com.transkae.kaes_armour_and_tools.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, KaesArmourAndTools.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAWEMMERCIUM);
        simpleItem(ModItems.EMMERCIUMINGOT);
        simpleItem(ModItems.EMMERCIUMPICKAXE);
        simpleItem(ModItems.EMMERCIUMAXE);
        simpleItem(ModItems.EMMERCIUMSHOVEL);
        simpleItem(ModItems.EMMERCIUMHOE);
        simpleItem(ModItems.EMMERCIUMSWORD);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(KaesArmourAndTools.MOD_ID, "item/" + item.getId().getPath()));
    }
}
