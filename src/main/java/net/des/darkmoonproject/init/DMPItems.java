package net.des.darkmoonproject.init;

import net.des.darkmoonproject.DarkMoonProject;
import net.des.darkmoonproject.util.DMPCreativeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DMPItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DarkMoonProject.MOD_ID);

    public static final CreativeModeTab ITEM_TAB = DMPCreativeTabs.DARKMOONPROJECT_ITEM_TAB;
    public static final CreativeModeTab TOOL_TAB = DMPCreativeTabs.DARKMOONPROJECT_TOOL_TAB;

    // ↓↓↓ Registering items ↓↓↓
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));

    // ↓↓↓ PATTERNS
    public static final RegistryObject<Item> COBBLESTONE_PLATE_PATTERN = ITEMS.register("cobblestone_plate_pattern",
            () -> new Item(new Item.Properties().tab(TOOL_TAB).stacksTo(1)));
    public static final RegistryObject<Item> COBBLESTONE_ROD_PATTERN = ITEMS.register("cobblestone_rod_pattern",
                    () -> new Item(new Item.Properties().tab(TOOL_TAB).stacksTo(1)));
    public static final RegistryObject<Item> BRONZE_PLATE_PATTERN = ITEMS.register("bronze_plate_pattern",
            () -> new Item(new Item.Properties().tab(TOOL_TAB).stacksTo(1)));
    public static final RegistryObject<Item> BRONZE_ROD_PATTERN = ITEMS.register("bronze_rod_pattern",
            () -> new Item(new Item.Properties().tab(TOOL_TAB).stacksTo(1)));


    // ↓↓↓ INGOTS ↓↓↓
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    public static final RegistryObject<Item> REDSTONE_ALLOY_INGOT = ITEMS.register("redstone_alloy_ingot",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    /*public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));*/

    // ↓↓↓ DUSTS ↓↓↓
    public static final RegistryObject<Item> TIN_DUST = ITEMS.register("tin_dust",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    public static final RegistryObject<Item> COAL_DUST = ITEMS.register("coal_dust",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    /*public static final RegistryObject<Item> DIAMOND_DUST = ITEMS.register("diamond_dust",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    public static final RegistryObject<Item> EMERALD_DUST = ITEMS.register("emerald_dust",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));*/
    public static final RegistryObject<Item> LAPIS_DUST = ITEMS.register("lapis_dust",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    /*public static final RegistryObject<Item> NETHER_QUARTZ_DUST = ITEMS.register("nether_quartz_dust",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    public static final RegistryObject<Item> AMETHYST_DUST = ITEMS.register("amethyst_dust",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));*/
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    public static final RegistryObject<Item> BRONZE_DUST = ITEMS.register("bronze_dust",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    public static final RegistryObject<Item> REDSTONE_DUST = ITEMS.register("redstone_iron_dust",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    /*public static final RegistryObject<Item> STEEL_DUST = ITEMS.register("steel_dust",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));*/

    // ↓↓↓ PLATES ↓↓↓
    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    /*public static final RegistryObject<Item> GOLD_PLATE = ITEMS.register("gold_plate",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));*/
    public static final RegistryObject<Item> BRONZE_PLATE = ITEMS.register("bronze_plate",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));
    public static final RegistryObject<Item> WOODEN_PLATE = ITEMS.register("wooden_plate",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));


    // ↓↓↓ RODS ↓↓↓
    public static final RegistryObject<Item> IRON_ROD = ITEMS.register("iron_rod",
            () -> new Item(new Item.Properties().tab(ITEM_TAB).stacksTo(16)));
    public static final RegistryObject<Item> BRONZE_ROD = ITEMS.register("bronze_rod",
            () -> new Item(new Item.Properties().tab(ITEM_TAB).stacksTo(16)));

    // ↓↓↓ TOOLS ↓↓↓
    public static final RegistryObject<Item> COBBLESTONE_HAMMER = ITEMS.register("cobblestone_hammer",
            () -> new Item(new Item.Properties().tab(TOOL_TAB).stacksTo(1)));
    public static final RegistryObject<Item> BRONZE_HAMMER = ITEMS.register("bronze_hammer",
            () -> new Item(new Item.Properties().tab(TOOL_TAB).stacksTo(1)));
    public static final RegistryObject<Item> BRONZE_SCREWDRIVER = ITEMS.register("bronze_screwdriver",
            () -> new Item(new Item.Properties().tab(TOOL_TAB).stacksTo(1)));
    public static final RegistryObject<Item> BRONZE_WIRE_CUTTER = ITEMS.register("bronze_wire_cutter",
            () -> new Item(new Item.Properties().tab(TOOL_TAB).stacksTo(1)));

    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new Item(new Item.Properties().tab(TOOL_TAB).stacksTo(1)));
    public static final RegistryObject<Item> IRON_SCREWDRIVER = ITEMS.register("iron_screwdriver",
            () -> new Item(new Item.Properties().tab(TOOL_TAB).stacksTo(1)));
    public static final RegistryObject<Item> IRON_WIRE_CUTTER = ITEMS.register("iron_wire_cutter",
            () -> new Item(new Item.Properties().tab(TOOL_TAB).stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
