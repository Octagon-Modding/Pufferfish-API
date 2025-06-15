package org.eu.awesomekalin.pufferfishapi.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.eu.awesomekalin.pufferfishapi.holders.ItemRegistryHolder;

import java.util.List;

public class CreativeTabRegistry {
    private final String modId;

    public CreativeTabRegistry(String modId) {
        this.modId = modId;
    }

    public void register() {}

    public void registerTab(String tabId, String titleIdentifier, ItemRegistryHolder icon, List<ItemRegistryHolder> tabContents) {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceLocation.tryBuild(modId, tabId), FabricItemGroup.builder()
                .icon(() -> new ItemStack(icon.data))
                .title(Component.translatable(titleIdentifier))
                .build()
        );

        ItemGroupEvents.modifyEntriesEvent(ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), ResourceLocation.tryBuild(modId, tabId))).register(itemGroup -> {
            tabContents.forEach(item -> {
                itemGroup.accept(new ItemStack(item.data));
            });
        });
    }
}
