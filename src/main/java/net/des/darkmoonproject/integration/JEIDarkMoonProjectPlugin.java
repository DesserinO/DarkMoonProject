package net.des.darkmoonproject.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.des.darkmoonproject.DarkMoonProject;
import net.des.darkmoonproject.recipe.CobblestoneCrusherRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIDarkMoonProjectPlugin implements IModPlugin {
    public static RecipeType<CobblestoneCrusherRecipe> COBBLESTONE_CRUSHER_TYPE =
            new RecipeType<>(CobblestoneCrusherRecipeCategory.UID, CobblestoneCrusherRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(DarkMoonProject.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CobblestoneCrusherRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()
        ));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<CobblestoneCrusherRecipe> recipesCrushing = rm.getAllRecipesFor(CobblestoneCrusherRecipe.Type.INSTANCE);
        registration.addRecipes(COBBLESTONE_CRUSHER_TYPE, recipesCrushing);
    }
}
