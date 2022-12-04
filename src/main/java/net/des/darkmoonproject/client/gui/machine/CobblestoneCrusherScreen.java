package net.des.darkmoonproject.client.gui.machine;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.des.darkmoonproject.DarkMoonProject;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CobblestoneCrusherScreen extends AbstractContainerScreen<CobblestoneCrusherMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(DarkMoonProject.MOD_ID,"textures/gui/cobblestone_crusher_gui.png");

    public CobblestoneCrusherScreen(CobblestoneCrusherMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(pPoseStack, x, y);

    }

    private void renderProgressArrow(PoseStack pPoseStack, int x, int y) {
        if(menu.isCrafting()) {
            /*2 arg: X pos of your arrow (x + 71); 3 arg: Y pos of your arrow (y + 33);
            * 4 arg: actual start of arrow on gui image X (176); 5 arg: as a 4 arg but for Y (0)
            * 6 arg: increasing value from 0 (→), decreasing value from width of arrow (←);
            * 7 arg: increasing value from 0 (↓), decreasing value from height of arrow (↑); */
            blit(pPoseStack, x + 71, y + 33, 176, 0, menu.getScaledProgress(), 16);
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}
