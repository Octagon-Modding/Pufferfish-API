package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.ItemRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.holders.ToolHolder;

public class ItemRegistry {
    private final DeferredRegister.Items register;
    private final String modId;

    public ItemRegistry(String modId) {
        register = DeferredRegister.createItems(modId);
        this.modId = modId;
    }

    public void register() {
        register.register(PufferfishAPI.eventBus);
    }

    public ItemRegistryHolder registerSword(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new SwordItem(new ToolMaterial(
                TagKey.create(
                        Registries.BLOCK,
                        ResourceLocation.fromNamespaceAndPath(
                                toolHolder.material.incorrectForBlocksTag.namespace,
                                toolHolder.material.incorrectForBlocksTag.path
                        )
                ),
                toolHolder.material.durability,
                toolHolder.material.speed,
                toolHolder.material.attackDamageBonus,
                toolHolder.material.enchantValue,
                ItemTags.create(
                        ResourceLocation.fromNamespaceAndPath(
                                toolHolder.material.repairTag.namespace,
                                toolHolder.material.repairTag.path
                        )
                )
        ),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                new Item.Properties().setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                ResourceLocation.fromNamespaceAndPath(
                                        modId, toolHolder.name
                                )
                        )
                )
        )));
    }

    public ItemRegistryHolder registerPickaxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new PickaxeItem(new ToolMaterial(
                TagKey.create(
                        Registries.BLOCK,
                        ResourceLocation.fromNamespaceAndPath(
                                toolHolder.material.incorrectForBlocksTag.namespace,
                                toolHolder.material.incorrectForBlocksTag.path
                        )
                ),
                toolHolder.material.durability,
                toolHolder.material.speed,
                toolHolder.material.attackDamageBonus,
                toolHolder.material.enchantValue,
                ItemTags.create(
                        ResourceLocation.fromNamespaceAndPath(
                                toolHolder.material.repairTag.namespace,
                                toolHolder.material.repairTag.path
                        )
                )
        ),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                new Item.Properties().setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                ResourceLocation.fromNamespaceAndPath(
                                        modId, toolHolder.name
                                )
                        )
                )
        )));
    }

    public ItemRegistryHolder registerAxe(ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(toolHolder.name, () -> new AxeItem(new ToolMaterial(
                TagKey.create(
                        Registries.BLOCK,
                        ResourceLocation.fromNamespaceAndPath(
                                toolHolder.material.incorrectForBlocksTag.namespace,
                                toolHolder.material.incorrectForBlocksTag.path
                        )
                ),
                toolHolder.material.durability,
                toolHolder.material.speed,
                toolHolder.material.attackDamageBonus,
                toolHolder.material.enchantValue,
                ItemTags.create(
                        ResourceLocation.fromNamespaceAndPath(
                                toolHolder.material.repairTag.namespace,
                                toolHolder.material.repairTag.path
                        )
                )
        ),
                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                new Item.Properties().setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                ResourceLocation.fromNamespaceAndPath(
                                        modId, toolHolder.name
                                )
                        )
                )
        )));
    }
}
