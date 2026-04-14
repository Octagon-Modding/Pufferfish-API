package org.eu.awesomekalin.pufferfishapi.blocks;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.eu.awesomekalin.pufferfishapi.menus.ChestMenu;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class CustomChestBlock extends BaseEntityBlock {
    public static final MapCodec<CustomChestBlock> CODEC = simpleCodec(CustomChestBlock::new);
    private Supplier<List<BlockEntityType<?>>> blockEntityRenderersSupplier;
    private int position;
    private ChestSettings chestSettings;

    public CustomChestBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public CustomChestBlock(BlockBehaviour.Properties properties, Supplier<List<BlockEntityType<?>>> blockEntityRenderersSupplier, int position, ChestSettings chestSettings) {
        super(properties);
        this.blockEntityRenderersSupplier = blockEntityRenderersSupplier;
        this.position = position;
        this.chestSettings = chestSettings;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CustomChestBlockEntity(blockEntityRenderersSupplier.get(), position, blockPos, blockState, chestSettings);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof CustomChestBlockEntity customChestBlockEntity && !level.isClientSide()) {
            player.openMenu(customChestBlockEntity);
        }

        return InteractionResult.SUCCESS;
    }

    public static class CustomChestBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, Container {
        public NonNullList<ItemStack> inventory;
        private final int maxStackSize;
        private final ChestSettings chestSettings;
        private int slots;

        public CustomChestBlockEntity(List<BlockEntityType<?>> blockEntityRenderers, int position, BlockPos pos, BlockState blockState, ChestSettings chestSettings) {
            super(blockEntityRenderers.get(position), pos, blockState);
            maxStackSize = chestSettings.maxStackSize;
            this.chestSettings = chestSettings;
            this.slots = chestSettings.slotPositions.length;

            inventory = NonNullList.withSize(chestSettings.slotPositions.length, ItemStack.EMPTY);
        }

        @Override
        protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
            super.saveAdditional(tag,registries);
            ContainerHelper.saveAllItems(tag, inventory, registries);
        }

        @Override
        protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
            super.loadAdditional(tag, registries);
            ContainerHelper.loadAllItems(tag, inventory, registries);
        }

        @Override
        public void preRemoveSideEffects(BlockPos pos, BlockState state) {
            assert level != null;
            Containers.dropContents(level, pos, (Container) this);
            super.preRemoveSideEffects(pos, state);
        }

        @Nullable
        @Override
        public Packet<ClientGamePacketListener> getUpdatePacket() {
            return ClientboundBlockEntityDataPacket.create(this);
        }

        @Override
        public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
            return saveWithoutMetadata(pRegistries);
        }

        @Override
        public Component getDisplayName() {
            return Component.literal(chestSettings.guiTextTranslatable);
        }

        @Override
        public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
            return new ChestMenu(i, inventory, this, chestSettings);
        }

        @Override
        public Object getScreenOpeningData(ServerPlayer player) {
            return this.worldPosition;
        }

        @Override
        public int getContainerSize() {
            return this.chestSettings.slotPositions.length;
        }

        @Override
        public boolean isEmpty() {
            for (ItemStack stack : inventory) {
                if (!stack.isEmpty()) return false;
            }
            return true;
        }

        @Override
        public ItemStack getItem(int slot) {
            return inventory.get(slot);
        }

        @Override
        public ItemStack removeItem(int slot, int amount) {
            ItemStack result = ContainerHelper.removeItem(inventory, slot, amount);
            if (!result.isEmpty()) setChanged();
            return result;
        }

        @Override
        public ItemStack removeItemNoUpdate(int slot) {
            return ContainerHelper.takeItem(inventory, slot);
        }

        @Override
        public void setItem(int slot, ItemStack stack) {
            inventory.set(slot, stack);
            if (stack.getCount() > getMaxStackSize()) {
                stack.setCount(getMaxStackSize());
            }
            setChanged();
        }

        @Override
        public boolean stillValid(Player player) {
            return level != null
                    && level.getBlockEntity(worldPosition) == this
                    && player.distanceToSqr(
                    worldPosition.getX() + 0.5,
                    worldPosition.getY() + 0.5,
                    worldPosition.getZ() + 0.5
            ) <= getMaxStackSize();
        }

        @Override
        public void clearContent() {
            inventory.clear();
        }

        @Override
        public int getMaxStackSize() {
            return this.chestSettings.maxStackSize;
        }
    }
}