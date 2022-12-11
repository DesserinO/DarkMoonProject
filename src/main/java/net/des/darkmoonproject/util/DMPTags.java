package net.des.darkmoonproject.util;

import net.des.darkmoonproject.DarkMoonProject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

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

        public static final TagKey<Item> COBBLESTONE_CRUSHER_FIRST_SLOT =
                tag("cobblestone_crusher_first_slot");
        public static final TagKey<Item> COBBLESTONE_CRUSHER_SECOND_SLOT =
                tag("cobblestone_crusher_second_slot");

        public static final TagKey<Item> COBBLESTONE_ALLOY_SMELTER_FIRST_SLOT =
                tag("cobblestone_alloy_smelter_first_slot");
        public static final TagKey<Item> COBBLESTONE_ALLOY_SMELTER_SECOND_SLOT =
                tag("cobblestone_alloy_smelter_second_slot");
        public static final TagKey<Item> COBBLESTONE_ALLOY_SMELTER_OUTPUT_SLOT =
                tag("cobblestone_alloy_smelter_output_slot");

        public static final TagKey<Item> PATTERNS = tag("patterns");
        public static final TagKey<Item> ALL_PATTERNS = tag("all_patterns");
        public static final TagKey<Item> HAMMER_TOOLS = tag("hammer_tools");
        public static final TagKey<Item> SCREWDRIVER_TOOLS = tag("screwdriver_tools");
        public static final TagKey<Item> WIRE_CUTTER_TOOLS = tag("wire_cutter_tools");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(DarkMoonProject.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
