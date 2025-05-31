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
            new ForgeTier(3, 680, 7.5f, 2.5f, 15,
                    ModTags.Blocks.NEEDSEMMERCIUMTOOL, () -> Ingredient.of(ModItems.EMMERCIUMINGOT.get())),
            new ResourceLocation(KaesArmourAndTools.MOD_ID, "emmercium"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

    public static final Tier DURIUM = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1750, 5.5f, 1.5f, 19,
                    ModTags.Blocks.NEEDSDURIUMTOOL, () -> Ingredient.of(ModItems.DURIUMINGOT.get())),
            new ResourceLocation(KaesArmourAndTools.MOD_ID, "durium"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
}
