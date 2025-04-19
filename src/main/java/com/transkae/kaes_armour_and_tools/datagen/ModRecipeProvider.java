package com.transkae.kaes_armour_and_tools.datagen;

import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import com.transkae.kaes_armour_and_tools.block.ModBlocks;
import com.transkae.kaes_armour_and_tools.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> EMMERCIUM_SMELTABLES = List.of(ModItems.RAWEMMERCIUM.get(),
            ModBlocks.EMMERCIUMORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        //Shaped Crafting
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EMMERCIUMBLOCK.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                        .define('E', ModItems.EMMERCIUMINGOT.get())
                                .unlockedBy(getHasName(ModItems.EMMERCIUMINGOT.get()), has(ModItems.EMMERCIUMINGOT.get())).save(consumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMMERCIUMHELMET.get())
                .pattern("EEE")
                .pattern("E E")
                .pattern("   ")
                .define('E', ModItems.EMMERCIUMINGOT.get())
                .unlockedBy(getHasName(ModItems.EMMERCIUMINGOT.get()), has(ModItems.EMMERCIUMINGOT.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMMERCIUMCHESTPLATE.get())
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .define('E', ModItems.EMMERCIUMINGOT.get())
                .unlockedBy(getHasName(ModItems.EMMERCIUMINGOT.get()), has(ModItems.EMMERCIUMINGOT.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMMERCIUMLEGGINGS.get())
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .define('E', ModItems.EMMERCIUMINGOT.get())
                .unlockedBy(getHasName(ModItems.EMMERCIUMINGOT.get()), has(ModItems.EMMERCIUMINGOT.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.EMMERCIUMBOOTS.get())
                .pattern("E E")
                .pattern("E E")
                .pattern("   ")
                .define('E', ModItems.EMMERCIUMINGOT.get())
                .unlockedBy(getHasName(ModItems.EMMERCIUMINGOT.get()), has(ModItems.EMMERCIUMINGOT.get())).save(consumer);



        //Shapeless Crafting
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.EMMERCIUMINGOT.get(), 9)
                .requires(ModBlocks.EMMERCIUMBLOCK.get())
                        .unlockedBy(getHasName(ModBlocks.EMMERCIUMBLOCK.get()), has(ModBlocks.EMMERCIUMBLOCK.get())).save(consumer);

        //Smelting
        oreSmelting(consumer, EMMERCIUM_SMELTABLES, RecipeCategory.MISC, ModItems.EMMERCIUMINGOT.get(), 0.2f, 200, "emmercium");
        oreBlasting(consumer, EMMERCIUM_SMELTABLES, RecipeCategory.MISC, ModItems.EMMERCIUMINGOT.get(), 0.2f, 100, "emmercium");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, KaesArmourAndTools.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
