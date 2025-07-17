/*package org.eu.awesomekalin.pufferfishapi.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.eu.awesomekalin.pufferfishapi.registry.BlockRegistry;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;
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

    public static class CustomChestBlockEntity extends BlockEntity {
        private final ItemStackHandler inventory;
        private final int maxStackSize;

        public CustomChestBlockEntity(List<Supplier<BlockEntityType<?>>> blockEntityRenderers, int position, BlockPos pos, BlockState blockState, ChestSettings chestSettings) {
            super(blockEntityRenderers.get(position).get(), pos, blockState);
            maxStackSize = chestSettings.maxStackSize;

            inventory = new ItemStackHandler(chestSettings.inventorySize) {
                @Override
                protected int getStackLimit(int slot, ItemStack stack) {
                    return maxStackSize;
                }
            };
        }

        @Override
        protected void saveAdditional(ValueOutput output) {
            super.saveAdditional(output);
            inventory.serialize(output);
        }

        @Override
        protected void loadAdditional(ValueInput input) {
            super.loadAdditional(input);
            inventory.deserialize(input);
        }

        public void drops() {
            SimpleContainer inv = new SimpleContainer(inventory.getSlots());
            for(int i = 0; i < inventory.getSlots(); i++) {
                inv.setItem(i, inventory.getStackInSlot(i));
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
    }
}
*/