package net.des.darkmoonproject.util;

import net.des.darkmoonproject.init.DMPBlocks;
import net.des.darkmoonproject.init.DMPItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class DMPCreativeTabs {
    public static final CreativeModeTab DARKMOONPROJECT_ITEM_TAB =
            new CreativeModeTab("darkmoonproject_item_tab") {
                @Override
                public ItemStack makeIcon() {
                    return new ItemStack(DMPItems.RAW_TIN.get());
                }
            };

    public static final CreativeModeTab DARKMOONPROJECT_BLOCK_TAB =
            new CreativeModeTab("darkmoonproject_block_tab") {
                @Override
                public ItemStack makeIcon() {
                    return new ItemStack(DMPBlocks.TIN_ORE.get());
                }
            };

    public static final CreativeModeTab DARKMOONPROJECT_TOOL_TAB =
            new CreativeModeTab("darkmoonproject_tool_tab") {
                @Override
                public ItemStack makeIcon() {
                    return new ItemStack(DMPItems.BRONZE_HAMMER.get());
                }
            };
}
