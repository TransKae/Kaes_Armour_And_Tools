package com.transkae.kaes_armour_and_tools.item;

import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import com.transkae.kaes_armour_and_tools.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier EMMERCIUM = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1250, 7.5f, 2.5f, 15,
                    ModTags.Blocks.NEEDSEMMERCIUMTOOL, () -> Ingredient.of(ModItems.EMMERCIUMINGOT.get())),
            new ResourceLocation(KaesArmourAndTools.MOD_ID, "sapphire"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
}
