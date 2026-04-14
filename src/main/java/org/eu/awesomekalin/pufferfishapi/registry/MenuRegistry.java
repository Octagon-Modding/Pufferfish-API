package org.eu.awesomekalin.pufferfishapi.registry;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import org.eu.awesomekalin.pufferfishapi.holders.MenuRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.menus.ChestMenu;
import org.eu.awesomekalin.pufferfishapi.menus.ChestScreen;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;
import org.jetbrains.annotations.NotNull;

public class MenuRegistry {
    private final String modId;

    public MenuRegistry(String modId) {
        this.modId = modId;
    }

    public void register() {}

    public MenuRegistryHolder<ChestMenu> registerChestMenu(String name, ChestSettings chestSettings) {
        final MenuType<@NotNull ChestMenu> SCREEN_HANDLER = Registry.register(BuiltInRegistries.MENU, ResourceLocation.fromNamespaceAndPath(this.modId, name), new ExtendedScreenHandlerType<>((containerId, inventory, pos) -> new ChestMenu(containerId, inventory, pos, chestSettings), BlockPos.STREAM_CODEC));
        MenuScreens.register((MenuType<@NotNull ChestMenu>) SCREEN_HANDLER, (MenuScreens.ScreenConstructor<ChestMenu, ChestScreen>) (menu, inventory, component) -> new ChestScreen(menu, inventory, chestSettings));
        return new MenuRegistryHolder<>(SCREEN_HANDLER);
    }
}