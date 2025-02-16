package org.eu.awesomekalin.pufferfishapi;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

public class PufferfishAPI implements ModInitializer {
    public static final String MODID = "pufferfishapi";
    private static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        LOGGER.info("Initialising Pufferfish API");
    }

    public String getMinecraftVersion() {
        return "1.21.4";
    }

    public String getModLoader() {
        return "Fabric";
    }
}
