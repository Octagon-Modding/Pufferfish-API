package org.eu.awesomekalin.pufferfishapi.registry;

import org.eu.awesomekalin.pufferfishapi.ModEventBusClient;
import org.eu.awesomekalin.pufferfishapi.holders.MenuRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.menus.ChestMenu;
import org.eu.awesomekalin.pufferfishapi.menus.ChestScreen;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;

public class ClientRegistry {
    public static void registerChestScreen(MenuRegistryHolder<ChestMenu> menu, ChestSettings chestSettings) {
        ModEventBusClient.SCREENS_TO_REGISTER.add(event -> event.register(menu.data.get(), (menu1, inv, component) -> new ChestScreen(menu1, inv, chestSettings)));
    }
}
