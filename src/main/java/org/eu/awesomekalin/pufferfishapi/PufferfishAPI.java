package org.eu.awesomekalin.pufferfishapi;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(PufferfishAPI.MODID)
public class PufferfishAPI {
    public static final String MODID = "pufferfishapi";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static IEventBus eventBus;

    public PufferfishAPI(IEventBus modEventBus) {
        LOGGER.info("Initialising Pufferfish API");
        eventBus = modEventBus;
    }

    public static String getMinecraftVersion() {
        return "1.21.8";
    }

    public static String getModLoader() {
        return "NeoForge";
    }
}
