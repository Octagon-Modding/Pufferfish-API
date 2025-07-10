package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class BlockRegistryHolder {
    public final DeferredBlock<Block> data;
    public final DeferredItem<BlockItem> dataItem;

    public BlockRegistryHolder(DeferredBlock<Block> block, DeferredItem<BlockItem> item) {
        data = block;
        dataItem = item;
    }
}
