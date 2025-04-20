package com.transkae.kaes_armour_and_tools.datagen;

import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import com.transkae.kaes_armour_and_tools.item.ModItems;
import com.transkae.kaes_armour_and_tools.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, KaesArmourAndTools.MOD_ID);
    }

    @Override
    protected void start() {
        add("emmercium_ore_from_undead", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build(),
                LootItemRandomChanceCondition.randomChance(0.08f).build() }, ModItems.RAWEMMERCIUM.get()));

        add("emmercium_helmet_from_nether_fortress", new AddItemModifier(new LootItemCondition[] {
                    new LootTableIdCondition.Builder(new ResourceLocation("chest/nether_bridge")).build(),
                    LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.EMMERCIUMHELMET.get()));
        add("emmercium_chestplate_from_nether_fortress", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chest/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.EMMERCIUMCHESTPLATE.get()));
        add("emmercium_leggings_from_nether_fortress", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chest/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.EMMERCIUMLEGGINGS.get()));
        add("emmercium_boots_from_nether_fortress", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chest/nether_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.EMMERCIUMBOOTS.get()));
        add("emmercium_helmet_from_ruined_portal", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chest/ruined_portal")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build() }, ModItems.EMMERCIUMHELMET.get()));
        add("emmercium_chestplate_from_bastion_treasure", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chest/bastion_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.55f).build() }, ModItems.EMMERCIUMCHESTPLATE.get()));
        add("emmercium_leggings_from_bastion_other", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chest/bastion_other")).build(),
                LootItemRandomChanceCondition.randomChance(0.45f).build() }, ModItems.EMMERCIUMLEGGINGS.get()));
        add("emmercium_boots_from_bastion_bridge", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chest/bastion_bridge")).build(),
                LootItemRandomChanceCondition.randomChance(0.4f).build() }, ModItems.EMMERCIUMBOOTS.get()));

    }
}
