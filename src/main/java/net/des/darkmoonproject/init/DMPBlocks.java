package net.des.darkmoonproject.init;

import net.des.darkmoonproject.DarkMoonProject;
import net.des.darkmoonproject.block.custom.AssemblyTable;
import net.des.darkmoonproject.block.custom.CobblestoneAlloySmelter;
import net.des.darkmoonproject.block.custom.CobblestoneCrusher;
import net.des.darkmoonproject.util.DMPCreativeTabs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DMPBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DarkMoonProject.MOD_ID);

    public static final CreativeModeTab BLOCK_TAB = DMPCreativeTabs.DARKMOONPROJECT_BLOCK_TAB;

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return DMPItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    // ↓↓↓ Registering blocks ↓↓↓
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).
                    requiresCorrectToolForDrops().strength(3f)), BLOCK_TAB);

    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).
                    requiresCorrectToolForDrops().strength(7f)), BLOCK_TAB);

    public static final RegistryObject<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).
                    requiresCorrectToolForDrops().strength(5f)), BLOCK_TAB);

    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).
                    requiresCorrectToolForDrops().strength(6f)), BLOCK_TAB);

    public static final RegistryObject<Block> BRONZE_BLOCK = registerBlock("bronze_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).
                    requiresCorrectToolForDrops().strength(9f)), BLOCK_TAB);

    public static final RegistryObject<Block> REDSTONE_ALLOY_BLOCK = registerBlock("redstone_alloy_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).
                    requiresCorrectToolForDrops().strength(9f)), BLOCK_TAB);

    public static final RegistryObject<Block> COBBLESTONE_CRUSHER = registerBlock("cobblestone_crusher",
            () -> new CobblestoneCrusher(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), BLOCK_TAB);

    public static final RegistryObject<Block> COBBLESTONE_ALLOY_SMELTER = registerBlock("cobblestone_alloy_smelter",
            () -> new CobblestoneAlloySmelter(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), BLOCK_TAB);

    public static final RegistryObject<Block> ASSEMBLY_TABLE = registerBlock("assembly_table",
            () -> new AssemblyTable(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()), BLOCK_TAB);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
