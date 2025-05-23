package com.transkae.kaes_armour_and_tools.item;

import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import com.transkae.kaes_armour_and_tools.item.custom.EmmerciumArmorItems;
import com.transkae.kaes_armour_and_tools.item.custom.ModArmorItem;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> EMMERCIUMSWORD = ITEMS.register("emmercium_sword", () -> new SwordItem(ModToolTiers.EMMERCIUM, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> EMMERCIUMPICKAXE = ITEMS.register("emmercium_pickaxe", () -> new PickaxeItem(ModToolTiers.EMMERCIUM, 1, -2.9f, new Item.Properties()));
    public static final RegistryObject<Item> EMMERCIUMAXE = ITEMS.register("emmercium_axe", () -> new AxeItem(ModToolTiers.EMMERCIUM, 4, -2.9f, new Item.Properties()));
    public static final RegistryObject<Item> EMMERCIUMSHOVEL = ITEMS.register("emmercium_shovel", () -> new ShovelItem(ModToolTiers.EMMERCIUM, 0, -2.9f, new Item.Properties()));
    public static final RegistryObject<Item> EMMERCIUMHOE = ITEMS.register("emmercium_hoe", () -> new HoeItem(ModToolTiers.EMMERCIUM, -1, -2.9f, new Item.Properties()));

    public static final RegistryObject<Item> EMMERCIUMHELMET = ITEMS.register("emmercium_helmet", () -> new EmmerciumArmorItems(ModArmourMaterials.EMMERCIUM, ArmorItem.Type.HELMET,  new Item.Properties()));
    public static final RegistryObject<Item> EMMERCIUMCHESTPLATE = ITEMS.register("emmercium_chestplate", () -> new EmmerciumArmorItems(ModArmourMaterials.EMMERCIUM, ArmorItem.Type.CHESTPLATE,  new Item.Properties()));
    public static final RegistryObject<Item> EMMERCIUMLEGGINGS = ITEMS.register("emmercium_leggings", () -> new EmmerciumArmorItems(ModArmourMaterials.EMMERCIUM, ArmorItem.Type.LEGGINGS,  new Item.Properties()));
    public static final RegistryObject<Item> EMMERCIUMBOOTS = ITEMS.register("emmercium_boots", () -> new EmmerciumArmorItems(ModArmourMaterials.EMMERCIUM, ArmorItem.Type.BOOTS,  new Item.Properties()));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}
