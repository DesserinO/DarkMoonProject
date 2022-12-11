package net.des.darkmoonproject.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.des.darkmoonproject.DarkMoonProject;
import net.des.darkmoonproject.init.DMPBlocks;
import net.des.darkmoonproject.recipe.CobblestoneAlloySmelterRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class CobblestoneAlloySmelterRecipeCategory implements IRecipeCategory<CobblestoneAlloySmelterRecipe>{
    public final static ResourceLocation UID = new ResourceLocation(DarkMoonProject.MOD_ID, "cobblestone_alloy_smelter");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(DarkMoonProject.MOD_ID, "textures/gui/cobblestone_alloy_smelter_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public CobblestoneAlloySmelterRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(DMPBlocks.COBBLESTONE_ALLOY_SMELTER.get()));
    }
    @Override
    public RecipeType<CobblestoneAlloySmelterRecipe> getRecipeType() {
        return JEIDarkMoonProjectPlugin.COBBLESTONE_ALLOY_SMELTER_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Alloy Smelter");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CobblestoneAlloySmelterRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 24, 33).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 33).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 123, 33).addItemStack(recipe.getResultItem());
    }
}