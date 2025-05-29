package com.transkae.kaes_armour_and_tools.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlloySmelterRecipe implements Recipe<SimpleContainer> {
    private final List<Ingredient> ingredients;
    private final ItemStack output;

    private final ResourceLocation id;

    public AlloySmelterRecipe(ResourceLocation id, List<Ingredient> ingredients, ItemStack output) {
        this.id = id;
        this.ingredients = ingredients.stream()
                .filter(ingredient -> !ingredient.isEmpty())
                .collect(Collectors.toList());
        this.output = output;
    }

        public boolean matches(SimpleContainer container, Level level) {
            List<ItemStack> inputs = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                ItemStack stack = container.getItem(i);
                if (!stack.isEmpty()) {
                    inputs.add(stack.copy());
                }
            }
            List<Ingredient> expected = new ArrayList<>(ingredients);
            for (Ingredient ingredient : expected) {
                boolean matched = false;
                Iterator<ItemStack> iter = inputs.iterator();
                while (iter.hasNext()) {
                    ItemStack stack = iter.next();
                    if (ingredient.test(stack)) {
                        iter.remove();
                        matched = true;
                        break;
                    }
                }
                if (!matched) {
                    return false;
                }
            }
            return inputs.isEmpty(); // ensure no extra items
        }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.addAll(ingredients);
        return list;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<AlloySmelterRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "alloy_smelting";
    }

    public static class Serializer implements RecipeSerializer<AlloySmelterRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(KaesArmourAndTools.MOD_ID, "alloy_smelting");

        @Override
        public AlloySmelterRecipe fromJson(ResourceLocation id, JsonObject json) {
            JsonArray ingredientsArray = GsonHelper.getAsJsonArray(json, "ingredients");
            List<Ingredient> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientsArray.size(); i++) {
                ingredients.add(Ingredient.fromJson(ingredientsArray.get(i)));
            }

            if (ingredients.size() < 2 || ingredients.size() > 3) {
                throw new IllegalArgumentException("Alloy Smelter recipe must have 2 or 3 ingredients.");
            }

            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            return new AlloySmelterRecipe(id, ingredients, output);
        }

        @Override
        public AlloySmelterRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
            int size = buffer.readInt();
            List<Ingredient> ingredients = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                ingredients.add(Ingredient.fromNetwork(buffer));
            }

            ItemStack output = buffer.readItem();
            return new AlloySmelterRecipe(id, ingredients, output);
        }


        @Override
        public void toNetwork(FriendlyByteBuf buffer, AlloySmelterRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buffer);
            }

            buffer.writeItemStack(recipe.getResultItem(null), false);
        }
    }
}
