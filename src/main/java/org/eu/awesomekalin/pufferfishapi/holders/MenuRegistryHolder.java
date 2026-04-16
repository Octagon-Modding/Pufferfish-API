package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

public class MenuRegistryHolder<T extends AbstractContainerMenu> {
    public DeferredHolder<@NotNull MenuType<?>, @NotNull MenuType<@NotNull T>> data;

    public MenuRegistryHolder(DeferredHolder<@NotNull MenuType<?>, @NotNull MenuType<@NotNull T>> data) {
        this.data = data;
    }
}