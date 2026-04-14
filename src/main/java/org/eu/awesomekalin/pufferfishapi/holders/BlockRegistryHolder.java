package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class BlockRegistryHolder {
    public final DeferredBlock<Block> data;
    public final DeferredItem<BlockItem> dataItem;
    @Nullable public final Supplier<BlockEntityType<?>> dataBlockEntity;

    public BlockRegistryHolder(DeferredBlock<Block> block, DeferredItem<BlockItem> item, Supplier<BlockEntityType<?>> blockEntity) {
        data = block;
        dataItem = item;
        dataBlockEntity = blockEntity;
    }
}