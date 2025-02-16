package org.eu.awesomekalin.pufferfishapi.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.eu.awesomekalin.pufferfishapi.holders.ItemRegistryHolder;

import java.util.List;

public class CreativeTabRegistry {
    private final String modId;

    public CreativeTabRegistry(String modId) {
        this.modId = modId;
    }

    public void register() {}

    public void registerTab(String tabId, String titleIdentifier, ItemRegistryHolder icon, List<ItemRegistryHolder> tabContents) {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(modId, tabId), FabricItemGroup.builder()
                .icon(() -> new ItemStack(icon.data))
                .displayName(Text.translatable(titleIdentifier))
                .build()
        );

        ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(modId, tabId))).register(itemGroup -> {
            tabContents.forEach(item -> {
                itemGroup.add(new ItemStack(item.data));
            });
        });
    }
}
