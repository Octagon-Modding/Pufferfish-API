package org.eu.awesomekalin.pufferfishapi.util;

import org.eu.awesomekalin.pufferfishapi.holders.BlockRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.holders.MenuRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.menus.ChestMenu;

public class ChestSettings {
    public final int maxStackSize;
    public final String guiTextTranslatable;
    public final Identifier guiTexture;
    public BlockRegistryHolder chestBlock;
    public MenuRegistryHolder<ChestMenu> menu;
    public final int[][] slotPositions;
    public final int[][] inventorySlotPositions;
    public final int[][] hotbarSlotPositions;
    public final int screenWidth;
    public final int screenHeight;
    public final int inventoryTextX;
    public final int inventoryTextY;

    public ChestSettings(
            int maxStackSize,
            String guiTextTranslatable,
            Identifier guiTexture,
            BlockRegistryHolder chestBlock,
            MenuRegistryHolder<ChestMenu> menu,
            int[][] slotPositions,
            int[][] inventorySlotPositions,
            int[][] hotbarSlotPositions,
            int screenWidth,
            int screenHeight,
            int inventoryTextX,
            int inventoryTextY
    ) {
        this.maxStackSize = maxStackSize;
        this.guiTextTranslatable = guiTextTranslatable;
        this.guiTexture = guiTexture;
        this.chestBlock = chestBlock;
        this.menu = menu;
        this.slotPositions = slotPositions;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.inventorySlotPositions = inventorySlotPositions;
        this.hotbarSlotPositions = hotbarSlotPositions;
        this.inventoryTextX = inventoryTextX;
        this.inventoryTextY = inventoryTextY;
    }
}