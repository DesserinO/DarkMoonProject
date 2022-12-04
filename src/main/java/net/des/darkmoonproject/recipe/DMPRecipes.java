package net.des.darkmoonproject.recipe;

import net.des.darkmoonproject.DarkMoonProject;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DMPRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, DarkMoonProject.MOD_ID);

    public static final RegistryObject<RecipeSerializer<CobblestoneCrusherRecipe>> COBBLESTONE_CRUSHER =
            SERIALIZERS.register("cobblestone_crusher", () -> CobblestoneCrusherRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
