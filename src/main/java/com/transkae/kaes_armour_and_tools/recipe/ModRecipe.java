package com.transkae.kaes_armour_and_tools.recipe;

import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import com.transkae.kaes_armour_and_tools.screen.AlloySmelterMenu;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipe {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, KaesArmourAndTools.MOD_ID);

    public static final RegistryObject<RecipeSerializer<AlloySmelterRecipe>> ALLOYSMELTINGSERIALIZER = SERIALIZERS.register("alloy_smelting", () -> AlloySmelterRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
