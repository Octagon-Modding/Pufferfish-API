package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.client.gui.screens.MenuScreens;
import org.eu.awesomekalin.pufferfishapi.ModEventBusClient;
import org.eu.awesomekalin.pufferfishapi.menus.ChestMenu;
import org.eu.awesomekalin.pufferfishapi.menus.ChestScreen;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;
import org.jetbrains.annotations.NotNull;

public class ClientRegistry {
    public static void registerChestScreen(ChestSettings chestSettings) {
        ModEventBusClient.SCREENS_TO_REGISTER.add(event -> event.register(chestSettings.menu.data.get(), (MenuScreens.ScreenConstructor<@NotNull ChestMenu, @NotNull ChestScreen>) (menu1, inv, component) -> new ChestScreen(menu1, inv, chestSettings)));
    }
}