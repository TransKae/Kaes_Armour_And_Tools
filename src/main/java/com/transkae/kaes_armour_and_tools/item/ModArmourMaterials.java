package com.transkae.kaes_armour_and_tools.item;

import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmourMaterials implements ArmorMaterial {
    EMMERCIUM("emmercium", 23, new int[]{ 3, 6, 5, 2 }, 13,
            SoundEvents.ARMOR_EQUIP_IRON, 0.5f, 0f, () -> Ingredient.of(ModItems.EMMERCIUMINGOT.get())),
    DURIUM("durium", 60, new int[]{ 2, 5, 4, 2 }, 18,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 1.5f, 1f, () -> Ingredient.of(ModItems.DURIUMINGOT.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final int [] protectionAmount;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float kbResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 13, 16, 15, 11 };

    ModArmourMaterials(String name, int durabilityMultiplier, int[] protectionAmount, int enchantmentValue, SoundEvent equipSound, float toughness, float kbResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmount = protectionAmount;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.kbResistance = kbResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmount[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return KaesArmourAndTools.MOD_ID  + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.kbResistance;
    }
}
