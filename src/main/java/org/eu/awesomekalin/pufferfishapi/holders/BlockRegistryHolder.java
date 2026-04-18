package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.jetbrains.annotations.Nullable;

public class BlockRegistryHolder {
    public final Block data;
    public final BlockItem dataItem;
    @Nullable
    public final BlockEntityType<?> dataBlockEntity;

    public BlockRegistryHolder(Block block, BlockItem item, BlockEntityType<?> blockEntity) {
        data = block;
        dataItem = item;
        dataBlockEntity = blockEntity;
    }
}