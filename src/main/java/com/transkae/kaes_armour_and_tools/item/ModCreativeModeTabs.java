package com.transkae.kaes_armour_and_tools.item;

import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import com.transkae.kaes_armour_and_tools.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KaesArmourAndTools.MOD_ID);

    public static final RegistryObject<CreativeModeTab> KAES_AAT_TAB = CREATIVE_MODE_TABS.register("kaes_aat_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.EMMERCIUMINGOT.get()))
            .title(Component.translatable("creativetab.kaes_armour_and_tools_tab")).displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.RAWEMMERCIUM.get());
                pOutput.accept(ModBlocks.EMMERCIUMORE.get());
                pOutput.accept(ModItems.EMMERCIUMINGOT.get());
                pOutput.accept(ModBlocks.EMMERCIUMBLOCK.get());

                pOutput.accept(ModItems.EMMERCIUMSWORD.get());
                pOutput.accept(ModItems.EMMERCIUMPICKAXE.get());
                pOutput.accept(ModItems.EMMERCIUMAXE.get());
                pOutput.accept(ModItems.EMMERCIUMSHOVEL.get());
                pOutput.accept(ModItems.EMMERCIUMHOE.get());

                pOutput.accept(ModItems.EMMERCIUMHELMET.get());
                pOutput.accept(ModItems.EMMERCIUMCHESTPLATE.get());
                pOutput.accept(ModItems.EMMERCIUMLEGGINGS.get());
                pOutput.accept(ModItems.EMMERCIUMBOOTS.get());
            }).build());


public static void register(IEventBus eventBus)
{
    CREATIVE_MODE_TABS.register(eventBus);
}
}
