package org.eu.awesomekalin.pufferfishapi.menus;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;
import org.jetbrains.annotations.NotNull;

public class ChestScreen extends AbstractContainerScreen<@NotNull ChestMenu> {
    private final ChestSettings chestSettings;

    public ChestScreen(ChestMenu menu, Inventory playerInventory, ChestSettings chestSettings) {
        super(menu, playerInventory, Component.translatable(chestSettings.guiTextTranslatable));
        this.chestSettings = chestSettings;
        this.imageWidth = this.chestSettings.screenWidth;
        this.imageHeight = this.chestSettings.screenHeight;
        this.inventoryLabelX = this.chestSettings.inventoryTextX;
        this.inventoryLabelY = this.chestSettings.inventoryTextY;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(RenderType.GUI_TEXTURED, chestSettings.guiTexture.convertToMinecraftIdentifier(), x, y, 0, 0, imageWidth, imageHeight, this.chestSettings.screenWidth, this.chestSettings.screenHeight);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }
}