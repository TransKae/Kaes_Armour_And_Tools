package com.transkae.kaes_armour_and_tools.datagen;

import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275204_, CompletableFuture<HolderLookup.Provider> p_275194_, CompletableFuture<TagLookup<Block>> p_275634_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275204_, p_275194_, p_275634_, KaesArmourAndTools.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
