package org.eu.awesomekalin.pufferfishapi;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

import java.util.function.Consumer;

@EventBusSubscriber(modid = PufferfishAPI.MODID, value = Dist.CLIENT)
public class ModEventBusClient {
    public static final ObjectArrayList<Consumer<RegisterMenuScreensEvent>> SCREENS_TO_REGISTER = new ObjectArrayList<>();

    @SubscribeEvent
    public static void registerScreen(RegisterMenuScreensEvent screensEvent) {
        SCREENS_TO_REGISTER.forEach(consumer -> consumer.accept(screensEvent));
    }
}
