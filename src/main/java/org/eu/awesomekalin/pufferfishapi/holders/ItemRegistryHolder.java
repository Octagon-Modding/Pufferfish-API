package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class ItemRegistryHolder {
    public final DeferredItem<Item> data;

    public ItemRegistryHolder(DeferredItem<Item> item) {
        this.data = item;
    }
}
