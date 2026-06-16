package org.eu.awesomekalin.pufferfishapi;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class PufferfishAPI implements ModInitializer {
    public static final String MODID = "pufferfishapi";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        LOGGER.info("Initialising Pufferfish API");
    }

    public static String getMinecraftVersion() {
        return "26.2";
    }

    public static String getModLoader() {
        return "Fabric";
    }
}
