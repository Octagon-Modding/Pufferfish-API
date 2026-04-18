package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class BlockRegistryHolder {
    public final RegistryObject<Block> data;
    public final RegistryObject<BlockItem> dataItem;
    @Nullable public final Supplier<BlockEntityType<?>> dataBlockEntity;

    public BlockRegistryHolder(RegistryObject<Block> block, RegistryObject<BlockItem> item, Supplier<BlockEntityType<?>> blockEntity) {
        data = block;
        dataItem = item;
        dataBlockEntity = blockEntity;
    }
}