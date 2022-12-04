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
import net.des.darkmoonproject.recipe.CobblestoneCrusherRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class CobblestoneCrusherRecipeCategory implements IRecipeCategory<CobblestoneCrusherRecipe>{
    public final static ResourceLocation UID = new ResourceLocation(DarkMoonProject.MOD_ID, "cobblestone_crusher");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(DarkMoonProject.MOD_ID, "textures/gui/cobblestone_crusher_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public CobblestoneCrusherRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(DMPBlocks.COBBLESTONE_CRUSHER.get()));
    }
    @Override
    public RecipeType<CobblestoneCrusherRecipe> getRecipeType() {
        return JEIDarkMoonProjectPlugin.COBBLESTONE_CRUSHER_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Crusher");
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
    public void setRecipe(IRecipeLayoutBuilder builder, CobblestoneCrusherRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 33).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 117, 33).addItemStack(recipe.getResultItem());
    }
}