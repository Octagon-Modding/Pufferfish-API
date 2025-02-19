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
import org.eu.awesomekalin.pufferfishapi.holders.SwordHolder;
import net.minecraft.registry.tag.TagKey;

public class ItemRegistry {
    private final String modId;

    public ItemRegistry(String modId) {
        this.modId = modId;
    }

    public void register() {}

    public ItemRegistryHolder registerSword(SwordHolder swordHolder) {
        return new ItemRegistryHolder(Registry.register(Registries.ITEM, Identifier.of(this.modId, swordHolder.name), new SwordItem(
                new ToolMaterial(TagKey.of(
                        RegistryKeys.BLOCK,
                        Identifier.of(
                                swordHolder.material.incorrectForBlocksTag.namespace,
                                swordHolder.material.incorrectForBlocksTag.path
                        )
                ),
                        swordHolder.material.durability,
                        swordHolder.material.speed,
                        swordHolder.material.attackDamageBonus,
                        swordHolder.material.enchantValue,
                        TagKey.of(
                                RegistryKeys.ITEM,
                                Identifier.of(
                                        swordHolder.material.repairTag.namespace,
                                        swordHolder.material.repairTag.path
                                )
                        )
                ),

                swordHolder.attackDamage,
                swordHolder.attackSpeed,
                new Item.Settings().registryKey(
                        RegistryKey.of(
                                RegistryKeys.ITEM,
                                Identifier.of(
                                        modId, swordHolder.name
                                )
                        )
                )
        )));
    }
}
