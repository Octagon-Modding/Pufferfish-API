package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.eu.awesomekalin.pufferfishapi.ModEventBusClient;
import org.eu.awesomekalin.pufferfishapi.menus.ChestMenu;
import org.eu.awesomekalin.pufferfishapi.menus.ChestScreen;
import org.eu.awesomekalin.pufferfishapi.util.ChestSettings;

public class ClientRegistry {
    public static void registerChestScreen(ChestSettings chestSettings) {
        ModEventBusClient.SCREENS_TO_REGISTER.add((event) -> MenuScreens.register(chestSettings.menu.data.get(), (ChestMenu menu1, Inventory inv, Component component) -> new ChestScreen(menu1, inv, chestSettings)));
    }
}