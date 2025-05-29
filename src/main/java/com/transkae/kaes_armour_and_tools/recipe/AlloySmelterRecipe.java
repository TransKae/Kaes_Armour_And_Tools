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

public class AlloySmelterRecipe implements Recipe<SimpleContainer> {
    private final Ingredient input1;
    private final Ingredient input2;
    private final Ingredient input3;
    private final ItemStack output;

    private final ResourceLocation id;

    public AlloySmelterRecipe(ResourceLocation id, Ingredient input1, Ingredient input2, Ingredient input3, ItemStack output) {
        this.id = id;
        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;
        this.output = output;
    }

    public Ingredient getInput1() {
        return input1;
    }

    public Ingredient getInput2() {
        return input2;
    }

    public Ingredient getInput3() {
        return input3;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        return  input1.test(container.getItem(0)) &&
                input2.test(container.getItem(1)) &&
                (input3 == Ingredient.EMPTY || input3.test(container.getItem(2)) || container.getItem(2).isEmpty());
    }


    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(input1);
        ingredients.add(input2);
        ingredients.add(input3);
        return ingredients;
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
            Ingredient input1 = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "input1"));
            Ingredient input2 = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "input2"));
            Ingredient input3 = json.has("input3")
                    ? Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "input3"))
                    : Ingredient.EMPTY;
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            return new AlloySmelterRecipe(id, input1, input2, input3, output);
        }

        @Override
        public AlloySmelterRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
            Ingredient input1 = Ingredient.fromNetwork(buffer);
            Ingredient input2 = Ingredient.fromNetwork(buffer);
            Ingredient input3 = Ingredient.fromNetwork(buffer);
            ItemStack output = buffer.readItem();

            return new AlloySmelterRecipe(id, input1, input2, input3, output);
        }


        @Override
        public void toNetwork(FriendlyByteBuf buffer, AlloySmelterRecipe recipe) {
            recipe.getInput1().toNetwork(buffer);
            recipe.getInput2().toNetwork(buffer);
            recipe.getInput3().toNetwork(buffer);
            buffer.writeItemStack(recipe.getResultItem(null), false);
        }
    }
}
