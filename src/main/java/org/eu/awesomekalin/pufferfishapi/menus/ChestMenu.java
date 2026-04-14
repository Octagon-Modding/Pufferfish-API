package org.eu.awesomekalin.pufferfishapi.menus;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;

public class ChestMenu extends AbstractContainerMenu {
    private final Container inv;
    private final ChestSettings chestSettings;

    public ChestMenu(int containerId, Inventory playerInv, BlockPos pos, ChestSettings chestSettings) {
        this(containerId, playerInv, playerInv.player.level().getBlockEntity(pos), chestSettings);
    }

    public ChestMenu(int containerId, Inventory playerInv, BlockEntity blockEntity, ChestSettings chestSettings) {
        super((MenuType<?>) chestSettings.menu.data, containerId);

        if (!(blockEntity instanceof Container container)) {
            throw new IllegalStateException("Block entity is not a container");
        }

        this.inv = container;
        this.chestSettings = chestSettings;

        addPlayerInventory(playerInv);
        addPlayerHotbar(playerInv);

        for (var i = 0; i < chestSettings.slotPositions.length; i++) {
            this.addSlot(new Slot(inv, i, chestSettings.slotPositions[i][0], chestSettings.slotPositions[i][1]));
        }
    }

    // https://github.com/Tutorials-By-Kaupenjoe/NeoForge-Tutorial-1.21.X/blob/main/src/main/java/net/kaupenjoe/tutorialmod/screen/custom/PedestalMenu.java#L36
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + this.chestSettings.slotPositions.length, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + this.chestSettings.slotPositions.length) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.inv.stillValid(player);
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 9; i < 36; i++) {
            this.addSlot(new Slot(playerInventory, i, this.chestSettings.inventorySlotPositions[i-9][0], this.chestSettings.inventorySlotPositions[i-9][1]));
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, this.chestSettings.hotbarSlotPositions[i][0], this.chestSettings.hotbarSlotPositions[i][1]));
        }
    }
}