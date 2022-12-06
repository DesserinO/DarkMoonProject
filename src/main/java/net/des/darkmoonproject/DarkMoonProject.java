package net.des.darkmoonproject;

import com.mojang.logging.LogUtils;
import net.des.darkmoonproject.block.entity.DMPBlockEntities;
import net.des.darkmoonproject.client.gui.DMPMenuTypes;
import net.des.darkmoonproject.client.gui.machine.CobblestoneAlloySmelterScreen;
import net.des.darkmoonproject.client.gui.machine.CobblestoneCrusherScreen;
import net.des.darkmoonproject.init.DMPBlocks;
import net.des.darkmoonproject.init.DMPItems;
import net.des.darkmoonproject.recipe.DMPRecipes;
import net.des.darkmoonproject.world.feature.DMPConfiguredFeatures;
import net.des.darkmoonproject.world.feature.DMPPlacedFeatures;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DarkMoonProject.MOD_ID)
public class DarkMoonProject
{
    public static final String MOD_ID = "darkmoonproject";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DarkMoonProject()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Items and blocks initialization
        DMPItems.register(modEventBus);
        DMPBlocks.register(modEventBus);

        DMPConfiguredFeatures.register(modEventBus);
        DMPPlacedFeatures.register(modEventBus);

        DMPBlockEntities.register(modEventBus);
        DMPMenuTypes.register(modEventBus);

        DMPRecipes.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(DMPMenuTypes.COBBLESTONE_CRUSHER_MENU.get(), CobblestoneCrusherScreen::new);
            MenuScreens.register(DMPMenuTypes.COBBLESTONE_ALLOY_SMELTER_MENU.get(), CobblestoneAlloySmelterScreen::new);
        }
    }
}
