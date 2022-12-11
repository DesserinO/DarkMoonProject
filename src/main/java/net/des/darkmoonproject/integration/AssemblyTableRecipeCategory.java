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
import net.des.darkmoonproject.recipe.AssemblyTableRecipe;
import net.des.darkmoonproject.recipe.CobblestoneAlloySmelterRecipe;
import net.des.darkmoonproject.util.DMPTags;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class AssemblyTableRecipeCategory implements IRecipeCategory<AssemblyTableRecipe>{
    public final static ResourceLocation UID = new ResourceLocation(DarkMoonProject.MOD_ID, "assembly_table");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(DarkMoonProject.MOD_ID, "textures/gui/assembly_table_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public AssemblyTableRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(DMPBlocks.ASSEMBLY_TABLE.get()));
    }
    @Override
    public RecipeType<AssemblyTableRecipe> getRecipeType() {
        return JEIDarkMoonProjectPlugin.ASSEMBLY_TABLE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Assembly Table");
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
    public void setRecipe(IRecipeLayoutBuilder builder, AssemblyTableRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 32).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 71, 32).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 32).addItemStack(recipe.getResultItem());
        if (recipe.getIngredients().get(2).getItems()[0].is(DMPTags.Items.HAMMER_TOOLS)) {
            builder.addSlot(RecipeIngredientRole.INPUT, 116, 68).addIngredients(recipe.getIngredients().get(2));
        }
        if (recipe.getIngredients().get(2).getItems()[0].is(DMPTags.Items.SCREWDRIVER_TOOLS)) {
            builder.addSlot(RecipeIngredientRole.INPUT, 134, 68).addIngredients(recipe.getIngredients().get(2));
        }
        if (recipe.getIngredients().get(2).getItems()[0].is(DMPTags.Items.WIRE_CUTTER_TOOLS)) {
            builder.addSlot(RecipeIngredientRole.INPUT, 152, 68).addIngredients(recipe.getIngredients().get(2));
        }
    }
}