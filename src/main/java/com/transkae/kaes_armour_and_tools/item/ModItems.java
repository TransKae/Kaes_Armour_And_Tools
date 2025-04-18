package com.transkae.kaes_armour_and_tools.item;

import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KaesArmourAndTools.MOD_ID);

    public static final RegistryObject<Item> RAWEMMERCIUM = ITEMS.register("raw_emmercium", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMMERCIUMINGOT = ITEMS.register("emmercium_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EMMERCIUMSWORD = ITEMS.register("emmercium_sword", () -> new SwordItem(Tiers.DIAMOND, 3, -2.1f, new Item.Properties()));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
