package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.ItemRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.holders.SwordHolder;

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

    public ItemRegistryHolder registerSword(SwordHolder swordHolder) {
        return new ItemRegistryHolder(register.register(swordHolder.name, () -> new SwordItem(new net.minecraft.world.item.ToolMaterial(
                TagKey.create(
                        Registries.BLOCK,
                        ResourceLocation.fromNamespaceAndPath(
                                swordHolder.material.incorrectForBlocksTag.namespace,
                                swordHolder.material.incorrectForBlocksTag.path
                        )
                ),
                swordHolder.material.durability,
                swordHolder.material.speed,
                swordHolder.material.attackDamageBonus,
                swordHolder.material.enchantValue,
                ItemTags.create(
                        ResourceLocation.fromNamespaceAndPath(
                                swordHolder.material.repairTag.namespace,
                                swordHolder.material.repairTag.path
                        )
                )
        ),
                swordHolder.attackDamage,
                swordHolder.attackSpeed,
                new Item.Properties().setId(
                        ResourceKey.create(
                                Registries.ITEM,
                                ResourceLocation.fromNamespaceAndPath(
                                        modId, swordHolder.name
                                )
                        )
                )
        )));
    }
}
