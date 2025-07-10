package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.eu.awesomekalin.pufferfishapi.holders.BlockRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.util.BlockProperties;

public class BlockRegistry {
    private final DeferredRegister.Blocks register;
    private final DeferredRegister.Items itemRegister;
    private final String modId;

    public BlockRegistry(String modId) {
        register = DeferredRegister.createBlocks(modId);
        itemRegister = DeferredRegister.createItems(modId);
        this.modId = modId;
    }

    public BlockRegistryHolder registerChest(String name, BlockProperties blockProperties) {
        final DeferredBlock<Block> chestBlock = register.register(name, registryName -> new Block(blockProperties.getProperties(registryName)));
        final DeferredItem<BlockItem> blockItem = itemRegister.registerSimpleBlockItem(chestBlock);
        return new BlockRegistryHolder(chestBlock, blockItem);
    }
}
