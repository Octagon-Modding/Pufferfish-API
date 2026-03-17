package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.blocks.CustomChestBlock;
import org.eu.awesomekalin.pufferfishapi.holders.BlockRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.util.BlockProperties;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class BlockRegistry {
    private final DeferredRegister<Block> register;
    private final DeferredRegister<Item> itemRegister;
    private final DeferredRegister<BlockEntityType<?>> blockEntityRegister;
    private final List<Supplier<BlockEntityType<?>>> blockEntityRenderers = new ArrayList<>();
    private final String modId;

    public BlockRegistry(String modId) {
        register = DeferredRegister.create(ForgeRegistries.BLOCKS, modId);
        itemRegister = DeferredRegister.create(ForgeRegistries.ITEMS, modId);
        blockEntityRegister = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, modId);
        this.modId = modId;
    }

    public void register() {
        register.register(PufferfishAPI.context.getModBusGroup());
        itemRegister.register(PufferfishAPI.context.getModBusGroup());
        blockEntityRegister.register(PufferfishAPI.context.getModBusGroup());
    }

    public BlockRegistryHolder registerChest(String name, BlockProperties blockProperties, ChestSettings chestSettings) {
        final RegistryObject<Block> chestBlock = register.register(name, () -> new CustomChestBlock(blockProperties.getProperties(Identifier.fromNamespaceAndPath(modId, name)), this::getBlockEntityRenderers, blockEntityRenderers.size() -1, chestSettings));
        final RegistryObject<BlockItem> blockItem = itemRegister.register(name, () -> new BlockItem(chestBlock.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(modId, name)))));
        final Supplier<BlockEntityType<?>> blockEntity = blockEntityRegister.register(name, () -> new BlockEntityType<CustomChestBlock.@NotNull CustomChestBlockEntity>(
                (pos, blockState) ->
                        new CustomChestBlock.CustomChestBlockEntity(
                                blockEntityRenderers,
                                blockEntityRenderers.size() - 1,
                                pos,
                                blockState,
                                chestSettings
                        ),
                Set.of(chestBlock.get())
        ));
        blockEntityRenderers.add(blockEntity);
        return new BlockRegistryHolder(chestBlock, blockItem, blockEntity);
    }

    public List<Supplier<BlockEntityType<?>>> getBlockEntityRenderers() {
        return blockEntityRenderers;
    }
}