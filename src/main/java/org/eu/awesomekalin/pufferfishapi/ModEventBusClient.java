package org.eu.awesomekalin.pufferfishapi;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.function.Consumer;

@Mod.EventBusSubscriber(modid = PufferfishAPI.MODID, value = Dist.CLIENT)
public class ModEventBusClient {
    public static final ObjectArrayList<Consumer<FMLClientSetupEvent>> SCREENS_TO_REGISTER = new ObjectArrayList<>();

    @SubscribeEvent
    private static void clientSetup(FMLClientSetupEvent event) {
        SCREENS_TO_REGISTER.forEach((consumer) -> event.enqueueWork(() -> consumer.accept(event)));
    }
}