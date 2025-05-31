package com.transkae.kaes_armour_and_tools.util;

import com.transkae.kaes_armour_and_tools.KaesArmourAndTools;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

import javax.swing.text.html.HTML;


public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDSEMMERCIUMTOOL = tag("needs_emmercium_tool");
        public static final TagKey<Block> NEEDSDURIUMTOOL = tag("needs_durium_tool");

        private static TagKey<Block> tag(String name) {
            //noinspection removal
            return BlockTags.create(new ResourceLocation(KaesArmourAndTools.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> tag(String name) {
            //noinspection removal
            return ItemTags.create(new ResourceLocation(KaesArmourAndTools.MOD_ID, name));
        }
    }
}
