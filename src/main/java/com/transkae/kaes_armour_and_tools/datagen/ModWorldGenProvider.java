package com.transkae.kaes_armour_and_tools.datagen;

import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import com.transkae.kaes_armour_and_tools.worldgen.ModBiomeModifiers;
import com.transkae.kaes_armour_and_tools.worldgen.ModConfiguredFeatures;
import com.transkae.kaes_armour_and_tools.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootStrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootStrap).add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootStrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(KaesArmourAndTools.MOD_ID));
    }
}
