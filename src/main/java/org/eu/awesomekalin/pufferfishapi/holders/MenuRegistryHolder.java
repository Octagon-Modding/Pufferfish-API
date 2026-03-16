package org.eu.awesomekalin.pufferfishapi.holders;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class MenuRegistryHolder<T extends AbstractContainerMenu> {
    public RegistryObject<@NotNull MenuType<@NotNull T>> data;

    public MenuRegistryHolder(RegistryObject<@NotNull MenuType<@NotNull T>> data) {
        this.data = data;
    }
}