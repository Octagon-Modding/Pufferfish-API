package org.eu.awesomekalin.pufferfishapi.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
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
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.menus.ChestMenu;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class CustomChestBlock extends BaseEntityBlock {
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

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CustomChestBlockEntity(blockEntityRenderersSupplier.get(), position, blockPos, blockState, chestSettings);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof CustomChestBlockEntity customChestBlockEntity && !level.isClientSide()) {
            player.openMenu(new SimpleMenuProvider(customChestBlockEntity, Component.literal(this.chestSettings.guiTextTranslatable)), pos);
        }

        return InteractionResult.SUCCESS;
    }

    public static class CustomChestBlockEntity extends BlockEntity implements MenuProvider {
        public ItemStacksResourceHandler inventory;
        private final int maxStackSize;
        private final ChestSettings chestSettings;
        private int slots;

        public CustomChestBlockEntity(List<Supplier<BlockEntityType<?>>> blockEntityRenderers, int position, BlockPos pos, BlockState blockState, ChestSettings chestSettings) {
            super(blockEntityRenderers.get(position).get(), pos, blockState);
            maxStackSize = chestSettings.maxStackSize;
            this.chestSettings = chestSettings;
            this.slots = chestSettings.slotPositions.length;

            inventory = new ItemStacksResourceHandler(chestSettings.slotPositions.length) {
                @Override
                protected int getCapacity(int index, ItemResource resource) {
                    return resource.isEmpty() ? maxStackSize : Math.min(resource.getMaxStackSize(), maxStackSize);
                }

                @Override
                protected void onContentsChanged(int slot, @NotNull ItemStack previousContents) {
                    setChanged();
                    assert level != null;
                    if(!level.isClientSide()) {
                        level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                    }
                }
            };
        }

        @Override
        protected void saveAdditional(ValueOutput output) {
            super.saveAdditional(output);
            //output.putInt("slots", chestSettings.slotPositions.length);
            inventory.serialize(output);
        }

        @Override
        protected void loadAdditional(ValueInput input) {
            super.loadAdditional(input);
            //this.slots = input.getInt("slots").get();
            inventory.deserialize(input);
        }

        public void drops() {
            SimpleContainer inv = new SimpleContainer(chestSettings.slotPositions.length);
            for(int i = 0; i < chestSettings.slotPositions.length; i++) {
                inv.setItem(i, inventory.getResource(i).toStack(inventory.getAmountAsInt(i)));
            }

            Containers.dropContents(this.level, this.worldPosition, inv);
        }

        @Override
        public void preRemoveSideEffects(BlockPos pos, BlockState state) {
            drops();
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
        public @org.jspecify.annotations.Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
            return new ChestMenu(i, inventory, this, chestSettings);
        }
    }
}
