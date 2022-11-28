package net.des.darkmoonproject.util;

import net.des.darkmoonproject.DarkMoonProject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class DMPTags {
    public static class Blocks {
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(DarkMoonProject.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        // Initializing tags
        public static final TagKey<Item> RAW_TIN = forgeTag("raw_materials/raw_tin");
        public static final TagKey<Item> TIN_INGOT = forgeTag("ingots/tin_ingot");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(DarkMoonProject.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
