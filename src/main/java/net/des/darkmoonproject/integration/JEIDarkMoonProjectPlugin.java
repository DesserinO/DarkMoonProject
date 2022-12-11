package net.des.darkmoonproject.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.des.darkmoonproject.DarkMoonProject;
import net.des.darkmoonproject.recipe.AssemblyTableRecipe;
import net.des.darkmoonproject.recipe.CobblestoneAlloySmelterRecipe;
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

    public static RecipeType<CobblestoneAlloySmelterRecipe> COBBLESTONE_ALLOY_SMELTER_TYPE =
            new RecipeType<>(CobblestoneAlloySmelterRecipeCategory.UID, CobblestoneAlloySmelterRecipe.class);

    public static RecipeType<AssemblyTableRecipe> ASSEMBLY_TABLE_TYPE =
            new RecipeType<>(AssemblyTableRecipeCategory.UID, AssemblyTableRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(DarkMoonProject.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CobblestoneCrusherRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()
        ));

        registration.addRecipeCategories(new CobblestoneAlloySmelterRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()
        ));

        registration.addRecipeCategories(new AssemblyTableRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()
        ));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<CobblestoneCrusherRecipe> recipesCrushing = rm.getAllRecipesFor(CobblestoneCrusherRecipe.Type.INSTANCE);
        registration.addRecipes(COBBLESTONE_CRUSHER_TYPE, recipesCrushing);

        List<CobblestoneAlloySmelterRecipe> recipesAlloying = rm.getAllRecipesFor(CobblestoneAlloySmelterRecipe.Type.INSTANCE);
        registration.addRecipes(COBBLESTONE_ALLOY_SMELTER_TYPE, recipesAlloying);

        List<AssemblyTableRecipe> recipesAssembling = rm.getAllRecipesFor(AssemblyTableRecipe.Type.INSTANCE);
        registration.addRecipes(ASSEMBLY_TABLE_TYPE, recipesAssembling);
    }
}
