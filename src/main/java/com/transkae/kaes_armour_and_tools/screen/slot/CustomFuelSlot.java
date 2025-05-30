package com.transkae.kaes_armour_and_tools.screen.slot;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class CustomFuelSlot extends SlotItemHandler {
    public CustomFuelSlot(IItemHandler inventory, int index, int xPosition, int yPosition) {
        super(inventory, index, xPosition, yPosition);
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) > 0;
    }
}
