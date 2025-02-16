package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistryHolder {
    public final RegistryObject<Item> data;

    public ItemRegistryHolder(RegistryObject<Item> item) {
        this.data = item;
    }
}
