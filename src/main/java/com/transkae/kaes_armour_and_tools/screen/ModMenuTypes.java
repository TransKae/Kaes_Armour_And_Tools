package com.transkae.kaes_armour_and_tools.screen;

import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, KaesArmourAndTools.MOD_ID);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static final RegistryObject<MenuType<AlloySmelterMenu>> ALLOYSMELTERMENU = registerMenuType("alloy_smelter_menu", AlloySmelterMenu::new);

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
