package org.eu.awesomekalin.pufferfishapi.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.eu.awesomekalin.pufferfishapi.PufferfishAPI;
import org.eu.awesomekalin.pufferfishapi.holders.BlockRegistryHolder;
import org.eu.awesomekalin.pufferfishapi.holders.ItemRegistryHolder;

import java.util.List;

public class CreativeTabRegistry {
    private final DeferredRegister<CreativeModeTab> register;

    public CreativeTabRegistry(String modId) {
        register = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, modId);
    }

    public void register() {
        register.register(PufferfishAPI.eventBus);
    }

    public void registerTab(String tabId, String titleIdentifier, Object icon, List<Object> tabContents) {
        register.register(tabId, () -> CreativeModeTab.builder()
                .title(Component.translatable(titleIdentifier))
                .icon(() -> {
                    if (icon instanceof ItemRegistryHolder itemIcon) {
                        return itemIcon.data.get().getDefaultInstance();
                    } else if (icon instanceof BlockRegistryHolder blockIcon) {
                        return blockIcon.dataItem.get().getDefaultInstance();
                    }
                    PufferfishAPI.LOGGER.error("Invalid Creative Mode Tab Icon specified by mod. Crash will occur when opening the creative mode inventory.");
                    return null;
                })
                .displayItems((params, output) -> {
                    tabContents.forEach((item) -> {
                        if (item instanceof ItemRegistryHolder itemData) {
                            output.accept(itemData.data.get().getDefaultInstance());
                        } else if (item instanceof BlockRegistryHolder blockData) {
                            output.accept(blockData.dataItem.get().getDefaultInstance());
                        }
                    });
                }).build()
        );
    }
}