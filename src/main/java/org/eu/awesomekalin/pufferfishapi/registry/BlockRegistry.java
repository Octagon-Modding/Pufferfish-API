package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.blocks.CustomChestBlock;
import org.eu.awesomekalin.pufferfishapi.holders.BlockRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.util.BlockProperties;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockRegistry {
    private final DeferredRegister.Blocks register;
    private final DeferredRegister.Items itemRegister;
    private final DeferredRegister<BlockEntityType<?>> blockEntityRegister;
    private final List<Supplier<BlockEntityType<?>>> blockEntityRenderers = new ArrayList<>();

    public BlockRegistry(String modId) {
        register = DeferredRegister.createBlocks(modId);
        itemRegister = DeferredRegister.createItems(modId);
        blockEntityRegister = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, modId);
    }

    public void register() {
        register.register(PufferfishAPI.eventBus);
        itemRegister.register(PufferfishAPI.eventBus);
        blockEntityRegister.register(PufferfishAPI.eventBus);
    }

    public BlockRegistryHolder registerChest(String name, BlockProperties blockProperties, ChestSettings chestSettings) {
        final DeferredBlock<Block> chestBlock = register.register(name, registryName -> new CustomChestBlock(blockProperties.getProperties(registryName), this::getBlockEntityRenderers, blockEntityRenderers.size() -1, chestSettings));
        final DeferredItem<BlockItem> blockItem = itemRegister.registerSimpleBlockItem(chestBlock);
        final Supplier<BlockEntityType<?>> blockEntity = blockEntityRegister.register(name, () -> BlockEntityType.Builder.of(
                (pos, blockState) -> new CustomChestBlock.CustomChestBlockEntity(blockEntityRenderers, blockEntityRenderers.size() - 1, pos, blockState, chestSettings),
                chestBlock.get()
        ).build(null));
        blockEntityRenderers.add(blockEntity);
        return new BlockRegistryHolder(chestBlock, blockItem, blockEntity);
    }

    public List<Supplier<BlockEntityType<?>>> getBlockEntityRenderers() {
        return blockEntityRenderers;
    }
}