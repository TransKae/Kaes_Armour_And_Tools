package com.transkae.kaes_armour_and_tools.datagen.loot;

import com.transkae.kaes_armour_and_tools.block.ModBlocks;
import com.transkae.kaes_armour_and_tools.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.EMMERCIUMBLOCK.get());

        this.add(ModBlocks.EMMERCIUMORE.get(),
                block -> createOreDrop(ModBlocks.EMMERCIUMORE.get(), ModItems.RAWEMMERCIUM.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
