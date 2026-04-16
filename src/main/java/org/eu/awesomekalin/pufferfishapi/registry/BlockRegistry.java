package org.eu.awesomekalin.pufferfishapi.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
        final Block chestBlock = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(this.modId, name), new CustomChestBlock(blockProperties.getProperties(new ResourceLocation(this.modId, name)), this::getBlockEntityRenderers, blockEntityRenderers.size(), chestSettings));
        final BlockItem blockItem = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(this.modId, name), new BlockItem(chestBlock, new Item.Properties()));
        final BlockEntityType<?> blockEntity = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(this.modId, name), FabricBlockEntityTypeBuilder.create(
                (pos, blockState) -> new CustomChestBlock.CustomChestBlockEntity(blockEntityRenderers, blockEntityRenderers.size() - 1, pos, blockState, chestSettings),
                chestBlock
        ).build(null));
        blockEntityRenderers.add(blockEntity);
        return new BlockRegistryHolder(chestBlock, blockItem, blockEntity);
    }

    public List<BlockEntityType<?>> getBlockEntityRenderers() {
        return blockEntityRenderers;
    }
}