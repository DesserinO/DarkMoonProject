package net.des.darkmoonproject.client.gui;

import net.des.darkmoonproject.DarkMoonProject;
import net.des.darkmoonproject.client.gui.machine.CobblestoneAlloySmelterMenu;
import net.des.darkmoonproject.client.gui.machine.CobblestoneCrusherMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DMPMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, DarkMoonProject.MOD_ID);

    public static final RegistryObject<MenuType<CobblestoneCrusherMenu>> COBBLESTONE_CRUSHER_MENU =
            registerMenuType(CobblestoneCrusherMenu::new, "cobblestone_crusher_menu");

    public static final RegistryObject<MenuType<CobblestoneAlloySmelterMenu>> COBBLESTONE_ALLOY_SMELTER_MENU =
            registerMenuType(CobblestoneAlloySmelterMenu::new, "cobblestone_alloy_smelter_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType
            (IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
