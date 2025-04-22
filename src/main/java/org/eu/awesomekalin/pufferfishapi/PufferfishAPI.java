package org.eu.awesomekalin.pufferfishapi;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(PufferfishAPI.MODID)
public class PufferfishAPI {
    public static final String MODID = "pufferfishapi";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static FMLJavaModLoadingContext context;

    public PufferfishAPI(FMLJavaModLoadingContext loadingContext) {
        LOGGER.info("Initialising Pufferfish API");
        context = loadingContext;
    }

    public static String getMinecraftVersion() {
        return "1.21.5";
    }

    public static String getModLoader() {
        return "Forge";
    }
}
