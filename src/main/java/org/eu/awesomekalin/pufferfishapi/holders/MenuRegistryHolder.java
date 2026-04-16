package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.jetbrains.annotations.NotNull;

public class MenuRegistryHolder<T extends AbstractContainerMenu> {
    public @NotNull MenuType<?> data;

    public MenuRegistryHolder(@NotNull MenuType<?> data) {
        this.data = data;
    }
}