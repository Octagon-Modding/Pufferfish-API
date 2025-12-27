package org.eu.awesomekalin.pufferfishapi.util;

import org.eu.awesomekalin.pufferfishapi.holders.BlockRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.holders.MenuRegistryHolder;

public class ChestSettings {
    public final int maxStackSize;
    public final String guiTextTranslatable;
    public final Identifier guiTexture;
    public final BlockRegistryHolder chestBlock;
    public final MenuRegistryHolder menu;
    public final int[][] slotPositions;

    public ChestSettings(int maxStackSize, String guiTextTranslatable, Identifier guiTexture, BlockRegistryHolder chestBlock, MenuRegistryHolder menu, int[][] slotPositions) {
        this.maxStackSize = maxStackSize;
        this.guiTextTranslatable = guiTextTranslatable;
        this.guiTexture = guiTexture;
        this.chestBlock = chestBlock;
        this.menu = menu;
        this.slotPositions = slotPositions;
    }
}
