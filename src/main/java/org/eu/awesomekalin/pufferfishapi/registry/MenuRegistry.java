package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
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
        MENUS.register(PufferfishAPI.context.getModEventBus());
    }

    public MenuRegistryHolder<ChestMenu> registerChestMenu(String name, ChestSettings chestSettings) {
        return new MenuRegistryHolder<>(registerMenuType(name, (containerId, inv, extraData) -> new ChestMenu(containerId, inv, extraData, chestSettings)));
    }

    private <T extends AbstractContainerMenu> RegistryObject<@NotNull MenuType<@NotNull T>> registerMenuType(String name, IContainerFactory<@NotNull T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }
}