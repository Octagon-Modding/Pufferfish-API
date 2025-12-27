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

    public ChestSettings(int maxStackSize, String guiTextTranslatable, Identifier guiTexture, BlockRegistryHolder chestBlock, MenuRegistryHolder<ChestMenu> menu, int[][] slotPositions) {
        this.maxStackSize = maxStackSize;
        this.guiTextTranslatable = guiTextTranslatable;
        this.guiTexture = guiTexture;
        this.chestBlock = chestBlock;
        this.menu = menu;
        this.slotPositions = slotPositions;
    }
}
