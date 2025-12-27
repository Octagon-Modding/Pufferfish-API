package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.MenuRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.menus.ChestMenu;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;
import org.jetbrains.annotations.NotNull;

public class MenuRegistry {
    private final DeferredRegister<@NotNull MenuType<?>> MENUS;

    public MenuRegistry(String modId) {
        MENUS = DeferredRegister.create(Registries.MENU, modId);
    }

    public void register() {
        MENUS.register(PufferfishAPI.eventBus);
    }

    public MenuRegistryHolder<ChestMenu> registerChestMenu(String name, ChestMenu chestMenu, ChestSettings chestSettings) {
        return new MenuRegistryHolder<ChestMenu>(registerMenuType(name, (containerId, inv, extraData) -> new ChestMenu(containerId, inv, extraData, chestSettings)));
    }

    private <T extends AbstractContainerMenu> DeferredHolder<@NotNull MenuType<?>, @NotNull MenuType<@NotNull T>> registerMenuType(String name, IContainerFactory<@NotNull T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }
}
