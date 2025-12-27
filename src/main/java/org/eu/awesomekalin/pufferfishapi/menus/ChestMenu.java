package org.eu.awesomekalin.pufferfishapi.menus;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.eu.awesomekalin.pufferfishapi.blocks.CustomChestBlock;
import org.eu.awesomekalin.pufferfishapi.holders.MenuRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;

public class ChestMenu extends AbstractContainerMenu {
    public final CustomChestBlock.CustomChestBlockEntity blockEntity;
    private final Level level;
    private final ChestSettings chestSettings;

    public ChestMenu(int containerId, Inventory inv, FriendlyByteBuf extraData, ChestSettings chestSettings) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), chestSettings);
    }

    public ChestMenu(int containerId, Inventory inv, BlockEntity blockEntity, ChestSettings chestSettings) {
        super((MenuType<?>) chestSettings.menu.data.get(), containerId);
        this.blockEntity = ((CustomChestBlock.CustomChestBlockEntity) blockEntity);
        this.level = inv.player.level();
        this.chestSettings = chestSettings;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        for (var i = 0; i < chestSettings.slotPositions.length; i++) {
            this.addSlot(new SlotItemHandler(this.blockEntity.inventory, i, chestSettings.slotPositions[i][0], chestSettings.slotPositions[i][1]));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, chestSettings.chestBlock.data.get());
    }

    // https://github.com/Tutorials-By-Kaupenjoe/NeoForge-Tutorial-1.21.X/blob/main/src/main/java/net/kaupenjoe/tutorialmod/screen/custom/PedestalMenu.java#L92C5-L104C6
    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
