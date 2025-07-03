package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.ItemRegistryHolder;

import java.util.List;

public class CreativeTabRegistry {
    private final DeferredRegister<CreativeModeTab> register;

    public CreativeTabRegistry(String modId) {
        register = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, modId);
    }

    public void register() {
        register.register(PufferfishAPI.context.getModBusGroup());
    }

    public void registerTab(String tabId, String titleIdentifier, ItemRegistryHolder icon, List<ItemRegistryHolder> tabContents) {
        register.register(tabId, () -> CreativeModeTab.builder()
                .title(Component.translatable(titleIdentifier))
                .icon(() -> icon.data.get().getDefaultInstance())
                .displayItems((params, output) -> {
                    tabContents.forEach((item) -> {
                        output.accept(item.data.get().getDefaultInstance());
                    });
                }).build()
        );
    }
}
