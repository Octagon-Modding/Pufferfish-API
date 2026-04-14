package org.eu.awesomekalin.pufferfishapi.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
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
import net.minecraftforge.common.extensions.IForgeServerPlayer;
import org.eu.awesomekalin.pufferfishapi.menus.ChestMenu;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class CustomChestBlock extends BaseEntityBlock {
    public static final MapCodec<CustomChestBlock> CODEC = simpleCodec(CustomChestBlock::new);
    private Supplier<List<Supplier<BlockEntityType<?>>>> blockEntityRenderersSupplier;
    private int position;
    private ChestSettings chestSettings;

    public CustomChestBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public CustomChestBlock(BlockBehaviour.Properties properties, Supplier<List<Supplier<BlockEntityType<?>>>> blockEntityRenderersSupplier, int position, ChestSettings chestSettings) {
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
            IForgeServerPlayer thePlayer = (IForgeServerPlayer) player;

            thePlayer.openMenu(new SimpleMenuProvider(customChestBlockEntity, Component.literal(this.chestSettings.guiTextTranslatable)), pos);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (state.getBlock() != newState.getBlock()) {
            if (level.getBlockEntity(pos) instanceof CustomChestBlockEntity customChestBlockEntity) {
                Containers.dropContents(level, pos, (Container) this);
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }

        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    public static class CustomChestBlockEntity extends BlockEntity implements MenuProvider, Container {
        public NonNullList<@NotNull ItemStack> inventory;
        private final ChestSettings chestSettings;

        public CustomChestBlockEntity(List<Supplier<BlockEntityType<?>>> blockEntityRenderers, int position, BlockPos pos, BlockState blockState, ChestSettings chestSettings) {
            super(blockEntityRenderers.get(position).get(), pos, blockState);
            this.chestSettings = chestSettings;

            inventory =  NonNullList.withSize(chestSettings.slotPositions.length, ItemStack.EMPTY);
        }

        @Override
        protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
            super.saveAdditional(tag, provider);
            //output.putInt("slots", chestSettings.slotPositions.length);
            ContainerHelper.saveAllItems(tag, inventory, provider);
        }

        @Override
        protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
            super.loadAdditional(tag, provider);
            //this.slots = input.getInt("slots").get();
            ContainerHelper.loadAllItems(tag, inventory, provider);
        }

        @Nullable
        @Override
        public Packet<@NotNull ClientGamePacketListener> getUpdatePacket() {
            return ClientboundBlockEntityDataPacket.create(this);
        }

        @Override
        public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider pRegistries) {
            return saveWithoutMetadata(pRegistries);
        }

        @Override
        public @NotNull Component getDisplayName() {
            return Component.literal(chestSettings.guiTextTranslatable);
        }

        @Override
        public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
            return new ChestMenu(i, inventory, this, chestSettings);
        }

        @Override
        public int getContainerSize() {
            return this.chestSettings.slotPositions.length;
        }

        @Override
        public boolean isEmpty() {
            return this.inventory.stream().allMatch(ItemStack::isEmpty);
        }

        @Override
        public @NotNull ItemStack getItem(int slot) {
            return this.inventory.get(slot);
        }

        @Override
        public @NotNull ItemStack removeItem(int slot, int amount) {
            ItemStack stack = ContainerHelper.removeItem(this.inventory, slot, amount);
            this.setChanged();
            return stack;
        }

        @Override
        public @NotNull ItemStack removeItemNoUpdate(int slot) {
            ItemStack stack = ContainerHelper.takeItem(this.inventory, slot);
            this.setChanged();
            return stack;
        }

        @Override
        public int getMaxStackSize(ItemStack stack) {
            return Math.min(this.chestSettings.maxStackSize, stack.getMaxStackSize());
        }

        @Override
        public void setItem(int slot, ItemStack stack) {
            stack.limitSize(this.getMaxStackSize(stack));
            this.inventory.set(slot, stack);
            this.setChanged();
        }

        @Override
        public boolean stillValid(Player player) {
            return true;
        }

        @Override
        public void clearContent() {
            inventory.clear();
            this.setChanged();
        }

        @Override
        public void setChanged() {

        }
    }
}