package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.eu.awesomekalin.pufferfishapi.holders.ItemRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.holders.ToolHolder;
import net.minecraft.registry.tag.TagKey;

public class ItemRegistry {
    private final String modId;

    public ItemRegistry(String modId) {
        this.modId = modId;
    }

    public void register() {}

    public ItemRegistryHolder registerSword(String name, ToolHolder toolHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, name), new SwordItem(
                new ToolMaterial(TagKey.of(
                        RegistryKeys.BLOCK,
                        Identifier.of(
                                toolHolder.material.incorrectForBlocksTag.namespace,
                                toolHolder.material.incorrectForBlocksTag.path
                        )
                ),
                        toolHolder.material.durability,
                        toolHolder.material.speed,
                        toolHolder.material.attackDamageBonus,
                        toolHolder.material.enchantValue,
                        TagKey.of(
                                RegistryKeys.ITEM,
                                Identifier.of(
                                        toolHolder.material.repairTag.namespace,
                                        toolHolder.material.repairTag.path
                                )
                        )
                ),

                toolHolder.attackDamage,
                toolHolder.attackSpeed,
                new Item.Settings().registryKey(
                        RegistryKey.of(
                                RegistryKeys.ITEM,
                                Identifier.of(
                                        toolHolder.identifier.namespace, toolHolder.identifier.path
                                )
                        )
                )
        )));
    }
}
