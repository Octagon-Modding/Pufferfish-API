package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.ItemRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.holders.ToolHolder;

public class ItemRegistry {
    private final DeferredRegister<Item> register;

    public ItemRegistry(String modId) {
        register = DeferredRegister.create(ForgeRegistries.ITEMS, modId);
    }

    public void register() {
        register.register(PufferfishAPI.context.getModEventBus());
    }

    public ItemRegistryHolder registerSword(String name, ToolHolder toolHolder) {
        return new ItemRegistryHolder(register.register(name, () -> new SwordItem(new net.minecraft.world.item.ToolMaterial(
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
                                        toolHolder.identifier.namespace, toolHolder.identifier.path
                                )
                        )
                )
        )));
    }
}
