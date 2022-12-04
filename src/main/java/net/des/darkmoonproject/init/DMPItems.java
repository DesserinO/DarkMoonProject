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

    // ↓↓↓ Registering items ↓↓↓
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));

    // ↓↓↓ INGOTS ↓↓↓
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties().tab(ITEM_TAB)));

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


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
