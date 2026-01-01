package org.eu.awesomekalin.pufferfishapi.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.eu.awesomekalin.pufferfishapi.blocks.CustomChestBlock;
import org.eu.awesomekalin.pufferfishapi.holders.BlockRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.util.BlockProperties;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;

import java.util.ArrayList;
import java.util.List;

public class BlockRegistry {
    private final List<BlockEntityType<?>> blockEntityRenderers = new ArrayList<>();
    private final String modId;

    public BlockRegistry(String modId) {
        this.modId = modId;
    }

    public void register() {}

    public BlockRegistryHolder registerChest(String name, BlockProperties blockProperties, ChestSettings chestSettings) {
        final Block chestBlock = Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(this.modId, name), new CustomChestBlock(blockProperties.getProperties(Identifier.fromNamespaceAndPath(this.modId, name)), this::getBlockEntityRenderers, blockEntityRenderers.size() - 1, chestSettings));
        final BlockItem blockItem = Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(this.modId, name), new BlockItem(chestBlock, new Item.Properties()));
        final BlockEntityType<?> blockEntity = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(this.modId, name), FabricBlockEntityTypeBuilder.create(
                (pos, blockState) -> new CustomChestBlock.CustomChestBlockEntity(blockEntityRenderers, blockEntityRenderers.size() - 1, pos, blockState, chestSettings),
                chestBlock
        ).build());
        blockEntityRenderers.add(blockEntity);
        return new BlockRegistryHolder(chestBlock, blockItem, blockEntity);
    }

    public List<BlockEntityType<?>> getBlockEntityRenderers() {
        return blockEntityRenderers;
    }
}